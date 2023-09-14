package com.ms.jun261xmljson.biskit;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Biskits {//DB테이블을 표현하는 JavaBean
	//변수명은 단수형 추천
	private List<Biskit> biskit;

	public Biskits() {
		// TODO Auto-generated constructor stub
	}

	public Biskits(List<Biskit> biskit) {
		super();
		this.biskit = biskit;
	}

	public List<Biskit> getBiskit() {
		return biskit;
	}
	@XmlElement
	public void setBiskit(List<Biskit> biskit) {
		this.biskit = biskit;
	}

}
