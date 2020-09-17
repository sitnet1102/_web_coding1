package com.spring.demo.board;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

public class BoardWrite implements BoardCommand{
	@Autowired
	BoardDao bdao;
	
	@Override
	public void execute(Model model) {
		
		System.out.println("write execute()");
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpSession session = request.getSession();
		
		Board bean = new Board();
		bean.setWriter(request.getParameter("writer"));
		bean.setSubject(request.getParameter("subject"));
		bean.setEmail(request.getParameter("email"));
		bean.setPassword(request.getParameter("password"));
		bean.setContent(request.getParameter("content"));	
		
		bdao.insertBoard(bean);
		
		
	}

}
