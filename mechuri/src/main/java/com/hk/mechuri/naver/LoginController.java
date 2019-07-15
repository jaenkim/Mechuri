package com.hk.mechuri.naver;
import java.io.IOException;                            
                    
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

/**
 * Handles requests for the application home page.
 */
@Controller
public class LoginController {

    /* NaverLoginBO */
    private NaverLoginBO naverLoginBO;
    private String apiResult = null;
    
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
    @RequestMapping(value = "/callback.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String callback(Model model, @RequestParam String code, @RequestParam String state, HttpSession session)
			throws IOException {
		System.out.println("여기는 callback");
		OAuth2AccessToken oauthToken;
        oauthToken = naverLoginBO.getAccessToken(session, code, state);
        //로그인 사용자 정보를 읽어온다.
	    apiResult = naverLoginBO.getUserProfile(oauthToken);
	    System.out.println("apiResult ["+apiResult+"]");
		model.addAttribute("result", apiResult);
		System.out.println("로그인 컨트롤러에서 jsp로 출력전 모델 내용 보기(at콜백점두) ["+model.getClass()+"]");
		System.out.println("로그인 컨트롤러에서 jsp로 출력전 모델 내용 보기(at콜백점두) ["+model.toString()+"]");
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

}