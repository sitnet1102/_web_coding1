package com.spring.demo;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomeController {
	
	

	@RequestMapping(value = "/", method = RequestMethod.GET)	
	public String home() {		
		System.out.println("=============home()=============");
		return "index";
	}
	@RequestMapping(value = "/index", method = RequestMethod.GET)	
	public String index() {		
		System.out.println("=============index()=============");
		return "index";
	}
	@RequestMapping(value="/join" , method = RequestMethod.GET)
	public String join() {
		System.out.println("=============join()=============");
		return "join";
	}
	
	@RequestMapping(value="/joinPro" , method = RequestMethod.POST)
	public String joinPro(Model model, HttpServletRequest request) {
		System.out.println("=============joinPro()=============");
		
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		model.addAttribute("name", name);	
		return "joinPro";
	}
	@RequestMapping(value="/login" , method = RequestMethod.GET)
	public String login() {
		System.out.println("=============login()=============");
		
		return "login";
	}
	
	@RequestMapping(value="/loginPro" , method = RequestMethod.POST)
	public String loginPro() {
		System.out.println("=============loginPro()=============");

		return "loginPro";
	}
	
	
}
