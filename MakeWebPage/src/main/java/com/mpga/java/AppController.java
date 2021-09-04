package com.mpga.java;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {
	@Autowired
	private UserRepository repo;
	
	@GetMapping("/")
	public String viewIndexPage() {
		return "index";
	}
	
	@GetMapping("/login")
	public String login(@ModelAttribute("User") User user, Model model) {
		return "login";
	}
//	@GetMapping("/user/logout")
//    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
//        new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
//        return "redirect:/";
//    }
	@GetMapping("/register")   
	public String showSignUpForm(Model model) {
		model.addAttribute("user", new User());
		
		return "signup_form";
	}  
	
	@PostMapping("/process_register")
	public String processRegistration(User user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedPassword = encoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		
		repo.save(user);
		
		
		repo.save(user);
		return "register_success";
	}
	
	@GetMapping("/list_users")
	public String viewUserList(Model model) {
		List<User> listUsers = repo.findAll();
		model.addAttribute("listUsers", listUsers);
		return "users";
	}

//	@GetMapping("/login")
//	public String getLoginView() {
//		return "login";
//	}
	
	
	@Autowired
	private NoticeDAO dao;
	

	@GetMapping("/help")
	public String viewFAQPage(Model model) {
		List<Notice> listNotice = dao.list();
		model.addAttribute("listNotice", listNotice); //model 객체를 이용해 view에 데이터 전달
		return "board";
	}
	

	

}
