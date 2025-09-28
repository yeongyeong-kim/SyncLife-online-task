package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.dto.roomDTO;
import com.example.service.roomService;

import jakarta.validation.Valid;

@Controller
public class roomController {

	@Autowired
	roomService service;
	
	@PostMapping("/insertRoom")
	public String insertRoom(roomDTO dto) {
		System.out.println(dto);
		 if(dto.getRoomName() == null) {
			 return "createRoom";
		 }
		 if(dto.getCapacity() == 0) {
			 return "createRoom";
		 }
		 if(dto.getLocation() == null) {
			 return "createRoom";
		 }
		 
		 service.roomInsert(dto);
		    return "redirect:/loginCheck/main";
	}
	
	@RequestMapping(value = "loginCheck/roomCheck", produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String idCheck(@RequestParam("id") String roomName) {//아이디 중복검사
		String mesg = service.roomCheck(roomName);
		return mesg;
	}
	
	@GetMapping("loginCheck/createroom")
	public String goRoom() {
		return "createRoom";
	}

}