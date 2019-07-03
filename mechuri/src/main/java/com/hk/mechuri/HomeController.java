package com.hk.mechuri;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hk.mechuri.dtos.productDto;
import com.hk.mechuri.service.iRankService;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private iRankService rankService;
	
	@RequestMapping(value = "/main.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String main(Locale locale, Model model) {

		return "ranking/main";
	}
	
	@RequestMapping(value = "/list.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String list(HttpServletRequest request, Locale locale, Model model) {
		
		List<productDto> list = rankService.getAllProductList();
		model.addAttribute("list",list);
		
		return "ranking/list";
	}
	
}
