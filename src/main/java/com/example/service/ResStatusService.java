package com.example.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.ResStatusDAO;
import com.example.dao.roomDAO;
import com.example.dto.memberDTO;
import com.example.dto.reservation;
import com.example.dto.reservationDTO;
import com.example.dto.reservationTimeDTO;
import com.example.dto.roomDTO;
import com.example.service.roomService;

@Service
public class ResStatusService {

	@Autowired
	ResStatusDAO dao;
	
	@Autowired
	roomDAO rdao;
	
	public HashMap<String, reservationTimeDTO> resSearch(String dateStr,memberDTO mdto) {
		
		List<reservationTimeDTO> rtlist = dao.resSearch(dateStr);
		System.out.println(rtlist);
		
		HashMap<String,reservationTimeDTO> map = new HashMap<>();
		for(int h = 1; h<24;h++) {
			String time = String.format("%02d:00 - %02d:00", h,(h % 24) + 1);
			String startTime = time.split("-")[0].trim()+":00"; // "10:00" 같은 값
			
			reservationTimeDTO value = null;
			for (reservationTimeDTO dto : rtlist) {
		        if (dto.getStartTime().equals(startTime)) {
		            value = dto;
		            break;
		        }
				
			}
			map.put(time, value);

		    }
	
		return map;
	}

	public int deletRes(String date, String time) {
		String[] times = time.split("-");
		String start = date + " " + times[0].trim() + ":00";
		String end = date + " " + times[1].trim() + ":00";
		
		HashMap<String,String> map = new HashMap<>();
		map.put("start", start);
		map.put("end", end);
		return dao.cancelRes(map);
		
	}

	public List<String> selectRoom(String start, String end) {
		HashMap<String,String> map = new HashMap<>();
		map.put("start", start);
		map.put("end", end);
		
		List<String> reslut = rdao.selectRoom(map);
		System.out.println(reslut);
		return reslut;
	}

	public int inserRe(reservation reser,memberDTO mdto) {
		int roomNo = rdao.roomCheck(reser.getRoomName()).getRoomNo();
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("memNo", mdto.getMemNO());
		paramMap.put("roomNo", roomNo);
		paramMap.put("start", reser.getStarttime());
		paramMap.put("end", reser.getEndtime());
		paramMap.put("situation", true);

		int num = dao.intRes(paramMap);
		System.out.println(num);
		return num;
	}
	
}
