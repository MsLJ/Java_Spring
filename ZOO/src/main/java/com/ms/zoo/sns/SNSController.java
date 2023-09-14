package com.ms.zoo.sns;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ms.zoo.TokenGenerator;
import com.ms.zoo.member.MemberDAO;

@Controller
public class SNSController {

	@Autowired
	private MemberDAO mDAO;

	@Autowired
	private SNSDAO sDAO;
	@Autowired
	private TokenGenerator tGT;

	@RequestMapping(value = "/sns.write", method = RequestMethod.GET)
	public String home(HttpServletRequest request, SNSMsg sm) {
		if (mDAO.islogined(request)) {
			sDAO.snsGet(request, 1);
			sDAO.snsWrite(request, sm);

		}
		sDAO.clearsearch(request);
		tGT.generate(request);
		request.setAttribute("cp", "home.jsp");
		return "index";
	}

	@RequestMapping(value = "/sns.re.write", method = RequestMethod.GET)
	public String writeSNSre(HttpServletRequest request, SNSReply sr, @RequestParam(value = "page") int p) {
		if (mDAO.islogined(request)) {
			sDAO.writeSNSReply(request, sr);

		}
		sDAO.snsGet(request, p);
		tGT.generate(request);
		request.setAttribute("cp", "home.jsp");
		return "index";
	}

	@RequestMapping(value = "/sns.search", method = RequestMethod.GET)
	public String search(HttpServletRequest request, SNSMsg sm) {
		mDAO.islogined(request);
		sDAO.search(request);
		sDAO.snsGet(request, 1);
		tGT.generate(request);
		request.setAttribute("cp", "home.jsp");
		return "index";
	}

	@RequestMapping(value = "/sns.delete", method = RequestMethod.GET)
	public String deleteMSG(HttpServletRequest request, SNSMsg sm) {
		if (mDAO.islogined(request)) {
			sDAO.deleteSNS(request, sm);

		}
		sDAO.snsGet(request, 1);
		tGT.generate(request);
		request.setAttribute("cp", "home.jsp");
		return "index";
	}

	@RequestMapping(value = "/sns.re.delete", method = RequestMethod.GET)
	public String deleteSNSRe(HttpServletRequest request, SNSReply sr,@RequestParam (value="page")int p) {
		if (mDAO.islogined(request)) {
			sDAO.deleteSNSRe(request, sr);

		}
		sDAO.snsGet(request, p);
		tGT.generate(request);
		request.setAttribute("cp", "home.jsp");
		return "index";
	}

	@RequestMapping(value = "/sns.update", method = RequestMethod.GET)
	public String updateMSG(HttpServletRequest request, SNSMsg sm, @RequestParam(value = "page") int p) {
		if (mDAO.islogined(request)) {
			sDAO.updateSNS(request, sm);
		}
		sDAO.snsGet(request, p);
		tGT.generate(request);
		request.setAttribute("cp", "home.jsp");
		return "index";
	}

	// 컨트롤러
	@RequestMapping(value = "/sns.page.change", method = RequestMethod.GET)
	public String snsPageChange(@RequestParam(value = "page") int p, HttpServletRequest request) {
		mDAO.islogined(request);// M
		sDAO.snsGet(request, p);// M
		sDAO.clearsearch(request);
		// C보다는 M에 가까운 M에서 하기 애매하니 @RequestParam을 이용해서 value를 받아와서
		// int p
//		int page=Integer.parseInt(request.getParameter("page"));//?
		tGT.generate(request);
		request.setAttribute("cp", "home.jsp");
		return "index";
	}

}
