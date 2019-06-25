package com.example.demo.service;

import java.util.List;

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
	
}
