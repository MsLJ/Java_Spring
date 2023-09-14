package com.ms.jun164ucv;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.apache.taglibs.standard.lang.jstl.Evaluator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.tags.EvalTag;

@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		try {
		// String으로 계산식 계산- Java는 불가능
		// Java는 불가능한데,JavaScript는 가능
		// Java가 javaScript를 가져다쓰는게 가능
		ScriptEngineManager sem=new ScriptEngineManager();
		ScriptEngine se=sem.getEngineByName("javascript");
		String s="10+5*2";
			System.out.println(se.eval(s));
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "input";
	}

}
