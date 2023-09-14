package com.ms.zoo.gallery;

import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.zoo.member.ZooMember;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Service
public class GalleryDAO {

	@Autowired
	private SqlSession ss;
	
	
	public void get(HttpServletRequest request,Gallery gr) {
		try {
			List<Gallery>ggr=ss.getMapper(GalleryMapper.class).get(gr);
			request.setAttribute("ggr", ggr);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	

	public void upload(HttpServletRequest request, Gallery gr) {
		MultipartRequest mr = null;
		String path = request.getSession().getServletContext().getRealPath("resources/gallery");
		System.out.println(path);
		try {

			mr = new MultipartRequest(request, path, 10 * 1024 * 1024, "utf-8", new DefaultFileRenamePolicy());

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "이미지 업로드 실패");
			return;
		}

		try {
			String token=mr.getParameter("token");
			String lasttoken=(String) request.getSession().getAttribute("lasttoken");
			if (lasttoken != null && token.equals(lasttoken)) {
				request.setAttribute("result", "새로고침 실패");
				return;
			}
			ZooMember m = (ZooMember) request.getSession().getAttribute("loginMember");
			gr.setZg_uploader(m.getZm_id());
			String zg_photo = URLEncoder.encode(mr.getFilesystemName("zg_photo"), "utf-8").replace("+", " ");
			gr.setZg_photo(zg_photo);
			gr.setZg_title(mr.getParameter("zg_title"));

			if (ss.getMapper(GalleryMapper.class).upload(gr) == 1) {
				request.setAttribute("result", "업로드성공");
				request.getSession().setAttribute("lasttoken",token);

			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "업로드 실패");
		}

	}

}
