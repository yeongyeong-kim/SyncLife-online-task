package com.example.dto;

import java.sql.Date;

import jakarta.validation.constraints.NotBlank;
import org.apache.ibatis.type.Alias;

@Alias("memberDTO")
public class memberDTO {
	
	private int memNO;
	 @NotBlank(message = "아이디는 필수 입력값입니다.")
	private String userid;
	 @NotBlank(message = "비밀번호는 필수 입력값입니다.")
	private String password;
	 @NotBlank(message = "이름은 필수 입력값입니다.")
	private String memName;
	@NotBlank(message = "직책은 필수 입력값입니다.")
	private String role;
	 
	public memberDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public memberDTO(int memNO, @NotBlank(message = "아이디는 필수 입력값입니다.") String userid,
			@NotBlank(message = "비밀번호는 필수 입력값입니다.") String password,
			@NotBlank(message = "이름은 필수 입력값입니다.") String memName, @NotBlank(message = "직책은 필수 입력값입니다.") String role) {
		super();
		this.memNO = memNO;
		this.userid = userid;
		this.password = password;
		this.memName = memName;
		this.role = role;
	}

	public int getMemNO() {
		return memNO;
	}

	public void setMemNO(int memNO) {
		this.memNO = memNO;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "memberDTO [memNO=" + memNO + ", userid=" + userid + ", password=" + password + ", memName=" + memName
				+ ", role=" + role + "]";
	}
	
	
	
}
