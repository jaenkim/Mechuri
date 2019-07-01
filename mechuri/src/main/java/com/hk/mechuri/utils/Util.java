package com.hk.mechuri.utils;

public class Util {

	//<jsp:usebean> : 액션태그 중 하나... : dto를 불러올때 사용, set/get메서드 형태로 작성
	//<jsp:setProperty>=>set메서드 실행, <jsp:getProperty>=>get메서드 실행  , usebean이랑 거의 세트로 사용함...
	
	private String arrowNbsp;   //depth의 크기만큼 공백만든거 저장할 필드

	public String getArrowNbsp() {
		return arrowNbsp;
	}

	public void setArrowNbsp(String depth) {
		String nbsp="";
		int depthInt = Integer.parseInt(depth);  //String->int로 변환
		
		for (int i=0; i<depthInt; i++) {
			nbsp+="&nbsp;&nbsp;&nbsp;";
		}
		
		this.arrowNbsp =depthInt>0?nbsp+"<img src='img/img1.png' alt='답글:'/>":"";
	}
	
	
}
