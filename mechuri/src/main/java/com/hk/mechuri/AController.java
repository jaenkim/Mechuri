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
	
}
