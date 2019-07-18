package com.hk.mechuri.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	@Override
	public List<productDto> Filter(String[] ageArray, String[] genderArray, String[] cateArray) {
		System.out.println("서비스(ageArray) ["+ageArray[0]+"]");
		System.out.println("서비스(genderArray) ["+genderArray[0]+"]");
		return rankDao.FilterDao(ageArray,genderArray,cateArray);		
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


}


//@Override
//public String ageFilter(String[] ageArray) {
//return rankDao.ageFilterDao(ageArray);
//}
//
//@Override
//public String genderFilter(String[] genderFilter) {
//return rankDao.genderFilterDao(genderFilter);
//}
//
//@Override
//public String categoryFilter(String[] cateArray) {
//return rankDao.categoryFilterDao(cateArray);
//}


//@Override
//public List<productDto> getAllProductListbyHighprice() {
//	// TODO Auto-generated method stub
//	return null;
//}
//
//@Override
//public List<productDto> getAllProductListbyLowprice() {
//	// TODO Auto-generated method stub
//	return null;
//}
//
//@Override
//public List<productDto> getAllProductListbyASCname() {
//	// TODO Auto-generated method stub
//	return null;
//}
//
//@Override
//public List<productDto> getAllProductListbyMaxReview() {
//	// TODO Auto-generated method stub
//	return null;
//}
//
//@Override
//public List<productDto> getAllProductListbyMinReview() {
//	// TODO Auto-generated method stub
//	return null;
//}
