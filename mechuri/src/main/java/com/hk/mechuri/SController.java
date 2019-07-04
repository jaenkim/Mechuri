package com.hk.mechuri;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class SController {
	
	private static final Logger logger = LoggerFactory.getLogger(SController.class);
	
	@RequestMapping(value = "/signUp.do", method = RequestMethod.GET)
	public String signUp(Locale locale, Model model) {
	
		return "signUp";
	}
	
	@RequestMapping(value = "/memLogin.do", method = RequestMethod.GET)
	public String memLogin(Locale locale, Model model) {
	
		return "memLogin";
	}
	
	@RequestMapping(value = "/compSignUp.do")
	public String compSignUp(Locale locale, Model model) {
	
		return "compSignUp";
	}
	
	@RequestMapping(value = "/addProduct.do")
	public String addProduct(Locale locale, Model model) {
	
		return "addProduct";
	}
	
	@RequestMapping(value = "/testLogin.do")
	public String testLogin(Locale locale, Model model) {
	
		return "testLogin";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
