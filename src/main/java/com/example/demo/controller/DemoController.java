package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.DemoService;

@Controller
public class DemoController {

	@Autowired
	DemoService service;

	@RequestMapping("/main.do")
	public String mainPage () {
		System.out.println(service.selectAllId());
		return "main";
	}

//	@RequestMapping("/board/*.do")
//	public String boardPage(HttpServletRequest req, HttpServletResponse resp) {
//		String targetPage = "/board/";
//		System.out.println(targetPage);
//		return targetPage;
//	}
}
