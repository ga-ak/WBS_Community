package com.example.demo.model;

import java.util.HashMap;
import java.util.List;

import com.example.demo.vo.MemberVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface DemoMapper {
	List<String> selectAllId();
	List<HashMap<String, Integer>> selectAllRep();
	int insertMember(MemberVO member);
	List<MemberVO> selectAllMember();
	MemberVO selectLogin(MemberVO member);

}
