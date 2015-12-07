package com.mysample.springbootsample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/admin/")
@Controller
public class AdminController {
	
	@RequestMapping(value = "dashboard.html")
	public String dashboard() {
		
		return "dashboard";
	}
}
