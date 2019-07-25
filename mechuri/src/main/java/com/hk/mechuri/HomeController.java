package com.hk.mechuri;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.hk.mechuri.dtos.boardDto;
import com.hk.mechuri.dtos.filterDto;
import com.hk.mechuri.dtos.ingreDto;
import com.hk.mechuri.dtos.productDto;
import com.hk.mechuri.dtos.reviewDto;
import com.hk.mechuri.service.RankService;
import com.hk.mechuri.service.addProductService;
import com.hk.mechuri.service.iRankService;

import javafx.scene.control.Alert;

@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private iRankService rankService;


	@Autowired
	private addProductService productservice;

	@RequestMapping(value = "/main.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String main(Locale locale, Model model,HttpSession session) {

		//가장 리뷰점수가 높은 제품 출력(catelname 별 1개씩)
		List<productDto> mainrank=productservice.mainRankList();
		model.addAttribute("mainrank",mainrank);

		//가장 조회수가 놓은 커뮤니티의 글 4개 출력
		List<boardDto> commu=productservice.mainCommuList();
		model.addAttribute("commu",commu);

		return "ranking/main";
	}

	
	@RequestMapping(value = "/list.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String list(HttpServletRequest request, Locale locale, Model model,String[] ages,String[] genders, String[] skins) {
		String command = request.getParameter("command");

		if(command == null) {
			List<productDto> list = rankService.getAllProductList();
			model.addAttribute("list",list);
			int random = (int)(Math.random()*10)+1;
			System.out.println("random"+random);
			model.addAttribute("random", random+"");
			
			return "ranking/list";

		}else if(command.equals("filter")) {
			
			String catelname = request.getParameter("filter_catelname");
			String catesname = request.getParameter("filter_catesname");
		
			String tempAge[] = new String[6];
			String tempGender[] = new String[3];
			String tempSkin[] = new String[4];
			tempAge[0] = "10대";
			tempAge[1] = "20대";
			tempAge[2] = "30대";
			tempAge[3] = "40대";
			tempAge[4] = "50대 이상";
			tempAge[5] = "전체";
			tempGender[0] = "여성";
			tempGender[1] = "남성";
			tempGender[2] = "전체";
			tempSkin[0] = "건성";
			tempSkin[1] = "지성";
			tempSkin[2] = "여드름성";
			tempSkin[3] = "전체";
						
			List<productDto>list2 = rankService.setFilterProductList(ages==null?tempAge:ages,genders==null?tempGender:genders,skins==null?tempSkin:skins,catelname,catesname);	
			model.addAttribute("list",list2);

			int random = (int)(Math.random()*10)+1;
			System.out.println("random"+random);
			model.addAttribute("random", random+"");
			
			return "ranking/list";
			
		}
		return "error";
		
	}//list END

	@RequestMapping(value = "/refilter.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String refilter(HttpServletRequest request, Locale locale, Model model, productDto dto) {
		return null;
	}
	
	@RequestMapping(value = "/productdetail.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String productDetail(HttpServletRequest request, Locale locale, Model model, productDto dto) {
		
		int product_no = Integer.parseInt(request.getParameter("no"));
		String product_ingre = request.getParameter("ingre");
		System.out.println("product_ingre ["+product_ingre+"]");
		productDto pDto = new productDto(product_no,product_ingre);
		
		
		productDto productInfo = rankService.getDetailProductList(product_no);
		model.addAttribute("proInfo",productInfo);
		
		reviewDto reviewDetail = rankService.getDetailPoint(product_no);
		model.addAttribute("detailReview",reviewDetail);
		
		List<reviewDto> reviewInfo = rankService.getProductReview(product_no);
		model.addAttribute("reviewInfo",reviewInfo);

		List<ingreDto> ingreInfo = rankService.getProductIngre(pDto);
		System.out.println("오류 위치 찾기 aaaaa");
		model.addAttribute("ingreInfo",ingreInfo);
		System.out.println("오류 위치 찾기 bbbb");
		model.addAttribute("callbackReview", product_ingre);
		System.out.println("오류 위치 찾기 cccccc");
		
		int random = (int)(Math.random()*10)+1;
		model.addAttribute("random", random);
		
		return "ranking/productdetail";
	}
		
		//리뷰 작성하는 페이지로 이동
		@RequestMapping(value = "/reviewpage.do", method = {RequestMethod.GET, RequestMethod.POST})
		public String callReviewPage(HttpServletRequest request, Locale locale, Model model, productDto dto, HttpSession session) {
			
			//세션 체크
			String loginInfo = (String)session.getAttribute("mem_name");
			String naverLoginInfo = (String)session.getAttribute("naverEmail");
			String status = (String)session.getAttribute("mem_status");
			
			if(status.equals("C")|| status==null) {//기업회원 세션체크
				return "youcannotwritereview";
			}else{
				if((loginInfo==null || loginInfo=="") && (naverLoginInfo==null || naverLoginInfo=="")) {
					return "doLogin";
				}else {
						
					int pNo = Integer.parseInt(request.getParameter("pNo")); 
					String callbackIngre = request.getParameter("ingre");
					productDto reviewProduct = rankService.getOneProductInfo(pNo);
					
					if(session.getAttribute("naverNickname")!=null) {
						String reviewNick = (String) session.getAttribute("naverNickname");
						model.addAttribute("writer", reviewNick);
						System.out.println("홈컨트롤러>리뷰작성페이지로 이동, 작성자닉네임(네이버로그인) : ["+reviewNick+"]");
					}else if(session.getAttribute("mem_nick")!=null) {
						String reviewNick = (String) session.getAttribute("mem_nick");
						model.addAttribute("writer", reviewNick);
						System.out.println("홈컨트롤러>리뷰작성페이지로 이동, 작성자닉네임(일반회원로그인) : ["+reviewNick+"]");
					}else {
						System.out.println("세션이 없음");
						return "login";
					}
					model.addAttribute("product", reviewProduct);
					model.addAttribute("callbackIngre", callbackIngre);
					return "review/insertReview";
					}
			}
			
			
		}
	
		//리뷰 작성하는 페이지로 이동
		@RequestMapping(value = "/insertReview.do", method = {RequestMethod.GET, RequestMethod.POST})
		public String insertReview(HttpServletRequest request, Locale locale, Model model, productDto dto, HttpSession session) {
			
			int review_productno = Integer.parseInt(request.getParameter("product_no"));
			String review_membernick = request.getParameter("writer");
			System.out.println("review_membernick"+review_membernick);
			String review_conts = request.getParameter("reviewconts");
			System.out.println("review_conts"+review_conts);
			System.out.println("review_point"+request.getParameter("review_rating"));
			Double review_point = Double.parseDouble(request.getParameter("review_rating"));
			String callbackIngre = request.getParameter("callbackIngre");
			
			reviewDto rDto = new reviewDto(review_productno,review_membernick,review_conts,review_point);
			
			boolean isS = rankService.insertReview(request, rDto);

			if(isS) {
				System.out.println("리뷰 작성에 성공!");
				return "redirect:productdetail.do?no="+review_productno+"&ingre="+callbackIngre;
				
			}else {
				System.out.println("리뷰 작성에 실패했습니다.");
				return "redirect:productdetail.do?no="+review_productno+"&ingre="+callbackIngre;
			}
		}//insertReview END
		
		@ResponseBody
		@RequestMapping(value = "/deleteReview.do", method = {RequestMethod.GET, RequestMethod.POST})
		public String deleteReview(HttpServletRequest request, Locale locale, Model model, productDto pDto, reviewDto rDto, HttpSession session) {
			
			//세션 체크
			String loginInfo = (String)session.getAttribute("mem_nick");
			String naverLoginInfo = (String)session.getAttribute("naverNickname");
			
			if((loginInfo==null || loginInfo=="") && (naverLoginInfo==null || naverLoginInfo=="")) {
				return "doLogin";
				
			}else {			
				int review_productno = Integer.parseInt(request.getParameter("productNo"));
				String callbackIngre = request.getParameter("ingre");
				int review_no = Integer.parseInt(request.getParameter("reviewNo"));
				System.out.println("review_no ["+review_no+"]");
				String review_membernick = request.getParameter("reviewNick"); 
				System.out.println("reviewNick ["+review_membernick+"]");
				
				reviewDto rDDto = new reviewDto(review_no, review_productno, review_membernick);
				int isS = rankService.deleteReview(rDDto);
				
				return isS+"";
			}
			
		}//deleteReview END
		
		

		//리뷰 작성하는 페이지로 이동
		@RequestMapping(value = "/brandpage.do", method = {RequestMethod.GET, RequestMethod.POST})
		public String getBrandlist(HttpServletRequest request, Locale locale, Model model, productDto dto, HttpSession session) {
			
			String brand = request.getParameter("brand");
			
			List<productDto> brandList = rankService.getBrandlist(brand);	
			model.addAttribute("list",brandList);

			int random = (int)(Math.random()*10)+1;
			System.out.println("random"+random);
			model.addAttribute("random", random+"");
			
			return "ranking/list";
			
		}
		
}


//쓰지 않는 것 모아두기
