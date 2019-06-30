package com.example.demo.model;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface DemoMapper {
	List<String> selectAllId();
	List<HashMap<String, Integer>> selectAllRep();
}
