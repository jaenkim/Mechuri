package com.hk.mechuri.list;

public class SearchCriteria extends Criteria{//검색 타입(제품이름, 카테고리, 브랜드명)과 검색어는 거의 항시, 고정적으로 사용되니 클래스(dto)로 만듦

 private String searchType ="";
 private String keyword = "";
 
 public String getSearchType() {
  return searchType;
 }
 public void setSearchType(String searchType) {
  this.searchType = searchType;
 }
 public String getKeyword() {
  return keyword;
 }
 public void setKeyword(String keyword) {
  this.keyword = keyword;
 }
@Override
public String toString() {
	return super.toString() + " SearchCriteria [searchType=" + searchType + ", keyword="
			+ keyword + "]";
}
 
 
}

