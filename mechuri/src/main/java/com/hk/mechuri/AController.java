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
public class AController {
	
	private static final Logger logger = LoggerFactory.getLogger(AController.class);
	
	@RequestMapping(value = "/groupbuying.do", method = RequestMethod.GET)
	public String groupbuying(Locale locale, Model model) {
	
		return "groupbuying";
	}
	
	@RequestMapping(value = "/groupbuyingContents.do", method = RequestMethod.GET)
	public String groupbuyingContents(Locale locale, Model model) {
	
		return "groupbuyingContents";
	}
	@RequestMapping(value = "/groupbuyingContents2.do", method = RequestMethod.GET)
	public String groupbuyingContents2(Locale locale, Model model) {
	
		return "groupbuyingContents2";
	}
	@RequestMapping(value = "/groupbuyingContents3.do", method = RequestMethod.GET)
	public String groupbuyingContents3(Locale locale, Model model) {
	
		return "groupbuyingContents3";
	}
	
	@RequestMapping(value = "/groupbuyingContents4.do", method = RequestMethod.GET)
	public String groupbuyingContents4(Locale locale, Model model) {
	
		return "groupbuyingContents4";
	}
	@RequestMapping(value = "/groupbuyingContents5.do", method = RequestMethod.GET)
	public String groupbuyingContents5(Locale locale, Model model) {
	
		return "groupbuyingContents5";
	}
	@RequestMapping(value = "/groupbuyingContents6.do", method = RequestMethod.GET)
	public String groupbuyingContents6(Locale locale, Model model) {
	
		return "groupbuyingContents6";
	}
	@RequestMapping(value = "/groupbuyingContents7.do", method = RequestMethod.GET)
	public String groupbuyingContents7(Locale locale, Model model) {
	
		return "groupbuyingContents7";
	}
	@RequestMapping(value = "/groupbuyingContents8.do", method = RequestMethod.GET)
	public String groupbuyingContents8(Locale locale, Model model) {
	
		return "groupbuyingContents8";
	}
}	