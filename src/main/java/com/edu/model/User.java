package com.edu.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "user")
public class User {
	@Id
	@Column(name = "username")
	@NotBlank(message ="Không để trống tên đăng nhập!!!")
	@Size(min = 5 , max = 25 , message = "Vui lòng nhập tên tài khoàn từ 5 đến 25 kí tự!!!")
	private String userName;
	@Column(name = "password")
	@NotBlank(message ="Không để trống mật khẩu!!!")
	@Size(min = 3 , max = 25 , message = "Vui lòng nhập mật khẩu từ 3 đến 25 kí tự!!!")
	private String pass;

	public User() {
	}

	public User(String userName, String pass) {
		this.userName = userName;
		this.pass = pass;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", pass=" + pass + "]";
	}

}
