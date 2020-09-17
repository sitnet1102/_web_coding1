package com.spring.demo.board;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

public class BoardReWriteView  implements BoardCommand {
	@Autowired
	BoardDao bdao;

	@Override
	public void execute(Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
	
				
		int num = Integer.parseInt(request.getParameter("num"));
		Board bean = bdao.getOneBoard(num);
		
		int ref = bean.getRef();
		int re_step = bean.getRe_step();
		int re_level = bean.getRe_level();
		
		System.out.println("Ref" + ref);
		
		request.setAttribute("ref", ref);
		
		request.setAttribute("re_step",re_step);
		request.setAttribute("re_level", re_level);
	}

}
