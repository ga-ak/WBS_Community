package com.example.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	
	@RequestMapping("/main.do") 
	public String mainPage () {
		return "main";
	}
	
	@RequestMapping("/board/*.do")
	public String boardPage(HttpServletRequest req, HttpServletResponse resp) {
		String targetPage = "/board/";
		System.out.println(targetPage);
		return targetPage;
	}
}
