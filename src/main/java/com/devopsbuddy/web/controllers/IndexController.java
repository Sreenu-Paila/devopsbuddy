package com.devopsbuddy.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author ir17tx
 *
 */
@Controller
public class IndexController {
	
	@RequestMapping("/")
	private String home() {
		return "index";
	}
}
