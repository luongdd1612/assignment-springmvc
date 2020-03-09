package com.edu.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
@Table(name = "loaisp")
public class LoaiSP {
	@Id
	@Column(name = "maloai")
	@NotBlank(message = "Không để trống mã loại!!!")
	private String maLoai;
	@Column(name = "tenloai")
	@NotBlank(message = "Không để trống tên loại!!!")
	private String tenLoai;
	@OneToMany(mappedBy = "loaisp", cascade = CascadeType.ALL)
	private List<SanPham> listSP = new ArrayList<SanPham>();

	public LoaiSP() {
	}

	public LoaiSP(String maLoai, String tenLoai) {
		this.maLoai = maLoai;
		this.tenLoai = tenLoai;
	}

	public String getMaLoai() {
		return maLoai;
	}

	public void setMaLoai(String maLoai) {
		this.maLoai = maLoai;
	}

	public String getTenLoai() {
		return tenLoai;
	}

	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}

	@Override
	public String toString() {
		return "LoaiSP [maLoai=" + maLoai + ", tenLoai=" + tenLoai + "]";
	}

}
