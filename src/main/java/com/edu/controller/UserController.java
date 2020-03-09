package com.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.edu.DAO.LoaiSPDAO;
import com.edu.DAO.SanPhamDAO;
import com.edu.DAO.UserDAO;
import com.edu.model.LoaiSP;
import com.edu.model.User;

@Controller
public class UserController {
	@Autowired
	private UserDAO userDao;
	@Autowired
	private LoaiSPDAO loaiSPDao;
	@Autowired
	private SanPhamDAO sanPhamDao;

	@RequestMapping(value = "login")
	public String showLogin(ModelMap model) {
		model.addAttribute("user", new User());
		return "login";
	}

	@RequestMapping(value = "loginAction", method = RequestMethod.POST)
	public String login(@ModelAttribute("user") User user, ModelMap model) {
		if (!userDao.getUser(user.getUserName(), user.getPass()).isEmpty()) {
			model.addAttribute("message", user.getUserName());
			model.addAttribute("loaisp", new LoaiSP());
			model.addAttribute("loaisps", loaiSPDao.getAll());
			model.addAttribute("sanphams", sanPhamDao.getAll());
			return "welcome";
		}
		model.addAttribute("message", "Sai tên đăng nhập hoặc mật khẩu !");
		return "login";
	}

	@RequestMapping(value = "register")
	public String showRegister(ModelMap model) {
		model.addAttribute("user", new User());
		model.addAttribute("users", userDao.getAll());
		return "register";
	}

	@RequestMapping(value = "registerAction", params = { "add=Add" })
	public String save(@ModelAttribute("user") @Validated User user,BindingResult result, Model model) throws Exception {
		if(result.hasErrors()) {
			return "register";
		}
		else if (userDao.getUser(user.getUserName()) == null) {
			userDao.save(new User(user.getUserName(), user.getPass()));
			model.addAttribute("message", "Bạn đã đăng kí thành công mời bạn đăng nhập!!");
			return "login";
		} else {
			model.addAttribute("message", "Tên đăng nhập đã được sử dụng!!!");
			model.addAttribute("users", userDao.getAll());
			return "register";
		}
	}

	@RequestMapping(value = "registerAction", params = { "update=Update" })
	public String update(@ModelAttribute("user") @Validated User user,BindingResult result, Model model) throws Exception {
		if(result.hasErrors()) {
			model.addAttribute("user", user);
			return "register";
		}
		this.userDao.save(user);
		model.addAttribute("user", new User());
		model.addAttribute("users", userDao.getAll());
		return "register";
	}

	@RequestMapping(value = "registerAction", params = { "reset=Submit" })
	public String reset1(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("users", userDao.getAll());
		return "register";
	}

	@RequestMapping(value = "delete/{userName}")
	public String delete(@PathVariable("userName") String userName, Model model) throws Exception {
		this.userDao.delete(this.userDao.getUser(userName));
		model.addAttribute("user", new User());
		model.addAttribute("users", userDao.getAll());
		return "register";
	}

	@RequestMapping(value = "edit")
	public String edit(@RequestParam("username") String userName, Model model) {
		model.addAttribute("users", userDao.getAll());
		model.addAttribute("user", this.userDao.getUser(userName));
		return "register";
	}
}
