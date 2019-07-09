package com.hk.mechuri;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hk.mechuri.dtos.filterDto;
import com.hk.mechuri.dtos.ingreDto;
import com.hk.mechuri.dtos.productDto;
import com.hk.mechuri.dtos.reviewDto;
import com.hk.mechuri.service.RankService;
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
			String filter_genderF = request.getParameter("filter_genderF");
			String filter_genderM = request.getParameter("filter_genderM");
			String filter_catelname = request.getParameter("filter_catelname");
			String filter_catesname = request.getParameter("filter_catesname");

			//			if(request.getParameter("filter_age10").equals("전체,10대")) {filter_age10 = request.getParameter("filter_age10");}
			//			else {filter_age10 = "전체";}
			//			
			//			if(request.getParameter("filter_age20").equals("전체,20대")) {	filter_age20 = request.getParameter("filter_age20");}
			//			else {filter_age20 = "전체";}
			//			
			//			if(request.getParameter("filter_age30").equals("전체,30대")) {	filter_age30 = request.getParameter("filter_age30");}
			//			else {filter_age30 = "전체";}
			//			
			//			if(request.getParameter("filter_age40").equals("전체,40대")) {	filter_age40 = request.getParameter("filter_age40");}
			//			else {filter_age40 = "전체";}
			//			
			//			if(request.getParameter("filter_age50").equals("전체,50대 이상")) {filter_age50 = request.getParameter("filter_age50");}
			//			else {filter_age50 = "전체";}
			//			
			//			if(request.getParameter("filter_genderF").equals("전체,여성")) {filter_genderF = request.getParameter("filter_genderF");}
			//			else {filter_genderF = "전체";}
			//			
			//			if(request.getParameter("filter_genderM").equals("전체,남성")) {filter_genderM = request.getParameter("filter_genderM");}
			//			else {filter_genderM = "전체";}
			//			
			//			if(!(request.getParameter("filter_catelname").equals("전체"))) {filter_catelname = request.getParameter("filter_catelname");}
			//			else {filter_catelname = "전체";}
			//			
			//			if(!(request.getParameter("filter_catesname").equals("전체"))) {filter_catesname = request.getParameter("filter_catesname");}
			//			else {filter_catesname = "전체";}

			filterDto dto = new filterDto(filter_age10,filter_age20,filter_age30,filter_age40,filter_age50,filter_genderF,filter_genderM, filter_catelname, filter_catesname);
			List<productDto>list2 = rankService.getFilterProductList(dto);
			model.addAttribute("list",list2);

			return "ranking/list";
			
			
		}else if(command.equals("sortbyhighprice")) {
			//높은 가격 순 정렬
			List<productDto> list = rankService.getAllProductListbyHighprice();
			model.addAttribute("list",list);

			return "ranking/list";
		}else if(command.equals("sortbylowprice")) {
			//낮은 가격순 정렬
			List<productDto> list = rankService.getAllProductListbyLowprice();
			model.addAttribute("list",list);

			return "ranking/list";
		}else if(command.equals("sortbyascname")) {
			//이름순 정렬
			List<productDto> list = rankService.getAllProductListbyASCname();
			model.addAttribute("list",list);

			return "ranking/list";
		}else if(command.equals("sortbymaxreview")) {
			//리뷰 많은순
			List<productDto> list = rankService.getAllProductListbyMaxReview();
			model.addAttribute("list",list);

			return "ranking/list";
		}else if(command.equals("sortbyminreview")) {
			//리뷰 적은순
			List<productDto> list = rankService.getAllProductListbyMinReview();
			model.addAttribute("list",list);

			return "ranking/list";
		}

		return "error";
	}//list END

	
	@RequestMapping(value = "/productdetail.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String productDetail(HttpServletRequest request, Locale locale, Model model, productDto dto) {
		
		int product_no = Integer.parseInt(request.getParameter("no"));
		String product_ingre = request.getParameter("ingre");
		

		
		productDto pDto = new productDto(product_no,product_ingre);
		
		productDto productInfo = rankService.getDetailProductList(product_no);
		model.addAttribute("proInfo",productInfo);
		
		reviewDto reviewDetail = rankService.getDetailPoint(product_no);
		model.addAttribute("detailReview",reviewDetail);
		
		List<reviewDto> reviewInfo = rankService.getProductReview(product_no);
		model.addAttribute("reviewInfo",reviewInfo);
		
		List<ingreDto> ingreInfo = rankService.getProductIngre(pDto);
		model.addAttribute("ingreInfo",ingreInfo);
		
		return "ranking/productdetail";
	}

	
//	@RequestMapping(value = "/ingre.do", method = {RequestMethod.GET, RequestMethod.POST})
//	public String productIngre(HttpServletRequest request, Locale locale, Model model, productDto pDto, ingreDto iDto) {
//		
//		int product_no = Integer.parseInt(request.getParameter("no"));
//		String ingre = request.getParameter("ingre");
//		
//		String[] ingreArray = ingre.split(",");
//		
//		Map<String,String[]> product_ingre = new HashMap<String,String[]>();
//		product_ingre.put("product_ingre", ingreArray);
//			
//		List<reviewDto> reviewInfo = rankService.getProductReview(product_no);
//		model.addAttribute("reviewInfo",reviewInfo);
//		
//		return "ranking/productdetail";
//	}



}