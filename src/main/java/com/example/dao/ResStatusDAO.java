package com.example.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.dto.reservation;
import com.example.dto.reservationTimeDTO;

@Repository
public class ResStatusDAO {

	@Autowired
	SqlSessionTemplate template; 
	
	public List<reservationTimeDTO> resSearch(String dateStr) {
		return template.selectList("ReservationMapper.resSearch");
	}
	
	
//	public HashMap<String, Boolean> resSearch(String dateStr) {
//		HashMap<String, Boolean> map = template.selectMap(
//			    "ReservationMapper.resSearch",
//			    dateStr,
//			    "starttime"   // key로 사용할 컬럼 alias
//			);
//		return map;
//	}

	public int cancelRes(HashMap<String,String> map) {
		return template.update("ReservationMapper.cancelRes", map);
	}


	public int intRes(Map<String, Object> map) {
		return template.insert("ReservationMapper.intRes", map);
	}
		

}
