package com.example.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.dao.loginDAO;
import com.example.dto.memberDTO;

@Service
public class loginService {

	@Autowired 
	loginDAO dao;
	
	public memberDTO loginCheck(HashMap<String,String> loginInfo) {
		memberDTO check = dao.loginCheck(loginInfo);
		return check;
	}
	
	public String Info(String userid) {
		memberDTO dto = dao.Info(userid);
		String mesg="아이디 사용가능";
		if(dto != null) {
			mesg="아이디 중복";
		}
		return mesg;
	}

	public int MemInsert(memberDTO dto) {
		return dao.MemInsert(dto);
	}

}
