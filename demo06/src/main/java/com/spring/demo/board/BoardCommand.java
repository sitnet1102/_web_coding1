package com.spring.demo.board;

import org.springframework.ui.Model;

public interface BoardCommand {
	
	void execute(Model model);
	
}