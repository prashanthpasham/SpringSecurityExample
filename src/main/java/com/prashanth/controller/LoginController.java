package com.prashanth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@RequestMapping("/welcome")
	public String welcome() {
		return "welcome";
	}
	@RequestMapping("/welcome/student")
	public String student() {
		return "student";
	}

	@RequestMapping("/logout")
	public String logout() {
		return "login";
	}
}
