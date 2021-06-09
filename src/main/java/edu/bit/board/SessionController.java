package edu.bit.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
@RequestMapping("/session/*") // session로 치고 들어오는것들은 SessionController에서 컨트롤 하겠다!
public class SessionController {
   

   // ../session/create 
   @RequestMapping("/create")
   public String create(HttpServletRequest request) {
      log.info("/session/create/..");    
      
      HttpSession session = request.getSession();
      session.setAttribute("tel", "010-9999-9999");
      session.setAttribute("name", "박현성");
      
      
      return "/session/get";
   }
   
   
  

   
}