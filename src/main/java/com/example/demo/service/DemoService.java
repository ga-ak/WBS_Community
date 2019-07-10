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


  /**
   * @param articleNo controller 한테서 받은 게시글의 번호
   * @return 댓글 번호순으로 정렬된 List를 부모-자식 관계에 맞게 재정렬하여 리턴
   * @author cheolho Kim
   */

  public List<HashMap> selectReplyByArticleNo(Integer articleNo) {
    List<HashMap> result = new ArrayList<>();                                  // 부모-자식 관계에 맞게 정렬되어 들어갈 ArrayList 선언
    List<HashMap> tempList = mapper.selectReplyByArticleNo(articleNo);         // db로부터 댓글번호순으로 정렬된 List 받음
    Stack<HashMap> stack = new Stack<>();                                      // 특정 부모의 자식들을 우선 반환 하기위한 Stack 선언

    for (int i = tempList.size() - 1; i >= 0; i--) {                           // 부모가 없는(최상위) 댓글을 우선 Stack에 담는다
      HashMap thisRep = tempList.get(i);                                       // Stack이기 때문에 tempList의 뒷 부분부터 Stack에 담음
      if (thisRep.get("reply_pno") == null || thisRep.get("reply_pno").equals("")) {
        stack.push(thisRep);                                                   // 조건에 맞으면 Stack에 담는다
        tempList.remove(i);                                                    // 탐색을 줄이기 위해 Stack에 담긴 객체의 인덱스에 해당하는 List삭제
      }
    }                                                                          // for문이 끝나면 부모댓글이 모두 Stack에 담기게 된다

    while (stack.size() > 0) {                                                 // Stack의 크기가 0이 될때 -> 모든 댓글의 탐색을 끝냈을 때
      HashMap parentRep = stack.pop();                                         // pop() 해서 나온 객체를 parentRep에 할당하고 result에 담는다
      result.add(parentRep);

      for (int i = tempList.size() - 1; i >= 0; i--) {                         // 위와 마찬가지로 뒤에서 부터 탐색하여 Stack에 담는다
        HashMap thisRep = tempList.get(i);
        if (parentRep.get("reply_no").equals(thisRep.get("reply_pno"))) {      // 부모의 reply_no와 자식의 reply_pno이 같다면 부모-자식 관계임
          stack.push(thisRep);                                                 // 따라서 우선적으로 탐색해야 하기 때문에 Stack에 담는다
          tempList.remove(i);                                                  // 마찬가지로 탐색시간을 줄이기 위해 List에서 제거
        }
      }
    }                                                                          // while문을 빠져나오면 부모-자식 관계에 맞도록 정렬이 끝나게 된다.

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
