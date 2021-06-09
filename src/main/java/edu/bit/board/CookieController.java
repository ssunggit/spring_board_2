package edu.bit.board;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.bit.board.page.Criteria;

import edu.bit.board.service.BoardService;
import edu.bit.board.vo.BoardVO;
import jdk.internal.org.jline.utils.Log;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/cookie/*") // cookie로 치고 들어오는것들은 CookieController에서 컨트롤 하겠다!
public class CookieController {
   

   // cookie/create 로 치고 들어오면 밑에꺼로 관리
   @RequestMapping("/create")
   public String create(HttpServletResponse response) {
      log.info("/cookie/create/..");    
      
      // 쿠키 이름을 tel으로 생성
      Cookie setCookie = new Cookie("tel","010-3333-3333");
      // 기간을 하루로 지정(60초 * 60분 * 24시간)
      setCookie.setMaxAge(60 * 60 * 24);
      // response에 Cookie 추가
      response.addCookie(setCookie);
      
      return "redirect:/cookie/get";
   }
   
   
   @RequestMapping("/get")
   public String get(HttpServletRequest request) {
      log.info("/cookie/get/..");  
      // 모든 쿠키의 정보를 cookies에 저장
      Cookie[] cookies = request.getCookies();
      
      if(cookies!= null) {
          for(int i =0; i < cookies.length;i++) {
           System.out.println(cookies[i].getName());   
           System.out.println(cookies[i].getValue());   
          }
      }
      
      return "cookie/cookieget";
   }
   
  
   @RequestMapping("/del")
   public String del(HttpServletRequest request, HttpServletResponse response) {
      log.info("/cookie/dek/..");  
      // 모든 쿠키의 정보를 cookies에 저장
      Cookie[] cookies = request.getCookies();
      
      if(cookies!= null) {
          for(int i =0; i < cookies.length;i++) {
           System.out.println(cookies[i].getName());   
           System.out.println(cookies[i].getValue()); 
           
           cookies[i].setMaxAge(0);
           // 유효시간을 0으로 설정
           response.addCookie(cookies[i]);
          }
      }
      
      return "redirect:/cookie/get";
   }
   

   
}