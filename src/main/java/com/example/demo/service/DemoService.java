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

    public List<String> selectAllId() {
        return mapper.selectAllId();
    }

    public List<HashMap<String, Integer>> selectAllRep() {

        List<HashMap<String, Integer>> result = new ArrayList<>();
        List<HashMap<String, Integer>> oriArray = mapper.selectAllRep();
        Stack<HashMap<String, Integer>> stack = new Stack<>();

        System.out.println(oriArray);


        // 부모 댓글만 모두 stack 에 담아준다
        for (int i = oriArray.size() - 1; i >= 0; i--) {
            HashMap thisRep = oriArray.get(i);
            if (thisRep.get("rep_parent") == null) {
                stack.push(thisRep);
                oriArray.remove(i);
            }
        }

        System.out.println(stack);

        while (stack.size() > 0) {

            HashMap<String, Integer> parentRep = stack.pop();
            result.add(parentRep);

            for (int i = oriArray.size() - 1; i >= 0; i--) {
                HashMap thisRep = oriArray.get(i);
                if (parentRep.get("rep_id") == thisRep.get("rep_parent")) {
                    stack.push(thisRep);
                    oriArray.remove(i);
                }
            }
            System.out.println(stack);
        }


        return result;
    }

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
}
