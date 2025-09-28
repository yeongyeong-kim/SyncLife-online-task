package com.example.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.tags.shaded.org.apache.xml.utils.AttList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.service.loginService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import com.example.dto.memberDTO;

@Controller
public class loginController {

	@Autowired
	loginService service; 
	
	@RequestMapping(value = "/login")
	public String login(@RequestParam HashMap<String, String> map, Model model, HttpSession session) {
		memberDTO mdto = service.loginCheck(map);
		if(mdto!= null ) {
			session.setAttribute("login", mdto);
			return "redirect:/main";  //
		}else {
			model.addAttribute("mesg", "아이디 또는 비번이 잘못되었습니다.");
			return "login";
		}
	}
	
	@RequestMapping(value = "/idCheck", produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String idCheck(@RequestParam("id") String userid) {//아이디 중복검사
		String mesg = service.Info(userid);
		return mesg;
	}
	
	@RequestMapping(value = "/join")
	public String join(@Valid memberDTO dto, BindingResult bindingResult) {
		 if (bindingResult.hasErrors()) {
		        return "join"; // 다시 회원가입 페이지로
		    }
		 service.MemInsert(dto);
		    return "redirect:/login";
	}
	
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {//로그아웃
		session.invalidate();
		return "redirect:/"; 
	}
	
	@RequestMapping("/main")
	public String main(HttpSession session, Model model) {
		memberDTO mdto = (memberDTO) session.getAttribute("login");
		
		if (mdto == null) {
            // 로그인 안 되어 있으면 로그인 페이지로
            return "login";
        }
        // 로그인 상태이면 사용자 이름 전달
        model.addAttribute("memName", mdto.getMemName());
        return "main"; 
    }

}
