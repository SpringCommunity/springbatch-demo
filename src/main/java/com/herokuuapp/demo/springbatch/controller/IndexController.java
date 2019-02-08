package com.herokuuapp.demo.springbatch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	 @RequestMapping("/")
     public String handleIndexPage(Model model){
		 model.addAttribute("happyNewYear", "Happy Lunar New Year 2019!");
    	 return "index";
     }
}
