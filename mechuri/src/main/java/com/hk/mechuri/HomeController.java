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

import com.hk.mechuri.dtos.filterDto;
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
		String command = request.getParameter("command");
		
		if(command == null) {
		List<productDto> list = rankService.getAllProductList();
		model.addAttribute("list",list);
		
		return "ranking/list";
		
		}else if(command.equals("filter")) {
			
			String filter_age10 = request.getParameter("filter_age10");
			String filter_age20 = request.getParameter("filter_age20");
			String filter_age30 = request.getParameter("filter_age30");
			String filter_age40 = request.getParameter("filter_age40");
			String filter_age50 = request.getParameter("filter_age50");
			String filter_genderW = request.getParameter("filter_genderW");
			String filter_genderM = request.getParameter("filter_genderM");
			String filter_catelname = request.getParameter("filter_catelname");
			String filter_catesname = request.getParameter("filter_catesname");
			String filter_price = request.getParameter("filter_price");
			System.out.println("컨트롤러에서 출력 filter_age10 ["+filter_age10+"]");
			System.out.println("컨트롤러에서 출력 filter_catelname ["+filter_catelname+"]");
			System.out.println("컨트롤러에서 출력 filter_catesname ["+filter_catesname+"]");
			filterDto dto = new filterDto(filter_age10,filter_age20,filter_age30,filter_age40,filter_age50,filter_genderW,filter_genderM, filter_catelname, filter_catesname,filter_price);
			List<productDto>list2 = rankService.getFilterProductList(dto);
			model.addAttribute("list",list2);
			
			
			return "ranking/list";
		}
		
		return command;
	
		
	}

	
	}
	

