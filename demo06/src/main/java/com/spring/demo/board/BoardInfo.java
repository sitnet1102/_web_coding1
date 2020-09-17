package com.spring.demo.board;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

public class BoardInfo implements BoardCommand {

	@Autowired
	BoardDao bdao;

	@Override
	public void execute(Model model) {

		System.out.println("Info execute()");

		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		int num = Integer.parseInt(request.getParameter("num"));
		System.out.println(num);
		Board bean = bdao.getOneBoard(num);
		request.setAttribute("bean", bean);

	}

}
