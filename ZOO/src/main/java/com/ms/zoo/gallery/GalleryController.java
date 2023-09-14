package com.ms.zoo.gallery;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ms.zoo.TokenGenerator;
import com.ms.zoo.member.MemberDAO;

@Controller
public class GalleryController {
	
	
	@Autowired
	private TokenGenerator tGT;
		@Autowired
		private MemberDAO mDAO;
		@Autowired
		private GalleryDAO gDAO;
		
		
		
		@RequestMapping(value = "/gallery.go", method = RequestMethod.GET)
		public String goGallery(HttpServletRequest request,Gallery gr) {
			gDAO.get(request, gr);
			tGT.generate(request);
		mDAO.islogined(request);
			request.setAttribute("cp", "gallery/gallery.jsp");
			return "index";
			
		}
		@RequestMapping(value = "/gallery.upload", method = RequestMethod.POST)
		public String uploadGallery(HttpServletRequest request,Gallery gr) {
			if (mDAO.islogined(request)) {
				gDAO.upload(request, gr);
				
			}
			gDAO.get(request, gr);
			tGT.generate(request);
			request.setAttribute("cp", "gallery/gallery.jsp");
			return "index";
			
		}
	
	

}
