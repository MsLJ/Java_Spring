package com.ms.zoo.dataroom;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.zoo.member.ZooMember;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Service
public class DataRoomDAO {

	@Autowired
	private SqlSession ss;

	// txt
	// csv
	public void download(HttpServletRequest request, DataRoomFile drf, HttpServletResponse res) {
		// byte단위로
		// 파일에서 내용 읽어내서(쌩 java로)
		FileInputStream fis = null;

		// 클라이언트에게 응답(tomcat)
		ServletOutputStream sos = null;
		try {
			String path = request.getSession().getServletContext().getRealPath("resources/data");
			System.out.println(path);
			String file = drf.getZd_file();
			String fileOriginal = URLDecoder.decode(file, "utf-8");

			System.out.println(file);
			fis = new FileInputStream(path + "/" + fileOriginal);
			System.out.println(fis);
			// 응답에 혹시 뭔가 들어가있을까
			res.reset();// 응답객체 비우기

			// html을 응답할게 아니고, 파일을 줄거니까
			res.setContentType("application/octet-stream");
			res.setHeader("Content-Disposition", "attachment; filename=" + file);

			sos = res.getOutputStream();
			byte[] b = new byte[4096];// 4096byte(4kbyte)씩 처리하려고
											// 왜? 다른숫자 넣어도 되는데
											// 남들 다 저렇게 해서
											// (연구결과 저만큼씩 하는게 제일 낫다)
			int data=0;
			//0~4095번까지 읽어서 b에 저장
			//b에 저장한거를 data에 저장
			//data에 저장된게 없지 않을동안 반복
			while ((data=fis.read(b,0,b.length))!=-1) {
				//b에 저장된것을 응답용 빨대에 쏘기
				sos.write(b,0,b.length);
				
			}
				sos.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			sos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			fis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void delete(HttpServletRequest request, DataRoomFile drf) {

		try {
			String file = ss.getMapper(DataRoomMapper.class).getfile(drf);
			if (ss.getMapper(DataRoomMapper.class).delete(drf) == 1) {
				request.setAttribute("result", "삭제성공");
				String path = request.getSession().getServletContext().getRealPath("resources/data");
				file = URLDecoder.decode(file, "utf-8");
				new File(path + "/" + file).delete();

			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "삭제실패");
		}

	}

	public void upload(HttpServletRequest request, DataRoomFile drf) {
		MultipartRequest mr = null;
		String path = request.getSession().getServletContext().getRealPath("resources/data");
		System.out.println(path);
		try {
			mr = new MultipartRequest(request, path, 10 * 1024 * 1024, "utf-8", new DefaultFileRenamePolicy());

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "데이터실 업로드 실패(파일 문제)");
			return;
		}

		try {
			String token = mr.getParameter("token");
			String lasttoken = (String) request.getSession().getAttribute("lasttoken");

			if (lasttoken != null && token.equals(lasttoken)) {
				request.setAttribute("result", "새로고침 실패");
				return;
			}
//			zd_no number(3) primary key,
//			zd_uploader varchar2(1 char)not null,
//			zd_title varchar2(300 char)not null,
//			zd_file varchar2(100 char) not null,
//			zd_category varchar2 (6 char)not null,
//			zd_date date not null,
			ZooMember m = (ZooMember) request.getSession().getAttribute("loginMember");

			drf.setZd_uploader(m.getZm_id());
			String zd_file = URLEncoder.encode(mr.getFilesystemName("zd_file"), "utf-8").replace("+", " ");
			System.out.println(zd_file);
			drf.setZd_file(zd_file);
			System.out.println(mr.getParameter("zd_category"));
			System.out.println(mr.getParameter("zd_title"));
			drf.setZd_category(mr.getParameter("zd_category"));
			drf.setZd_title(mr.getParameter("zd_title"));

			if (ss.getMapper(DataRoomMapper.class).upload(drf) == 1) {
				request.setAttribute("result", "업로드 성공");
				request.getSession().setAttribute("lasttoken", token);

			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "업로드 실패");
			new File(path + "/" + mr.getFilesystemName("zd_file")).delete();
		}

	}

	public void getData(HttpServletRequest request) {

		try {
			DataRoomFile drf = new DataRoomFile(null, null, null, null, request.getParameter("zd_category"), null);
			List<DataRoomFile> drff = ss.getMapper(DataRoomMapper.class).getdata(drf);
			request.setAttribute("drf", drff);

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

}
