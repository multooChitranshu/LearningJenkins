package com.chitranshu.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.chitranshu.service.UserLoginService;

@Controller
public class UserLoginController {
	
	@Autowired
	UserLoginService userLoginServiceImpl;
	
	@RequestMapping("/")
	public ModelAndView welcomePageController() {
		return new ModelAndView("UserLoginPage");
	}
	
	@RequestMapping("/result")
	public ModelAndView sumController(HttpServletRequest request) {
		ModelAndView modelAndView=new ModelAndView();
		
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		
		boolean valid=userLoginServiceImpl.authenticateUser(name, password);
		String result="";
		if(valid)
			result="Login Successful";
		else
			result="Login Failed!";
		modelAndView.addObject("result", result);
		modelAndView.setViewName("Output");
		
		return modelAndView;
	}
	
}
