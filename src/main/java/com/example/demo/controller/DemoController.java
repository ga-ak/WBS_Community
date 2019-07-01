package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.demo.vo.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.DemoService;

@Controller
public class DemoController {

    @Autowired
    DemoService service;

    @RequestMapping("/main.do")
    public String mainPage() {
        return "main";
    }

    @RequestMapping("/rep.do")
    public String repTest(Model model) {
        List<HashMap<String, Integer>> repList = service.selectAllRep();
        System.out.println(repList);
        model.addAttribute("repList", repList);
        return "repTest";
    }

    @RequestMapping(value = "/join.do", method = RequestMethod.POST)
    public String join(@ModelAttribute MemberVO member) {
        service.insertMember(member);
        return "redirect:main.do";
    }

    @RequestMapping("/memberList.do")
    public String memberList(Model model) {
        List<MemberVO> result = service.selectAllMember();
        System.out.println(result);
        model.addAttribute("memberList", result);
        return "main_area/lists/memberList";
    }

    @RequestMapping("/*Form.do")
    public String getForm(HttpServletRequest req) {
        String uri = req.getRequestURI();
        String result = uri.substring(uri.lastIndexOf("/")+1, uri.lastIndexOf("."));
        System.out.println(result);
        return "main_area/forms/"+result;
    }

    @RequestMapping("/*List.do")
    public String getList(HttpServletRequest req) {
        String uri = req.getRequestURI();
        String result = uri.substring(uri.lastIndexOf("/")+1, uri.lastIndexOf("."));
        System.out.println(result);
        return "main_area/lists/"+result;
    }
}
