package com.example.dto;

import java.sql.Date;

import jakarta.validation.constraints.NotBlank;
import org.apache.ibatis.type.Alias;

@Alias("roomDTO")
public class roomDTO {
	
	private int roomNo;
	private String roomName;
	private int capacity;
	private String location;
	public roomDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public roomDTO(int roomNo, String roomName, int capacity, String location) {
		super();
		this.roomNo = roomNo;
		this.roomName = roomName;
		this.capacity = capacity;
		this.location = location;
	}
	public int getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "roomDTO [roomNo=" + roomNo + ", roomName=" + roomName + ", capacity=" + capacity + ", location="
				+ location + "]";
	}
	
	
}
