package com.ms.jun261xmljson.biskit;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BiskitDAO {
	@Autowired
	private SqlSession ss;
	public Biskits getbiskit2() {
		
		List<Biskit>biskit=ss.getMapper(BiskitMapper.class).get();
		Biskits biskits=new Biskits(biskit);
		return biskits;
	
	}
	public void getbiskit(HttpServletRequest request) {
		List<Biskit>bb= ss.getMapper(BiskitMapper.class).get();
		request.setAttribute("bb", bb);
	}
}
