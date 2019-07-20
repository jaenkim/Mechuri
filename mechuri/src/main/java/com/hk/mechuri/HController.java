package com.hk.mechuri;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hk.mechuri.dtos.membersDto;
import com.hk.mechuri.dtos.msgDto;
import com.hk.mechuri.dtos.productDto;
import com.hk.mechuri.dtos.tempinfoDto;
import com.hk.mechuri.service.addProductService;
import com.hk.mechuri.service.msgService;
import com.hk.mechuri.service.userManageService;

@Controller
public class HController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@Autowired
	private msgService MsgSerivce;

	@Autowired
	private addProductService addproductService;

	@Autowired
	private userManageService usermanageService;

	@RequestMapping(value = "/msglist.do", method = RequestMethod.GET)
	public String sendMessage(HttpServletRequest request, Locale locale, Model model,HttpSession session) {
		logger.info("쪽지 보기", locale);
		int mem_no = (Integer)session.getAttribute("mem_no");
		List<msgDto> list = MsgSerivce.getAllList(mem_no);
		model.addAttribute("list", list );

		return "msg2";
	}


	@RequestMapping(value = "/addProductForm.do")
	public String addProductForm(Locale locale, Model model) {
		logger.info("제품등록신청 폼", locale);
		return "addProduct2";
	}


	@RequestMapping(value = "/addProduct.do", method = RequestMethod.POST)
	public String addProduct(Locale locale, Model model, HttpServletRequest request,HttpSession session) {
		logger.info("제품등록신청 ing....", locale);

		int mem_no = (Integer)session.getAttribute("mem_no");

		int product_compno = mem_no;
		String product_catelname = request.getParameter("filter_catelname");
		String product_catesname = request.getParameter("filter_catesname");
		String product_name = request.getParameter("product_name");
		String product_ml = request.getParameter("product_ml");
		String product_price = request.getParameter("product_price");
		String	product_conts = request.getParameter("product_conts");
		String	product_ingre = request.getParameter("product_ingre");
		String	product_skintype = request.getParameter("product_skintype");
		String	product_age = request.getParameter("product_age");
		String	product_gender = request.getParameter("product_gender");

		productDto dto = new productDto(product_compno,product_catelname,product_catesname,product_name,product_ml,product_price,product_conts,product_ingre,product_skintype,product_age,product_gender);

		boolean isS = addproductService.addProduct(request, dto,session);

		if(isS) {
			return "redirect:addProductForm.do";
		}else {
			return "error";
		}


	}




	@RequestMapping(value = "/productadminlist.do", method = RequestMethod.GET)
	public String productadminlist(HttpServletRequest request, Locale locale, Model model) {
		logger.info("승인해야 할 제품 목록 보기", locale);

		List<productDto> list = addproductService.getAllList();
		model.addAttribute("list", list );


		List<tempinfoDto> list1 = addproductService.getAllList1();
		model.addAttribute("list1", list1 );

		return "productapproveForm";
	}


	@RequestMapping(value = "/approveProduct.do")
	public String approveProduct(productDto pdto, Locale locale, Model model,HttpServletRequest request) {
		logger.info("제품 등록 승인 ing...", locale);
		
		pdto.setProduct_name(request.getParameter("product_name"));
		pdto.setProduct_compno(Integer.parseInt(request.getParameter("product_compno")));
		
		System.out.println("컨트롤러에서 dto.no>>"+pdto.getProduct_no());
		System.out.println("컨트롤러에서 dto.name>>"+pdto.getProduct_name());
		System.out.println("컨트롤러에서 dto.compno>>"+pdto.getProduct_compno());
		

		boolean isS= addproductService.approveProduct(pdto.getProduct_no());
		if(isS) {
			boolean msgisS = MsgSerivce.sendMessage2(pdto);
			if(msgisS) {
					return "redirect:productadminlist.do";
			}else {return "error";}
		}return "error";
	}



	@RequestMapping(value = "/approveProduct1.do", method = RequestMethod.POST)
	public String approveProduct1(Integer tempinfo_no, tempinfoDto dto, Locale locale, Model model) {
		logger.info("제품 수정 승인 ing...", locale);

		System.out.println("tempinfo 이름은?>>>"+tempinfo_no);

		dto  = addproductService.geTempinfo(tempinfo_no);

		boolean isS= addproductService.approveProduct1(dto);
		if(isS) {
			return "redirect:productadminlist.do";
		}else {
			return "error";
		}

	}


	@RequestMapping(value = "/ProductList.do", method = RequestMethod.GET)
	public String productList(HttpServletRequest request, Locale locale, Model model,HttpSession session) {
		logger.info("자사 제품 목록 보기", locale);

		int mem_no = (Integer)session.getAttribute("mem_no");
		List<productDto> list = addproductService.getProductList(mem_no);
		model.addAttribute("list", list );



		return "productList";
	}

	@RequestMapping(value = "/productUpdateForm.do")
	public String productUpdateForm(Integer product_no, Locale locale, Model model,HttpServletRequest request) {
		logger.info("수정 할 제품 폼 보기", locale);

		productDto dto = addproductService.getUpdateProductInfo(product_no);
		model.addAttribute("dto", dto );

		return "productUpdateForm";


	}

	@RequestMapping(value = "/tempinfoInsert.do", method = RequestMethod.POST)
	public String tempinfoInsert(Locale locale, Model model, HttpServletRequest request,tempinfoDto dto,Integer pno) {
		logger.info("제품 수정(승인 아직 안된 거..tempinfo에 담는 과정) ing....", locale);

		dto.setTempinfo_no(pno);
		boolean isS = addproductService.tempinfoInsert(request, dto);

		if(isS) {
					return "redirect:productUpdateForm.do?product_no="+pno;
		}else {
			return "error";
		}


	}



	@RequestMapping(value = "/productdj.do")
	public String productdj(Integer product_no, Locale locale, Model model,HttpServletRequest request) {
		logger.info("제품 단종 처리 ing...", locale);

		boolean isS= addproductService.productdj(product_no);
		if(isS) {
			return "redirect:productUpdateForm.do?product_no="+product_no;
		}else {
			return "error";
		}

	}



	@RequestMapping(value = "/productdel.do")
	public String productdel(Integer product_no, Locale locale, Model model,HttpServletRequest request) {
		logger.info("제품 삭제 ing...", locale);

		boolean isS= addproductService.productdel(product_no);
		if(isS) {
			return "redirect:ProductList.do";
		}else {
			return "error";
		}

	}



	@RequestMapping(value = "/userManage.do", method = RequestMethod.GET)
	public String userManage(HttpServletRequest request, Locale locale, Model model) {
		logger.info("일반회원 목록 보기", locale);

		List<membersDto> members = usermanageService.getUserList();
		model.addAttribute("members", members );


		return "memList";
	}


	@RequestMapping(value = "/comUserManage.do", method = RequestMethod.GET)
	public String commUserManage(HttpServletRequest request, Locale locale, Model model) {
		logger.info("기업회원 목록 보기", locale);

		List<membersDto> members = usermanageService.getComUserList();
		model.addAttribute("commembers", members );


		return "comList";
	}


	@RequestMapping(value = "/userDelete.do")
	public String userDelete(Integer mem_no, Locale locale, Model model,String mem_status) throws IOException {
		logger.info("회원 삭제(탈퇴) ing...", locale);

		boolean isS= usermanageService.userdel(mem_no);
		if(isS) {
			if(mem_status.equals("M")) {
				return "redirect:userManage.do";
			}else if(mem_status.equals("C")) {
				return "redirect:comUserManage.do";
			}
			}
		else {
			return "error";
		}
		return "error";
	}




	@RequestMapping(value = "/compAppr.do")
	public String compAppr(Integer mem_no, Locale locale, Model model) {
		logger.info("기업 가입 승인 처리 ing...", locale);

		boolean isS= usermanageService.compAppr(mem_no);
		if(isS) {
			return "redirect:comUserManage.do";
		}else {
			return "error";
		}

	}


	@RequestMapping(value = "/comInfo.do", method = RequestMethod.GET)
	public String comInfo(HttpServletRequest request, Locale locale, Model model,HttpSession session) {
		logger.info("내 정보(기업회원) 보기", locale);

		int mem_no = (Integer)session.getAttribute("mem_no");
		List<membersDto> cominfo = usermanageService.comInfo(mem_no);
		model.addAttribute("cominfo", cominfo );


		return "comInfo";
	}

	@RequestMapping(value = "/comtal.do")
	public String comtal(Integer mem_no, Locale locale, Model model,HttpSession session) {
		logger.info("기업 탈퇴 처리(실제로 탈퇴X, 탈퇴플래그만 바꿈) ing...", locale);

		boolean isS= usermanageService.comtal(mem_no);
		if(isS) {
			session.invalidate();
			return "redirect:main.do";
		}else {
			return "error";
		}

	}

	@RequestMapping(value = "/infoUpdate.do")
	public String infoUpdate(membersDto dto, Locale locale, Model model,String mem_status) {
		logger.info("기업/일반회원 정보 수정 ing...", locale);

		boolean isS= usermanageService.infoUpdate(dto);
		if(isS) {
			if(mem_status.equals("C"))
			return "redirect:comInfo.do";
			else if(mem_status.equals("M")) {
				return "redirect:userInfo.do";

			}return "error";
		}else {
			return "error";
		}

	}


	@RequestMapping(value = "/userInfo.do", method = RequestMethod.GET)
	public String userInfo(HttpServletRequest request, Locale locale, Model model,HttpSession session) {
		logger.info("내 정보(일반회원) 보기", locale);

		int mem_no = (Integer)session.getAttribute("mem_no");
		List<membersDto> userInfo = usermanageService.userInfo(mem_no);
		model.addAttribute("userInfo", userInfo );


		return "userInfo";
	}


}
