package com.example.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.roomDAO;
import com.example.dto.roomDTO;

import jakarta.validation.Valid;


@Service
public class roomService {

	@Autowired 
	roomDAO dao;

	public void roomInsert(roomDTO dto) {
		dao.roomInsert(dto);
		
	}

	public String roomCheck(String roomName) {
		roomDTO dto = dao.roomCheck(roomName);
		String mesg="이름 사용가능";
		if(dto != null) {
			mesg="이름 중복";
		}
		return mesg;
	}
	
	

}
