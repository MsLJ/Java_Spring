
package com.ms.zoo.member;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ms.zoo.TokenGenerator;
import com.ms.zoo.sns.SNSDAO;

@Controller
public class MemberController {
	@Autowired
	private MemberDAO mDAO;
	@Autowired
	private TokenGenerator tGT;

	@Autowired
	private SNSDAO sDAO;
	
	// 파일업로드때는 mr.getparameter("파라메터명")으로 시작이니
	
	
	@RequestMapping(value="/member.get2",method=RequestMethod.GET)
	public @ResponseBody zooMembers getmember(HttpServletRequest request,ZooMember m) {
		zooMembers members=mDAO.get2(m);
		return members;
	}
	
	
	

	@RequestMapping(value = "/member.join", method = RequestMethod.POST)
	public String memberJoin(HttpServletRequest request, ZooMember m) {
		mDAO.islogined(request);
		mDAO.join(request, m);
		tGT.generate(request);
		request.setAttribute("cp", "member/join.jsp");
		return "index";

	}

	@RequestMapping(value = "/member.join.go", method = RequestMethod.GET)
	public String memberJoinGo(HttpServletRequest request) {
		mDAO.islogined(request);
		tGT.generate(request);
		request.setAttribute("cp", "member/join.jsp");
		return "index";

	}

	@RequestMapping(value = "/member.info.go", method = RequestMethod.GET)
	public String memberInfo(HttpServletRequest request) {
		if (mDAO.islogined(request)) {
			mDAO.splitAddr(request);
			request.setAttribute("cp", "member/info.jsp");

		} else {
			sDAO.clearsearch(request);
			tGT.generate(request);
			sDAO.snsGet(request,1);
			request.setAttribute("cp", "home.jsp");
		}
		return "index";

	}

	@RequestMapping(value = "/member.info.update", method = RequestMethod.POST)
	public String memberInfoupdate(HttpServletRequest request, ZooMember m) {
		if (mDAO.islogined(request)) {
			mDAO.update(request, m);
			mDAO.splitAddr(request);
			request.setAttribute("cp", "member/info.jsp");
		} else {
			
			tGT.generate(request);
			sDAO.clearsearch(request);
			sDAO.snsGet(request,1);
			request.setAttribute("cp", "home.jsp");

		}
		return "index";

	}

	@RequestMapping(value = "/member.bye", method = RequestMethod.GET)
	public String memberbye(HttpServletRequest request) {
		if (mDAO.islogined(request)) {
			mDAO.deleteMem(request);
		}
		tGT.generate(request);
		sDAO.clearsearch(request);
		sDAO.snsGet(request,1);
		request.setAttribute("cp", "home.jsp");
		return "index";

	}

	@RequestMapping(value = "/member.login", method = RequestMethod.POST)
	public String memberLogin(HttpServletRequest request, ZooMember m) {
		mDAO.login(m, request);
		sDAO.clearsearch(request);
		mDAO.islogined(request);
		sDAO.snsGet(request,1);
		tGT.generate(request);
		request.setAttribute("cp", "home.jsp");
		return "index";

	}

	@RequestMapping(value = "/member.logout", method = RequestMethod.GET)
	public String memberLogout(HttpServletRequest request, ZooMember m) {
		mDAO.logout(request);
		mDAO.islogined(request);
		sDAO.clearsearch(request);
		sDAO.snsGet(request,1);
		tGT.generate(request);
		request.setAttribute("cp", "home.jsp");
		return "index";

	}

}
