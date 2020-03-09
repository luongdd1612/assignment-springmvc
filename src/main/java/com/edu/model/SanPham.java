package com.edu.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "sanpham")
public class SanPham {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int iD;
	@Column(name = "tensp")
	@NotBlank(message = "Tên không được để trống!!!")
	@Size(min = 5, max = 100, message = "Tên từ 5 đến 100 kí tự!!!")
	private String tenSP;
	@Column(name = "gia")
	private double gia;
	@Column(name = "trangthai")
	@NotBlank(message = "Không để trống trạng thái!!!")
	private String trangThai;
	@Column(name = "thongtin")
	private String thongTin;
	@Column(name = "anh")
	private String anh;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "maloai")
	private LoaiSP loaisp;
	private transient String maLoaiPK;

	public SanPham() {
	}

	public int getiD() {
		return iD;
	}

	public void setiD(int iD) {
		this.iD = iD;
	}

	public String getTenSP() {
		return tenSP;
	}

	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}

	public double getGia() {
		return gia;
	}

	public void setGia(double gia) {
		this.gia = gia;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public String getThongTin() {
		return thongTin;
	}

	public void setThongTin(String thongTin) {
		this.thongTin = thongTin;
	}

	public String getAnh() {
		return anh;
	}

	public void setAnh(String anh) {
		this.anh = anh;
	}

	public LoaiSP getLoaisp() {
		return loaisp;
	}

	public void setLoaisp(LoaiSP loaisp) {
		this.loaisp = loaisp;
	}

	public String getMaLoaiPK() {
		return maLoaiPK;
	}

	public void setMaLoaiPK(String maLoaiPK) {
		this.maLoaiPK = maLoaiPK;
	}

}
