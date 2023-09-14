package com.ms.zoo.dataroom;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ms.zoo.TokenGenerator;
import com.ms.zoo.member.MemberDAO;
import com.ms.zoo.member.ZooMember;
import com.ms.zoo.sns.SNSDAO;

@Controller
public class DataRoomController {

	@Autowired
	private TokenGenerator tGT;
	@Autowired
	private MemberDAO mDAO;

	@Autowired
	private DataRoomDAO dDao;
	@Autowired
	private SNSDAO sDAO;

	@RequestMapping(value = "/dataroom.go", method = RequestMethod.GET)
	public String goDataRoom(HttpServletRequest request, ZooMember m, DataRoomFile drf) {
		if (mDAO.islogined(request)) {
			dDao.getData(request);
			request.setAttribute("cp", "dataroom/dataroom.jsp");
			
		}else {
			sDAO.snsGet(request, 1);
			request.setAttribute("cp", "home.jsp");
		}
		
		tGT.generate(request);
		return "index";

	}

	@RequestMapping(value = "/dataroom.upload", method = RequestMethod.POST)
	public String uploadDataRoom(HttpServletRequest request, DataRoomFile drf) {
		if (mDAO.islogined(request)) {
			dDao.upload(request, drf);

		}
		tGT.generate(request);
		dDao.getData(request);
		request.setAttribute("cp", "dataroom/dataroom.jsp");
		return "index";

	}

	@RequestMapping (value="/dataroom.download", method=RequestMethod.GET)
	public String downloadDataRoom(HttpServletRequest request, DataRoomFile drf, HttpServletResponse res) {
		if (mDAO.islogined(request)) {
			System.out.println(drf.getZd_file());
			dDao.download(request, drf, res);
			dDao.getData(request);
			request.setAttribute("cp", "dataroom/dataroom.jsp");

		} else {
			sDAO.clearsearch(request);
			sDAO.snsGet(request, 1);

			request.setAttribute("cp", "home.jsp");
		}
		tGT.generate(request);
		request.setAttribute("cp", "dataroom/dataroom.jsp");
		return "index";

	}

	@RequestMapping(value = "/dataroom.delete", method = RequestMethod.GET)
	public String deleteDataRoom(HttpServletRequest request, DataRoomFile drf) {
		if (mDAO.islogined(request)) {
			dDao.delete(request, drf);

		}
		tGT.generate(request);
		dDao.getData(request);
		request.setAttribute("cp", "dataroom/dataroom.jsp");
		return "index";

	}

}
