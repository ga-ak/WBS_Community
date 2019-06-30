package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.DemoService;

@Controller
public class DemoController {

    @Autowired
    DemoService service;

    @RequestMapping("/demo.do")
    public ModelAndView demo(HttpServletRequest req, HttpServletResponse resp) {
        ModelAndView mav = new ModelAndView();

        List<String> idList = service.selectAllId();
        mav.addObject("idList", idList);
        mav.setViewName("demo");
        return mav;
    }

    @RequestMapping("/rep.do")
    public String repTest(Model model) {
        List<HashMap<String, Integer>> repList = service.selectAllRep();
        System.out.println(repList);
        model.addAttribute("repList", repList);
        return "repTest";
    }
}
