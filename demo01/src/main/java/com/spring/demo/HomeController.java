package com.spring.demo;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);		
	Test1 test = new Test1();		
	@Autowired
	Test1 test1;
	@Autowired
	Test1 test11;	
	@Resource(name="test")
	Test1 test111;	
		
	
	@Autowired
	Test2 test2;
	
	@Autowired
	Test3 test3;
		
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		test1.test1();
		test1.add(10);
		
		test11.test1();		
		test111.test1();
		test.test1();
			
		test2.print();
		
		
		String t3 = test3.getAaa();
		System.out.println(t3);
		
		List<String> t3List =   test3.getTestList();
		for(int i = 0; i < t3List.size(); i++) {
			System.out.println(t3List.get(i));
		}
		
		Map<String , String> t3Map = test3.getTestMap();
		for(String key : t3Map.keySet()) {
			System.out.println( key + " : " +   t3Map.get(key));
		}
		
		Map<String , Info> t3MapObj = test3.getTestMapObj();
		Iterator<String> iter =  t3MapObj.keySet().iterator();
		while(iter.hasNext()) {
			String key = iter.next();
			System.out.print(key + " : ");
			t3MapObj.get(key).printInfo();
		}
		
		
		
		return "home";
	}
}
