package edu.bit.board.service;

import java.util.List;

import edu.bit.board.page.Criteria;
import edu.bit.board.vo.BoardVO;

public interface BoardService {
   List<BoardVO> getList();
   BoardVO get(int bid);
   void modify(BoardVO boardVO);
   void remove(int bid);
   
   void writeBoard(BoardVO boardVO);
   void writeReply(BoardVO boardVO);
   public void upHit(int bid);
   // 페이징 처리 함수
   public int getTotal(Criteria cri);
   
   public List<BoardVO> getList(Criteria critera);
}