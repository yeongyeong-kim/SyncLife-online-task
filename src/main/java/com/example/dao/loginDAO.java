package com.example.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.dto.memberDTO;

@Repository
public class loginDAO {
	
	@Autowired
	SqlSessionTemplate template;
	
	public memberDTO loginCheck(HashMap<String,String> loginInfo) {
		return template.selectOne("MemverMapper.Loginselect",loginInfo);
	}

	public memberDTO Info(String userid) {
		return template.selectOne("MemverMapper.Info",userid);
	}

	public int MemInsert(memberDTO dto) {
		return template.insert("MemverMapper.MemInsert", dto);
	}

	

}
