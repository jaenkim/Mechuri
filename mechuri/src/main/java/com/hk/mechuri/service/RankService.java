package com.hk.mechuri.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.hk.mechuri.daos.iRankDao;
import com.hk.mechuri.dtos.filterDto;
import com.hk.mechuri.dtos.ingreDto;
import com.hk.mechuri.dtos.productDto;
import com.hk.mechuri.dtos.reviewDto;
import com.hk.mechuri.list.SearchCriteria;

@Service
public class RankService implements iRankService {

	@Autowired
	private iRankDao rankDao;

	//전체 상품의 랭링 목록을 출력함
	@Override
	public List<productDto> getAllProductList(){
		return rankDao.getAllProductList();
	}

	@Override
	public List<productDto> getFilterProductList(filterDto dto){
		return rankDao.getFilterProductList(dto);
	}
	//필터에서 뭣 좀 해보려 한것 
	@Override
	public List<productDto> Filter(String[] ageArray, String[] genderArray, String[] cateArray) {
		return rankDao.FilterDao(ageArray,genderArray,cateArray);		
	}
	
	@Override
	public List<productDto> setFilterProductList(String[] ages, String[] genders, String[] skins, String catelname, String catesname) {
		return rankDao.setFilterProductList(ages,genders,skins,catelname, catesname);
	}

	@Override
	public productDto getDetailProductList(int product_no) {
		System.out.println("서비스의 제품상세보기 메서드에서 출력해보는 제품번호 매개변수 ["+product_no+"]");
		return rankDao.getDetailProductList(product_no);
	}
	@Override
	public reviewDto getDetailPoint(int product_no) {	
		return rankDao.getDetailPoint(product_no);
	}
	@Override
	public List<reviewDto> getProductReview(int product_no) {
		System.out.println("서비스의 리뷰 전체보기 메서드에서 출력해보는 제품번호 매개변수 ["+product_no+"]");
		return rankDao.getProductReview(product_no);
	}
	@Override
	public List<ingreDto> getProductIngre(productDto pDto) {
		return rankDao.getProductIngre(pDto);
	}

	//여기부터 검색입니당...............................

	@Override            
	public List<productDto> listSearch(SearchCriteria scri) throws Exception{ //목록+페이징+검색
		return rankDao.listSearch(scri);
	}

	@Override
	public int countSearch(SearchCriteria scri) throws Exception{ //검색 결과 갯수
		return rankDao.countSearch(scri);
	}


	//리뷰 작성할 때, 작성되는 리뷰의 대상이되는 제품정보를 불러오는 메서드
	@Override
	public productDto getOneProductInfo(int pNo) {
		return rankDao.getOneProductInfo(pNo);
	}
	
	//리뷰 저장 메서드
	@Override
	public boolean insertReview(HttpServletRequest request, reviewDto rDto) {
		System.out.println("오류위치찾기1");
		int review_productno = rDto.getReview_productno();
		String review_membernick = rDto.getReview_membernick();
		String review_conts = rDto.getReview_conts();
		Double review_point = rDto.getReview_point();
		System.out.println("오류위치찾기2");
		int isS = 0;
		System.out.println("오류위치찾기3");
		MultipartHttpServletRequest multi=(MultipartHttpServletRequest)request;
		System.out.println("서비스 파일입력 중 multi ["+multi+"]");
		MultipartFile multiFile=multi.getFile("filename");
		System.out.println("서비스 파일입력 중 multiFile ["+multiFile+"]");
		String review_originfile=multiFile.getOriginalFilename();
		System.out.println("서비스 파일입력 중 review_originfile ["+review_originfile+"]");

		if(review_originfile=="") {
			System.out.println("서비스insertFileInfo오리진파일 없을 때 여기들어옴 if문 안");
			isS=rankDao.insertReview(new reviewDto(review_productno,review_membernick,review_conts,review_point,"empty","empty",0));
		}else {
			String creatUUID = UUID.randomUUID().toString().replaceAll("-", "");
			String review_storedfile=creatUUID+review_originfile.substring(review_originfile.lastIndexOf("."));
			int review_filesize=(int)multiFile.getSize();

			//상대경로 : 내가 지정하는게 아닌 톰캣이 알아서 경로정해서 저장해줌
			//String realPath=request.getSession().getServletContext().getRealPath("upload");
			//절대경로 : 경로를 내가 직접 지정해서 저장해줘야함
			File f=new File("C:/Users/alfk0/git/Mechuri/mechuri/src/main/webapp/upload/"+review_storedfile); //미라 엘지 랩탑 경로
			//File f=new File("C:/Users/82108/git/Mechuri/mechuri/src/main/webapp/upload/"+review_storedfile);//깃에있는 경로
			//File f=new File("C:/SRCNEW02/mechuri2/src/main/webapp/upload/"+board_storedfile);//복사한폴더경로


			try {
				multiFile.transferTo(f);

				isS=rankDao.insertReview(new reviewDto(review_productno,review_membernick,review_conts,review_point,review_originfile,review_storedfile,review_filesize));	

			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return isS>0?true:false;
	}//insertReview END

	@Override
	public int deleteReview(reviewDto rDDto) {
		return rankDao.deleteReview(rDDto);
	}

	@Override
	public List<productDto> getBrandlist(String brand) {
		return rankDao.getBrandlist(brand);
	}
	
	
	
	
	
}
