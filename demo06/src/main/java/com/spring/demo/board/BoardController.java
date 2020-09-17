package com.spring.demo.board;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BoardController {

	BoardCommand command = null;
	
	@Autowired
	BoardWrite bWrite;
	@Autowired
	BoardList bList;
	@Autowired
	BoardInfo bInfo;
	@Autowired
	BoardReWrite bReWrite;
	@Autowired
	BoardReWriteView bReWriteView;
	
	@ModelAttribute("cp")
	public String getContextPath(HttpServletRequest  request) {
		return request.getContextPath();
	}
	
	@RequestMapping(value = "/")
	public String index() {
		System.out.println("index()");		
		return "index";
	}
	
	@RequestMapping("/list")
	public String list(HttpServletRequest request, Model model) {
		System.out.println("list()");
		model.addAttribute("request", request);
		command = bList;
		command.execute(model);
		
		return "board/list";
	}
	
	@RequestMapping("/write_view")
	public String write_view(Model model) {
		System.out.println("write_view()");	
		return "board/write";
	}
	
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {
		System.out.println("write()");	
		model.addAttribute("request", request);
		command = bWrite;
		command.execute(model);	
		return "redirect:list";		
	}
	
	@RequestMapping("/info")
	public String info(HttpServletRequest request, Model model) {
		System.out.println("info()");
		
		model.addAttribute("request", request);
		command = bInfo;
		command.execute(model);
		
		return "board/info";
	}
	
	@RequestMapping("/reWrite_view")
	public String reply_view(HttpServletRequest request, Model model) {
		System.out.println("reWrite_view()");
		
		model.addAttribute("request", request);
		command = bReWriteView;
		command.execute(model);
		
		return "board/reWrite";
	}
	
	
	
	@RequestMapping("/reWrite")
	public String reWrite(HttpServletRequest request, Model model) {
		System.out.println("reWrite()");
		
		model.addAttribute("request", request);
		command = bReWrite;
		command.execute(model);
		
		return "redirect:list";
	}
	
}
