package com.spring.demo.board;

import java.util.Map;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

public class BoardList implements BoardCommand {

	@Autowired
	BoardDao bdao;

	@Override
	public void execute(Model model) {
		
		System.out.println("list execute()");
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		int pageSize = 10;
		String pageNumber = request.getParameter("pageNum");

		if(pageNumber == null) {
			pageNumber = "1";
		}
		int count = 0;
		int number = 0;		
		int currentPage = Integer.parseInt(pageNumber);	
		
		count = bdao.getAllCount();
			
		int startRow = (currentPage - 1) * pageSize;
		
		
	
		Vector<Board> v = bdao.getAllBoard(startRow, pageSize);
		number = count - (currentPage - 1) * pageSize;
		
		
		request.setAttribute("v", v);
		request.setAttribute("number", number);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("count", count);
		request.setAttribute("currentPage", currentPage);
	}

}