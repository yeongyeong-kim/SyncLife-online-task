package com.example.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.dto.memberDTO;
import com.example.dto.reservationTimeDTO;
import com.example.dto.reservation;
import com.example.service.ResStatusService;
import com.example.service.roomService;

@Controller
public class ResStatusController {
	
	@Autowired
	ResStatusService service;
	
	
	@GetMapping("/search")
	public ModelAndView resSearch(@RequestParam("date") String dateStr,HttpSession session, Model model) {
		memberDTO mdto = (memberDTO) session.getAttribute("login");
		ModelAndView mav= new ModelAndView();
		
        if (mdto == null) {
        	mav.setViewName("login");
        	return mav;
        }

        // 페이지에 로그인 정보 전달 가능
        model.addAttribute("login", mdto);
		HashMap<String,reservationTimeDTO> map = service.resSearch(dateStr,mdto);
		mav.addObject("resMap", map);
		mav.addObject("searchDay", dateStr);
		mav.setViewName("main");
		return mav;
	}
	@GetMapping("/deletRes")
    public String deletRes(@RequestParam("date") String date,@RequestParam("time") String time,Model model,HttpSession session) {
        memberDTO mdto = (memberDTO) session.getAttribute("login");
        if (mdto == null) return "login";  // 로그인 안 돼 있으면 login.jsp

        service.deletRes(date, time);
        int result = service.deletRes(date, time);
        model.addAttribute("msg", result > 0 ? "예약 취소 성공" : "예약 취소 실패");
        System.out.println(result);
        return "redirect:/main";
    }
	
	@GetMapping("/insertRers")
	public String insertReservation( @RequestParam("date") String date, @RequestParam("time") String time, Model model) {
		
		String[] times = time.split("-");
		String start = date + " " + times[0].trim() + ":00";
		String end = date + " " + times[1].trim() + ":00";
		
		
	    List<String> room = service.selectRoom(start,end);

	    Map<String, Object> dataMap = new HashMap<>();
	    dataMap.put("start", start);
	    dataMap.put("end", end);
	    dataMap.put("roomList", room);
	    model.addAttribute("data", dataMap);
	    return "form/insertRersForm"; 
	}
	
	@RequestMapping("/reservaion")
	public String reservaion( @RequestParam("start") String start, @RequestParam("end") String end,
            @RequestParam("roomName") String roomName,Model model,HttpSession session) {
		
		memberDTO mdto = (memberDTO) session.getAttribute("login");
        if (mdto == null) return "login";
        
        reservation reser = new reservation();
        reser.setStarttime(start); // 필요한 포맷으로 변환
        reser.setEndtime(end);
        reser.setRoomName(roomName);
        System.out.println("여기야 여기");
        System.out.println(reser);
        int result = service.inserRe(reser,mdto);
        model.addAttribute("msg", result > 0 ? "예약 성공" : "예약 실패");
        
        return "redirect:/main"; 
	}
}
