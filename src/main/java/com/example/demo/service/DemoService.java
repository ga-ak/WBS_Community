package com.example.demo.service;

import com.example.demo.model.DemoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	public List<HashMap> selectAllRep() {

		List<HashMap> result = new ArrayList<>();
		List<HashMap> oriArray = mapper.selectAllRep();
		Stack<HashMap> stack = new Stack<>();

		System.out.println(oriArray);


		// 부모 댓글만 모두 stack 에 담아준다
		for (int i = oriArray.size() - 1; i >= 0; i--) {
			HashMap thisRep = oriArray.get(i);
			if (thisRep.get("rep_pid") == null) {
				stack.push(thisRep);
				oriArray.remove(i);
			}
		}

		System.out.println(stack);

		while (stack.size() > 0) {

			HashMap parentRep = stack.pop();
			result.add(parentRep);

			for (int i = oriArray.size() - 1; i >= 0; i--) {
				HashMap thisRep = oriArray.get(i);
				if (parentRep.get("rep_id") == thisRep.get("rep_pid")) {
					stack.push(thisRep);
					oriArray.remove(i);
				}
			}
			System.out.println(stack);
		}


		return result;
	}

	public int insertRep(HashMap inputValues) {
		if (inputValues.get("rep_pid").equals("")) {
			inputValues.put("rep_pid", null);
		}
		System.out.println(inputValues);
		return mapper.insertRep(inputValues);
	}
}
