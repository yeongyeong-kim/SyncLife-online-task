package com.example.dto;

import java.sql.Date;

import org.apache.ibatis.type.Alias;

@Alias("reservation")
public class reservation {

	private String roomName;
	private String starttime ; 
	private String endtime;

	public reservation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public reservation(String roomName, String starttime, String endtime) {
		super();
		this.roomName = roomName;
		this.starttime = starttime;
		this.endtime = endtime;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	@Override
	public String toString() {
		return "reservationc [roomName=" + roomName + ", starttime=" + starttime + ", endtime=" + endtime + "]";
	}
	

	
}
