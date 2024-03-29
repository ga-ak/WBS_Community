package com.example.demo.model;

import java.util.HashMap;
import java.util.List;

import com.example.demo.vo.ArticleVO;
import com.example.demo.vo.MemberVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface DemoMapper {
  List<String> selectAllId();
  List<HashMap<String, Integer>> selectAllRep();
  List<MemberVO> selectAllMember();
  MemberVO selectLogin(MemberVO member);

  HashMap selectArticleById(Integer articleNo);
  List<ArticleVO> selectArticleByBoardName(String boardName);

  Integer selectBoardIdByName(String boardName);

  List<HashMap> selectReplyByArticleNo(Integer articleNo);

  int insertMember(MemberVO member);

  int insertArticle(ArticleVO articleVO);

  int insertReply(HashMap replyMap);
}
