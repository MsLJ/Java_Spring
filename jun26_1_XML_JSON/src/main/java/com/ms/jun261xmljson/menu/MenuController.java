package com.ms.jun261xmljson.menu;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MenuController {

	@Autowired
	private MenuDAO mDAO;

	// produces같은 경우에는 원래 자동으로 처리해주는데 가끔 브라우저문제가 생겨 자동으로 안해줄때가있어서 넣어주기
	@RequestMapping(value = "/menu.get", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody Menus getmenu(@RequestParam(value = "page") int page, HttpServletResponse res) {
		// 지금 방식으로는 외부인들이 사용이 불가해서 외부인에게 XML/JSON응답하게 response
		res.setHeader("Access-Control-Allow-Origin", "*");
		return mDAO.getmenu2(page);
	}

}
