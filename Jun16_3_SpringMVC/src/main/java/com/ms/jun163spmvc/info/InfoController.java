package com.ms.jun163spmvc.info;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class InfoController {
	// GET: 주소에
	// 인터넷주소에 한글x
	// ㅋ->%2A(URL인코딩)형태로 들어가야
	// ㅋ-utf-8->%2A->utf-8->ㅋ:톰캣이 자동으로 하는데 형식을 마음대로 쓰니
	// 형식을 지정해주기 위해 server.xml파일에 인코딩 부분에 utf-8을추가
	// =>톰캣설정 (server.xml)으로 해결

	// POST:내부적
	// 파라메터 읽기전에 req.setCharacterEncoding("utf-8");
	// 해야하는데 이미Spring은 미리 다읽어놓고 준비중이기에
	// request.setCharacterEncoding은 못할것
	// 프로젝트(web.xml)에 인코딩방식을 추가하면 해결
	@Autowired
	private UserDAO u;

	@RequestMapping(value = "/info.print", method = RequestMethod.POST)
	public String goPrintInfo(UserInfo ui, HttpServletRequest request) {
		u.printUserInfo(ui, request);

		return "output";

	}

}
