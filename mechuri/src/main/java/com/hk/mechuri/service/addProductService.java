package com.hk.mechuri.service;





import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.hk.mechuri.daos.MessageDao;
import com.hk.mechuri.daos.addProductDao;
import com.hk.mechuri.dtos.boardDto;
import com.hk.mechuri.dtos.productDto;
import com.hk.mechuri.dtos.replyDto;
import com.hk.mechuri.dtos.reviewDto;
import com.hk.mechuri.dtos.tempinfoDto;

@Service
public class addProductService {

	@Autowired
	private addProductDao addproductDao;
	
	@Autowired
	private MessageDao msgDao;
	
	public boolean addProduct(HttpServletRequest request, productDto dto,HttpSession session) {
		
		int product_compno = (Integer)session.getAttribute("mem_no");
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

		System.out.println("용량은?"+product_ml);
		System.out.println("제품명은?"+product_name);
		
		int isS = 0;
		MultipartHttpServletRequest multi=(MultipartHttpServletRequest)request;
		MultipartFile multiFile=multi.getFile("filename");
		
		String product_originfile=multiFile.getOriginalFilename();
		String creatUUID = UUID.randomUUID().toString().replaceAll("-", "");
		String product_storedfile=creatUUID+product_originfile.substring(product_originfile.lastIndexOf("."));
		int product_filesize=(int)multiFile.getSize();
		//File f=new File("C:/SRC1/mechurizeze/src/main/webapp/upload/"+product_storedfile);
		File f=new File("C:/Users/alfk0/git/Mechuri/mechuri/src/main/webapp/upload/"+product_storedfile); //은영학원컴 깃에있는 경로
		try { 
			multiFile.transferTo(f);
	
			isS=addproductDao.addProduct(new productDto(product_compno,product_catelname,product_catesname,product_name,product_ml,product_price,product_conts,product_ingre,product_skintype,product_age,product_gender,product_originfile,product_storedfile,product_filesize));	
		} catch (IllegalStateException e) {
	e.printStackTrace();
		} catch (IOException e) {
	e.printStackTrace();
		}
		return isS>0?true:false;
	}
	
	
	public List<productDto> getAllList() {
		return addproductDao.getAllList();
	}
	
	
	
	public List<tempinfoDto> getAllList1() {
		return addproductDao.getAllList1();
	}
	
	
	public List<productDto> getProductList(int mem_no) {
		return addproductDao.getProductList(mem_no);
	}
	
	
	public boolean approveProduct(productDto pdto) {
		
		boolean isS=false;
		
		isS = addproductDao.approveProduct(pdto.getProduct_no());
		
		if(isS==true) {
			msgDao.sendMessage2(pdto);
		}
		return isS;
		
	}
	
	public productDto getUpdateProductInfo(int product_no) {
		return addproductDao.getUpdateProductInfo(product_no);
	}
	
	
	public tempinfoDto geTempinfo(int tempinfo_no) {
		return addproductDao.geTempinfo(tempinfo_no);
	}
	
	public productDto geProduct(int product_no) {
		return addproductDao.geProduct(product_no);
	}
	


	public boolean approveProduct1(tempinfoDto dto) {
	
		boolean isS=false;
		
		isS= addproductDao.approveProduct1(dto);	
		
		if(isS==true) {
			msgDao.sendMessage3(dto);
		}
		return isS;
	}



	public boolean productdj(Integer product_no) {
		return addproductDao.productdj(product_no);
	}
	
	
	public boolean productdel(Integer product_no) {
		return addproductDao.productdel(product_no);
	}
	
	
	public boolean tempinfoInsert(HttpServletRequest request, tempinfoDto dto) {
		
			
		int isS = 0;
		MultipartHttpServletRequest multi=(MultipartHttpServletRequest)request;
		MultipartFile multiFile=multi.getFile("filename");
		
		String product_originfile=multiFile.getOriginalFilename();
		if(product_originfile==null||product_originfile=="") {
			isS=addproductDao.tempinfoInsert(new tempinfoDto(Integer.parseInt(request.getParameter("pno")),request.getParameter("tempinfo_name"),request.getParameter("tempinfo_ml"),request.getParameter("tempinfo_price"),request.getParameter("tempinfo_conts"),request.getParameter("tempinfo_ingre"),request.getParameter("tempinfo_skintype"),request.getParameter("tempinfo_age"),request.getParameter("tempinfo_gender"),"empty","empty",0));	
		}else {
		String creatUUID = UUID.randomUUID().toString().replaceAll("-", "");
		String product_storedfile=creatUUID+product_originfile.substring(product_originfile.lastIndexOf("."));
		int product_filesize=(int)multiFile.getSize();
		//File f=new File("C:/SRC1/mechurizeze/src/main/webapp/upload/"+product_storedfile);
		File f=new File("C:/Users/alfk0/git/Mechuri/mechuri/src/main/webapp/upload/"+product_storedfile);
		try {
			multiFile.transferTo(f);
			dto.setTempinfo_originfile(product_originfile);
			dto.setTempinfo_storedfile(product_storedfile);
			dto.setTempinfo_filesize(product_filesize);
			isS=addproductDao.tempinfoInsert(dto);	
		} catch (IllegalStateException e) {
	e.printStackTrace();
		} catch (IOException e) {
	e.printStackTrace();
		}
		}
		return isS>0?true:false;
	}
	
	
	public List<boardDto> myboardlist(String mem_nick) {
		return addproductDao.myboardlist(mem_nick);
	}
	
	public List<reviewDto> myreviewlist(String mem_nick) {
		return addproductDao.myreviewlist(mem_nick);
	}
	
	public List<replyDto> myreplylist(String mem_nick) {
		return addproductDao.myreplylist(mem_nick);
	}


	public List<boardDto> mainCommuList() {
		return addproductDao.mainCommuList();
	}
	
	public List<productDto> mainRankList() {
		return addproductDao.mainRankList();
	}
}

