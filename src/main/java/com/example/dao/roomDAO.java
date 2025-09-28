package com.example.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.dto.memberDTO;
import com.example.dto.roomDTO;

import jakarta.validation.Valid;

@Repository
public class roomDAO {
	
	@Autowired
	SqlSessionTemplate template;
	
	public Object roomInsert(roomDTO dto) {
		return template.insert("RoomMapper.roomInsert", dto);
	}

	public roomDTO roomCheck(String roomName) {
		return template.selectOne("RoomMapper.roomCheck",roomName);
	}

	public List<String> selectRoom(HashMap<String,String> start) {
		// TODO Auto-generated method stub
		return template.selectList("RoomMapper.selectRoom", start);
	}

	

}
