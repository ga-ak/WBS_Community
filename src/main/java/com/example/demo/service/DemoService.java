package com.example.demo.service;

import com.example.demo.model.DemoMapper;
import com.example.demo.vo.ArticleVO;
import com.example.demo.vo.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

@Service
public class DemoService {

  @Autowired
  DemoMapper mapper;

  public List<MemberVO> selectAllMember() {
    return mapper.selectAllMember();
  }

  public MemberVO selectLogin(MemberVO member) {
    MemberVO result = mapper.selectLogin(member);
    if (result.getMember_isDeleted() == 1) {
      result = null;
    }
    return result;
  }

  public List<ArticleVO> selectArticleByBoardName(String boardName) {
    return mapper.selectArticleByBoardName(boardName);
  }

  public HashMap selectArticleById(Integer articleNo) {
    return mapper.selectArticleById(articleNo);
  }

  public List<HashMap> selectReplyByArticleNo(Integer articleNo) {
    List<HashMap> result = new ArrayList<>();
    List<HashMap> tempList = mapper.selectReplyByArticleNo(articleNo);
    Stack<HashMap> stack = new Stack();

    for (int i = tempList.size() - 1; i >= 0; i--) {
      HashMap thisRep = tempList.get(i);
      if (thisRep.get("reply_pno") == null || thisRep.get("reply_pno").equals("")) {
        stack.push(thisRep);
        tempList.remove(i);
      }
    }

    while (stack.size() > 0) {
      HashMap parentRep = stack.pop();
      result.add(parentRep);

      for (int i = tempList.size() - 1; i >= 0; i--) {
        HashMap thisRep = tempList.get(i);
        if (parentRep.get("reply_no").equals(thisRep.get("reply_pno"))) {
          stack.push(thisRep);
          tempList.remove(i);
        }
      }
    }

    return result;
  }

  public int insertMember(MemberVO member) {
    return mapper.insertMember(member);
  }

  public int insertArticle(MemberVO loginMember, HashMap<String, String> articleMap, HttpServletRequest req) {
    ArticleVO article = new ArticleVO();

    int article_no = mapper.selectBoardIdByName(articleMap.get("board_name"));
    String article_ip = req.getLocalAddr();

    // set board_no
    article.setBoard_no(article_no);
    // set member_no
    article.setMember_no(loginMember.getMember_no());
    // set article_name
    article.setArticle_name(articleMap.get("article_name"));
    // set article_content
    article.setArticle_content(articleMap.get("content"));
    // set article_ip
    article.setArticle_ip(article_ip);

    return mapper.insertArticle(article);
  }

  public int insertReply(HashMap replyMap) {
    if (replyMap.get("reply_pno").equals("")) {
      replyMap.put("reply_pno", null);
    }
    return mapper.insertReply(replyMap);
  }
}
