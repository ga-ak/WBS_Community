package com.example.demo.service;

import java.lang.reflect.Array;
import java.util.*;

import com.example.demo.vo.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.DemoMapper;

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

	public int insertMember(MemberVO member) {
		return mapper.insertMember(member);
	}
}
