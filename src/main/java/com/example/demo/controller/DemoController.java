package com.example.demo.controller;

import com.example.demo.service.DemoService;
import com.example.demo.vo.ArticleVO;
import com.example.demo.vo.MemberVO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@Controller
public class DemoController {

  @Autowired
  DemoService service;

  private static final Logger LOGGER = LogManager.getLogger(DemoController.class);

  @RequestMapping("/main.do")
  public String mainPage(HttpServletRequest req) {
    return "main";
  }

  @RequestMapping(value = "/join.do", method = RequestMethod.POST)
  public String join(@ModelAttribute MemberVO member) {
    service.insertMember(member);
    return "redirect:main.do";
  }

  @RequestMapping(value = "/login.do", method = RequestMethod.POST)
  public String login(@ModelAttribute MemberVO member, HttpServletRequest req) {
    MemberVO result = service.selectLogin(member);
    String formerUri = req.getHeader("referer");
    HttpSession session = req.getSession();
    session.setAttribute("loginMember", result);
    return "redirect:" + formerUri;
  }

  @RequestMapping("/logout.do")
  public String logout(HttpSession session, HttpServletRequest req) {
    String formerUri = req.getHeader("referer");
    session.removeAttribute("loginMember");
    return "redirect:" + formerUri;
  }

  @RequestMapping("/join.form")
  public String getForm(HttpServletRequest req, Model model) {

    String result = getLastUri(req);
    String formerUri = req.getHeader("referer");
    model.addAttribute("formerUri", formerUri);
    return "main_area/forms/" + result;
  }

  @RequestMapping("/memberList.do")
  public String memberList(Model model) {
    List<MemberVO> result = service.selectAllMember();
    model.addAttribute("memberList", result);
    return "main_area/lists/memberList";
  }

  @RequestMapping("/articleList.do")
  public String getList(HttpServletRequest req, HttpSession session) {
//    if (session.getAttribute("loginMember") != null) {
//      MemberVO loginMember = (MemberVO)session.getAttribute("loginMember");
//      LOGGER.debug(loginMember.getMember_id());
//    } else {
//      LOGGER.debug("loginMember에 아무값이 없음");
//    }
    String result = getLastUri(req);
    LOGGER.debug(result);
    return "main_area/lists/" + result;
  }

  @RequestMapping("board/**/article.form")
  public String getArticleForm(HttpSession session, HttpServletRequest req, Model model) {

    MemberVO loginMember = (MemberVO) session.getAttribute("loginMember");
    if (loginMember == null) {
      LOGGER.debug("session에 로그인 정보가 없음!");
      return "redirect:/board/" + "free" + ".do";
    }
    String result = getLastUri(req);
    String formerUri = req.getHeader("referer");
    model.addAttribute("formerUri", formerUri);
    return "main_area/forms/" + result;
  }

  @RequestMapping("/board/*.do")
  public String board(@RequestParam(value = "an", required = false) Integer articleNo, HttpServletRequest req, HttpSession session, Model model) {
    if (articleNo != null) {
      LOGGER.debug("articleNo : " + articleNo);

      HashMap articlePageModel = service.selectArticleById(articleNo);
      List<HashMap> replyList = service.selectReplyByArticleNo(articleNo);

      if (replyList.size()>0) {
        replyList.get(replyList.size() - 1).forEach((k, v) -> LOGGER.debug("key : " + k + ", value : " + v));
      }
//      LOGGER.debug("content test : "+articlePageModel.get("article_content"));
      model.addAttribute("articlePageModel", articlePageModel);
      model.addAttribute("replyList", replyList);
      model.addAttribute("replySize", replyList.size());

      return "main_area/pages/articlePage";
    } else {
      String lastUri = getLastUri(req);
      List<ArticleVO> articleList = service.selectArticleByBoardName(lastUri);
      model.addAttribute("articleList", articleList);
      LOGGER.debug(lastUri);
      return "main_area/lists/articleList";
    }
  }

  @RequestMapping("/board/**/postArticle.do")
  public String postArticle(@RequestParam HashMap<String, String> articleMap, HttpServletRequest req,
                            HttpSession session) {

    MemberVO loginMember = (MemberVO) session.getAttribute("loginMember");
    LOGGER.debug(req.getHeader("referer"));
    LOGGER.debug(articleMap.get("content"));

    // todo: redirect 위치 url뒤에서 두번째 깊이의 스트링 선택하는 메소드 구현하기
    articleMap.put("board_name", "free");

    service.insertArticle(loginMember, articleMap, req);

//    return "main_area/lists/"+result;
    // todo: redirect 위치 url뒤에서 두번째 깊이의 스트링 선택하는 메소드 구현하기
    return "redirect:/board/" + "free" + ".do";
  }

  @RequestMapping(value = "/board/**/postRep.do", method = RequestMethod.POST)
  public String postRep(@RequestParam HashMap<String, String> replyMap, HttpServletRequest req) {

    replyMap.forEach((k, v) -> LOGGER.debug("key : " + k + ", value : " + v));
    service.insertReply(replyMap);
    String formerUri = req.getHeader("referer");
    return "redirect:" + formerUri;
  }

  // for test
  @RequestMapping(value = "/ckeditor_test.do", method = RequestMethod.POST)
  public String ckeditorTest(@RequestParam String content) {
    LOGGER.debug(content);
    return "redirect:main.do";
  }

  private String getLastUri(HttpServletRequest req) {
    String uri = req.getRequestURI();
    String result = uri.substring(uri.lastIndexOf("/") + 1, uri.lastIndexOf("."));
    return result;
  }

  private String getBoardName(HttpServletRequest req) {
    String uri = req.getRequestURI();
    String result = uri.substring(uri.lastIndexOf("/") + 1, uri.length());
    return result;
  }
}
