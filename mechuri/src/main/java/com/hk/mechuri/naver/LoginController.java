package com.hk.mechuri.naver;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.scribejava.core.model.OAuth2AccessToken;
import com.hk.mechuri.dtos.membersDto;
import com.hk.mechuri.service.IMembersService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class LoginController {

    /* NaverLoginBO */
    private NaverLoginBO naverLoginBO;
    private String apiResult = null;
    
    @Autowired
    IMembersService membersService;
    
    @Autowired
    private void setNaverLoginBO(NaverLoginBO naverLoginBO) {
        this.naverLoginBO = naverLoginBO;
    }

    //로그인 첫 화면 요청 메소드
    @RequestMapping(value = "/login.do", method = { RequestMethod.GET, RequestMethod.POST })
    public String naverLogin(Model model, HttpSession session) {
        System.out.println("여기는 LoginController 맨 위야!!");
        /* 네이버아이디로 인증 URL을 생성하기 위하여 naverLoginBO클래스의 getAuthorizationUrl메소드 호출 */
        String naverAuthUrl = naverLoginBO.getAuthorizationUrl(session);
        System.out.println("naverLoginBO에서 세션을 확인해봤어!");
        //https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id=_1g9pc8r0RyK3g8Zeg9_&
        // redirect_uri=http%3A%2F%2Flocalhost%3A8888%2Fmechuri%2Fcallback.do&state=dfdde9af-bfa5-4162-9d21-220bcf6ebf6f
        System.out.println("네이버:" + naverAuthUrl);
        
        //네이버 
        model.addAttribute("url", naverAuthUrl);
        System.out.println("LoginController에서 login.jsp로 리턴한다");
        /* 생성한 인증 URL을 View로 전달 */
        return "login";
    }

    //네이버 로그인 성공시 callback호출 메소드

    @RequestMapping(value = "/callback", method = { RequestMethod.GET, RequestMethod.POST })
	public String callback(Model model, @RequestParam String code, @RequestParam String state, HttpSession session, HttpServletResponse response, HttpServletRequest request) throws IOException {
		System.out.println("여기는 callback");
		OAuth2AccessToken oauthToken;
        oauthToken = naverLoginBO.getAccessToken(session, code, state);
        //로그인 사용자 정보를 읽어온다.
	    apiResult = naverLoginBO.getUserProfile(oauthToken);

		model.addAttribute("result", apiResult);
		
		System.out.println("로그인 컨트롤러 콜백에서 출력하는 apiResult: ["+apiResult+"]");
		
//		네이버 로그인 정보를 세션으로 생성해야 함
		/*db에서 회원정보가 있으면 메인페이지로이동하고 없으면 naverSuccess로 이동해서 네이버 회원가입 완료시킴
		세션을 만들어서 세션에 저장*/
		//" "따옴표를  apiResult에서 제거
		String a = apiResult.replace("\"","");
		System.out.println("aa ["+a+"]");
		//apiResult에서 두번째 {의 인덱스를 찾음
		int b = a.indexOf("{",10);
		System.out.println("bb ["+b+"]");
		//apiResult에서 마지막 직전 }를 찾음
		int c = a.indexOf("}",55);
		System.out.println("cc ["+c+"]");
		//apiResult에서 id 부터 name까지 key:value 형태로 자르기 전까지 출력
		String d = a.substring(b+1, c);
		System.out.println("dd ["+d+"]");
		
		String[] array = d.split(",");
		String tempNaverID = array[0];
		String tempNaverNickname = array[1];
		String tempNaverEmail = array[2];
//		String tempNaverName = array[3];

		System.out.println("naverID ["+tempNaverID+"]");
		System.out.println("naverEmail ["+tempNaverEmail+"]");

		
		//네이버 apiResult에서 분리한 id(난수), email, name, nickName
		String naverid = tempNaverID.substring(3, tempNaverID.length());
		String naverEmail = tempNaverEmail.substring(6, tempNaverEmail.length());
//		String naverNickname = tempNaverNickname.substring(9, tempNaverNickname.length());
//		String naverName = tempNaverName.substring(5, tempNaverName.length());
		System.out.println("naverID ["+naverid+"]");
		System.out.println("naverEmail ["+naverEmail+"]");
		
		//네이버 로그인 성공 후 이전에 네이버아이디로 로그인 한 적이 있는지 확인하는 메서드
		//회원으로 등록되어 있으면 이 메서드에서 가져온 정보로 세션을 생성하고
		//naverSuccess에서 메인으로 리다이렉트 보낼 예정
		membersDto mDDto = membersService.getNameForNaverMember(naverEmail);
		model.addAttribute("isMyMem",mDDto==null?"":mDDto);
		System.out.println("model의 값은?"+model.toString());
		session=request.getSession();
		session.setAttribute("naverId", naverid);
		session.setAttribute("naverEmail", naverEmail);
		session.setAttribute("naverStatus", "M");
		
		if(mDDto != null) {
			session.setAttribute("naverNo", mDDto.getMem_no());
			session.setAttribute("naverName", mDDto.getMem_name());
			session.setAttribute("naverNickname", mDDto.getMem_nick());
		}

        /* 네이버 로그인 성공 페이지 View 호출 */
		return "naverSuccess";
	}
    
  //로그아웃
    @RequestMapping(value = "/logout", method = { RequestMethod.GET, RequestMethod.POST })
    public String logout(HttpSession session)throws IOException {
    System.out.println("여기는 logout");
    session.invalidate();
    return "redirect:index.jsp";
    }
    
    	
    @RequestMapping(value = "/naverSignUp.do", method = { RequestMethod.GET, RequestMethod.POST })
    public String naverSignUp(Model model,HttpSession session, HttpServletResponse response, HttpServletRequest request)throws IOException {
    System.out.println("여기는 로그인컨트롤러의 네이버 회원가입(naverSignUp.do)");
    
    String mem_naverid = request.getParameter("resultid");
    String mem_id = request.getParameter("resultemail");
    String mem_name = request.getParameter("resultname");
    String mem_nick = request.getParameter("resultnick"); 

    System.out.println("넘어온 아이디:"+mem_id);
  /*  membersDto mDto = new membersDto(mem_id, mem_name,mem_nick, mem_naverid);
    membersDto naverIdCheck = membersService.existNaverId(mDto);
*/
    System.out.println("로그인 컨트롤러에서 네이버회원가입을 위해 이동해볼게");
/*    if(naverIdCheck!= null ) {
    	session.setAttribute("naverName", naverIdCheck.getMem_name());
		session.setAttribute("naverNickname", naverIdCheck.getMem_nick());
    	return "ranking/main";
    }else {
*/    	System.out.println("로그인 컨트롤러 else안으로 들어오니?");
    	model.addAttribute("mem_id", mem_id);
    	model.addAttribute("mem_name",mem_name);
    	model.addAttribute("mem_nick",mem_nick);
    	model.addAttribute("mem_naverid",mem_naverid);
    	return "naverSignUp";
/*    }*/
    
    }//naverSignUp 메서드 END

}