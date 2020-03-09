package com.edu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.edu.DAO.LoaiSPDAO;
import com.edu.DAO.SanPhamDAO;
import com.edu.model.LoaiSP;
import com.edu.model.SanPham;

@Controller
public class HomeController {
	@Autowired
	private LoaiSPDAO loaiSPDao;
	@Autowired
	private SanPhamDAO sanPhamDao;

	@RequestMapping(value = "home")
	public String home(ModelMap model) {
		model.addAttribute("loaisp", new LoaiSP());
		model.addAttribute("loaisps", loaiSPDao.getAll());
		model.addAttribute("sanphams", sanPhamDao.getAll());
		return "home";
	}

	@RequestMapping(value = "select")
	public String selectByLoaiSP(@RequestParam("maloai") String loaisp, Model model) {
		model.addAttribute("loaisps", loaiSPDao.getAll());
//		List<SanPham> sanPhamByLoai = sanPhamDao.getSanPhamByLoai(loaisp);
//		model.addAttribute("sanphams", sanPhamByLoai);
		model.addAttribute("sanphams", sanPhamDao.getSanPhamByLoai(loaisp));
		model.addAttribute("sanpham", new SanPham());
		return "home";
	}

	@RequestMapping(value = "searchSP")
	public String search(@RequestParam("search") String search, Model model) {
		if (search == null || search.equals("")) {
			model.addAttribute("sanphams", sanPhamDao.getAll());
		} else {
			model.addAttribute("sanphams", sanPhamDao.search(search));
		}
		model.addAttribute("sanpham", new SanPham());
		return "home";
	}
}
