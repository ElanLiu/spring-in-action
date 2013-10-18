package com.springinaction.mvc.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import com.springinaction.mvc.service.SpitterService;

@Controller
public class HomeController {
	
	public static final int DEFAULT_SPITTERS_PER_PAGE = 25;
	
	@Autowired
	private SpitterService spitterService;
	
	public HomeController(SpitterService spitterService){
		this.spitterService = spitterService;
	}
	
	@RequestMapping({"/", "/home"})
	public String showHomePage(Map<String, Object> model){
		model.put("spittles", spitterService.getRecentSpittles(DEFAULT_SPITTERS_PER_PAGE));
		
		return "home";
	}
	

}
