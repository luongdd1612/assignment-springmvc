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
import com.edu.model.LoaiSP;

@Controller
@RequestMapping("ManagerLoaiSP")
public class LoaiSPController {
	@Autowired
	LoaiSPDAO loaiSPDao;

	@RequestMapping("showLoaiSP")
	public String showLoaiSP(Model model) {
		model.addAttribute("loaisp", new LoaiSP());
		model.addAttribute("loaisps", loaiSPDao.getAll());
		return "LoaiSP";
	}

	@RequestMapping("list")
	public String getLoaiSP(Model model) {
		model.addAttribute("loaisps", loaiSPDao.getAll());
		return "LoaiSP";
	}

	@RequestMapping(value = "loaispProcess", params = { "reset=Submit" })
	public String reset1(Model model) {
		model.addAttribute("loaisp", new LoaiSP());
		model.addAttribute("loaisps", loaiSPDao.getAll());
		return "LoaiSP";
	}

	@RequestMapping(value = "loaispProcess", params = { "add=Add" })
	public String save(@ModelAttribute("loaisp") @Validated LoaiSP loaiSP,BindingResult result, Model model) throws Exception {
		if(result.hasErrors()) {
			model.addAttribute("loaisp", loaiSP);
			return "LoaiSP";
		}
		this.loaiSPDao.saveOrUpdate(loaiSP);
		model.addAttribute("loaisp", new LoaiSP());
		model.addAttribute("loaisps", loaiSPDao.getAll());
		return "LoaiSP";
	}

	@RequestMapping(value = "loaispProcess", params = { "update=Update" })
	public String update(@ModelAttribute("loaisp") @Validated LoaiSP loaiSP,BindingResult result, Model model) throws Exception {
		if(result.hasErrors()) {
			model.addAttribute("loaisp", loaiSP);
			return "LoaiSP";
		}
		this.loaiSPDao.saveOrUpdate(loaiSP);
		model.addAttribute("loaisp", new LoaiSP());
		model.addAttribute("loaisps", loaiSPDao.getAll());
		return "LoaiSP";
	}

	@RequestMapping(value = "delete/{maLoai}")
	public String delete(@PathVariable("maLoai") String maLoai, Model model) throws Exception {
		this.loaiSPDao.delete(this.loaiSPDao.getLoaiSP(maLoai));
		model.addAttribute("loaisp", new LoaiSP());
		model.addAttribute("loaisps", loaiSPDao.getAll());
		return "LoaiSP";
	}

	@RequestMapping(value = "edit")
	public String edit(@RequestParam("maloai") String maLoai, Model model) {
		model.addAttribute("loaisps", loaiSPDao.getAll());
		model.addAttribute("loaisp", this.loaiSPDao.getLoaiSP(maLoai));
		return "LoaiSP";
	}
}
