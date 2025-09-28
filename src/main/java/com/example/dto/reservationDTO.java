package com.example.dto;

import java.sql.Date;

import org.apache.ibatis.type.Alias;

@Alias("reservationDTO")
public class reservationDTO {
	
	private int resNo;
	private String roomName;
	private int memNo;
	private int roomNo;
	private Date starttime ; 
	private Date endtime;
	private Boolean situation ;
	
	public reservationDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public reservationDTO(int resNo, String roomName, int memNo, int roomNo, Date starttime, Date endtime,
			Boolean situation) {
		super();
		this.resNo = resNo;
		this.roomName = roomName;
		this.memNo = memNo;
		this.roomNo = roomNo;
		this.starttime = starttime;
		this.endtime = endtime;
		this.situation = situation;
	}

	public int getResNo() {
		return resNo;
	}

	public void setResNo(int resNo) {
		this.resNo = resNo;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public int getMemNo() {
		return memNo;
	}

	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}

	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}

	public Date getStarttime() {
		return starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}

	public Date getEndtime() {
		return endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	public Boolean getSituation() {
		return situation;
	}

	public void setSituation(Boolean situation) {
		this.situation = situation;
	}

	@Override
	public String toString() {
		return "reservationDTO [resNo=" + resNo + ", roomName=" + roomName + ", memNo=" + memNo + ", roomNo=" + roomNo
				+ ", resStart=" + starttime + ", resEnd=" + endtime + ", situation=" + situation + "]";
	}

	
}
