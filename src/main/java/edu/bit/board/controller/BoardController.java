package edu.bit.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.bit.board.page.Criteria;
import edu.bit.board.page.PageVO;
import edu.bit.board.service.BoardService;
import edu.bit.board.vo.BoardVO;
import jdk.internal.org.jline.utils.Log;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class BoardController {
   
   @Autowired 
   private BoardService boardService;
   
   @GetMapping("/list2")
   public String list2(Criteria cri, Model model) {
      log.info("list2()..");      
      log.info(cri);
      
      model.addAttribute("list",boardService.getList(cri));
      int total = boardService.getTotal(cri);
      
      log.info("total"+total);
      model.addAttribute("pageMaker", new PageVO(cri,total));
      
      return "list2";
   }
   
   @GetMapping("/content_view")
   public String content_view(BoardVO boardVO, Model model) {
      log.info("content_view()..");      
      
      BoardVO vo = boardService.get(boardVO.getBid());
      
      boardService.upHit(boardVO.getBid());
      
      model.addAttribute("content_view",boardService.get(boardVO.getBid()));
      return "content_view";
   }
   
   @PostMapping("/modify")
   public String modify(BoardVO boardVO, Model model) {
      log.info("modify()..");      
      
       boardService.modify(boardVO);
      
      return "redirect:list2";
   }
   //   delete?bid=${content_view.bid}
   @GetMapping("/delete")
   public String delete(BoardVO boardVO, Model model) {
      log.info("delete()..");      
      
       boardService.remove(boardVO.getBid());
      
      return "redirect:list2";
   }
   
   @GetMapping("/write_view")
   public String write_view() {
      log.info("write_view()..");    
      
      return "write_view";
   }
   //reply_view?bid=2
   @GetMapping("/reply_view")
   public String reply_view(BoardVO boardVO,Model model) {
      log.info("reply_view()..");    
      model.addAttribute("reply_view",boardService.get(boardVO.getBid()));
      return "reply_view";
   }
   
   @PostMapping("/reply")
   public String reply(BoardVO boardVO) {
      log.info("reply()..");    
      
      boardService.writeReply(boardVO);
      
      return "redirect:list2";
   }
   
   @PostMapping("/write")
   public String write(BoardVO boardVO) {
      log.info("write()..");    
      
       boardService.writeBoard(boardVO);
      
      return "redirect:list2";
   }
   
}