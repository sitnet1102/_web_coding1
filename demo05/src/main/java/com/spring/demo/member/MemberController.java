package com.spring.demo.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {
	@Autowired
	MemberService service;

	@ModelAttribute("cp")
	public String getContextPath(HttpServletRequest request) {
		return request.getContextPath();
	}

	@RequestMapping(value = "/")
	public String index() {
		System.out.println("==== index() ====");
		return "index";
	}

	@RequestMapping(value = "/member/joinForm")
	public String joinForm() {
		System.out.println("==== joinForm() ==== ");
		return "member/joinForm";
	}

	@RequestMapping(value = "/member/joinPro", method = RequestMethod.POST)
	public String joinPro(Member member) {
		System.out.println("==== joinPro() ==== ");

		service.memberJoin(member);
		return "member/joinPro";
	}

	@RequestMapping(value = "/member/loginForm")
	public String loginForm() {
		System.out.println("==== loginForm() ==== ");
		return "member/loginForm";
	}

	@RequestMapping(value = "/member/loginPro", method = RequestMethod.POST)
	public String loginPro(Member member, HttpSession session, Model model, HttpServletRequest request) {

		System.out.println("==== loginPro() ==== ");
		Member mem = service.memberSearch(member);
		if (mem == null)
			return "/member/loginForm";

		session.setAttribute("member", mem);

		return "/member/loginPro";
	}

	// Modify
	@RequestMapping(value = "/member/modifyForm")
	public String modifyForm(HttpServletRequest request, Model model) {

		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("member");
		Member mem = service.memberSearch(member);
		if (mem == null)
			return "/member/loginForm";
		model.addAttribute("member", mem);
		String path = "/member/modifyForm";
		return path;
	}

	@RequestMapping(value = "/member/modifyPro", method = RequestMethod.POST)
	public String modify(Member member, HttpServletRequest request, Model model) {

		HttpSession session = request.getSession();

		Member mem = service.memberModify(member);

		String path = "/member/modifyPro";
		if (mem == null) {
			path = "/member/modifyForm";
		} else {
			session.setAttribute("member", mem);
			model.addAttribute("memAft", mem);
		}

		return path;
	}

	// Logout
	@RequestMapping("/member/logout")
	public String memLogout(Member member, HttpSession session) {

		session.invalidate();

		return "/member/logoutPro";
	}

	// Remove
	@RequestMapping("/member/removeForm")
	public String removeForm(HttpServletRequest request , Model model) {

		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("member");

		model.addAttribute("member", member);
			
		String path = "/member/removeForm";
		return path;
	}
	@RequestMapping(value = "/member/removePro", method = RequestMethod.POST)
	public String memRemove(Member member, HttpServletRequest request) {
		
		int result = service.memberRemove(member);
		
		if(result == 0)
			return "/member/removeForm";
		
		HttpSession session = request.getSession();
		session.invalidate();
		
		return "/member/removePro";
	}
}