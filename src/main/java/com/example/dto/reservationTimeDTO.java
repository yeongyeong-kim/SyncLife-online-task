package com.example.dto;

import java.sql.Date;

import org.apache.ibatis.type.Alias;

@Alias("reservationTimeDTO")
public class reservationTimeDTO {
	
	 private String roomName;
	 private String startTime;   // "HH:MM:SS"
	 private String endTime;
	 private Boolean situation;
	 
	
	public reservationTimeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public reservationTimeDTO(String roomNO, String startTime, String endTime, Boolean situation) {
		super();
		this.roomName = roomName;
		this.startTime = startTime;
		this.endTime = endTime;
		this.situation = situation;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}


	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public Boolean getSituation() {
		return situation;
	}

	public void setSituation(Boolean situation) {
		this.situation = situation;
	}



	@Override
	public String toString() {
		return "reservationTimeDTO [roomName=" + roomName + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", situation=" + situation + "]";
	}



	

	
	
	

	
}
