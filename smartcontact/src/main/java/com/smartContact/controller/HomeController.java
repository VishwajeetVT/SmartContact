package com.smartContact.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.smartContact.dao.UserRepository;
import com.smartContact.entities.User;
import com.smarthelper.Message;

@Controller
public class HomeController {
	//@Autowired
	//private BCryptPasswordEncoder passwordEncoder;
	
	
	@Autowired
	private UserRepository userRepository;
	
    
	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("title","Home - smart Contact Manager");
		return "home";
	}
	
	@RequestMapping("/about")
	public String about(Model model) {
		model.addAttribute("title","About - smart Contact Manager");
		return "about";
	}
	
	@RequestMapping("/signup")
	public String signup(Model model) {
		model.addAttribute("title","SignUp - smart Contact Manager");
		model.addAttribute("user", new User());
		return "signup";
	}
	
	@RequestMapping("/login")
	public String login(Model model) {
		model.addAttribute("title","Login - smart Contact Manager");
		return "login";
	}
	
	//this is for handing user
	@RequestMapping(value="/doRegister", method= RequestMethod.POST)
	public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result1, @RequestParam(value="agreement", defaultValue = "false") 
	boolean agreement, Model model,  HttpSession session) {
		
	try {
		if(!agreement) {
			System.out.println("You have not agreed the terms and conditions");
			throw new Exception("You have not agreed the terms and conditions");
		}
		
		if(result1.hasErrors()) {
			System.out.println("Error "+result1.toString());
			model.addAttribute("user",user);
			return "signup";
		}
		 
//		user.setRole("ROLE_USER");
//		user.setEnabled(true);
//		String pws = passwordEncoder.encode(user.getPassword());
//		user.setPassword(pws);
//		System.out.println("Agreement "+agreement);
//		System.out.println("User "+user);
		
		User result=this.userRepository.save(user);
		
		session.setAttribute("message", new Message("Successfully Registered !!","alert-success"));
		//model.addAttribute("user",user);
		return "signup";
	}
	catch(Exception e) {
		e.printStackTrace();
		session.setAttribute("message", new Message("Something went wrong !!  " +e.getMessage(),"alert-danger"));
		return "signup";
	}
		
		
	}
}
