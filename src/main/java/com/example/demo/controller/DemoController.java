package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.DemoService;

@Controller
public class DemoController {

    @Autowired
    DemoService service;

    @RequestMapping("/main.do")
    public String demo(HttpServletRequest req, HttpServletResponse resp) {
		return "main";
    }

    @RequestMapping("/rep.do")
    public String repTest(Model model) {
        List<HashMap> repList = service.selectAllRep();
        System.out.println(repList);
        model.addAttribute("repList", repList);
        return "repTest";
    }

	@RequestMapping("/insert_test.do")
	public String insertTest(@RequestParam HashMap inputValues) {
		service.insertRep(inputValues);
		return "redirect:/rep.do";
	}

}
