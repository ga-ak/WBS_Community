package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Test {
	
	@RequestMapping("/hello.do")
	public ModelAndView sayHello() {
		System.out.println("hello entered!");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("hello");
		mav.addObject("hello", "hello jsp!");
		return mav;
	}
}
