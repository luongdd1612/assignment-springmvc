package com.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.edu.DAO.LoaiSPDAO;
import com.edu.DAO.SanPhamDAO;
import com.edu.model.SanPham;

@Controller
@RequestMapping("ManagerSP")
public class SanPhamController {
	@Autowired
	private SanPhamDAO sanPhamDao;
	@Autowired
	private LoaiSPDAO loaiSPDao;

	@RequestMapping("showSP")
	public String showSP(Model model) throws Exception {
		model.addAttribute("sanpham", new SanPham());
		model.addAttribute("sanphams", sanPhamDao.getAll());
		model.addAttribute("loaisps", loaiSPDao.getAll());
		return "SP";
	}

	@RequestMapping(value = "sanphamProcess", params = { "reset=Submit" })
	public String reset(Model model) {
		model.addAttribute("sanpham", new SanPham());
		model.addAttribute("sanphams", sanPhamDao.getAll());
		model.addAttribute("loaisps", loaiSPDao.getAll());
		return "SP";
	}

	@RequestMapping(value = "sanphamProcess", params = { "add=Add" })
	public String save(@ModelAttribute("sanpham") @Validated SanPham sanPham,BindingResult result, Model model) {
		sanPham.setLoaisp(loaiSPDao.getLoaiSP(sanPham.getMaLoaiPK()));
		if(result.hasErrors()) {
			model.addAttribute("loaisps", loaiSPDao.getAll());
			model.addAttribute("sanpham", sanPham);
			return "SP";
		}
		this.sanPhamDao.saveOrUpdate(sanPham);
		model.addAttribute("sanpham", new SanPham());
		model.addAttribute("sanphams", sanPhamDao.getAll());
		model.addAttribute("loaisps", loaiSPDao.getAll());
		return "SP";
	}

	@RequestMapping(value = "sanphamProcess", params = { "update=Update" })
	public String update(@ModelAttribute("sanpham") @Validated SanPham sanPham,BindingResult result, Model model) {
		sanPham.setLoaisp(loaiSPDao.getLoaiSP(sanPham.getMaLoaiPK()));
		if(result.hasErrors()) {
			model.addAttribute("loaisps", loaiSPDao.getAll());
			model.addAttribute("sanpham", sanPham);
			return "SP";
		}
		this.sanPhamDao.saveOrUpdate(sanPham);
		model.addAttribute("sanpham", new SanPham());
		model.addAttribute("sanphams", sanPhamDao.getAll());
		model.addAttribute("loaisps", loaiSPDao.getAll());
		return "SP";
	}

	@RequestMapping(value = "delete/{id}")
	public String delete(@PathVariable("id") int id, Model model) {
		this.sanPhamDao.delete(this.sanPhamDao.getSanPhamById(id));
		model.addAttribute("sanpham", new SanPham());
		model.addAttribute("sanphams", sanPhamDao.getAll());
		model.addAttribute("loaisps", loaiSPDao.getAll());
		return "SP";
	}

	@RequestMapping(value = "edit")
	public String edit(@RequestParam("id") int id, Model model) {
		model.addAttribute("sanphams", sanPhamDao.getAll());
		model.addAttribute("sanpham", this.sanPhamDao.getSanPhamById(id));
		model.addAttribute("loaisps", loaiSPDao.getAll());
		return "SP";
	}
}
