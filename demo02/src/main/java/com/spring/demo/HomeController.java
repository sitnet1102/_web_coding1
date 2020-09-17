package com.spring.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@Autowired
	StudentController controller;
	
	@RequestMapping(value = "/")
	public String home() {
		
		String [] id = {"test" , "koreait" , "stst" , "jsp" };
		String[] name = {"이만수" , "김철수" ,"이영희" , "유재석"};
		int [] num = {1001, 1002, 1003 , 1004};
			
		//StudentController controller = new StudentController();		
		StudentInsert stInsert = controller.getInsert();	
		for(int i = 0; i < id.length; i++) {
			Student st = new Student(num[i] , id[i] , name[i]);
			stInsert.insert(st);
		}				
		StudentSelect stSelect = controller.getSelect();
		Student st = stSelect.select("test");
		if(st != null) st.print();
				
		StudentSelectAll stAll = controller.getSelectAll();
		stAll.printAll();
		
		return "home";
	}
	
}
