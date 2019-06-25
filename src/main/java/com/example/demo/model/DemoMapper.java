package com.example.demo.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DemoMapper {
	List<String> selectAllId();
}
