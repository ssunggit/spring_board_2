package edu.bit.board.mapper;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import edu.bit.board.vo.BoardVO;
import lombok.Setter;
import lombok.extern.log4j.Log4j;


@RunWith(SpringRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTest {
   
   @Autowired
   private BoardMapper boardMapper;
   
   
   @Test
   public void testBoardMapper() {
      assertNotNull(boardMapper);
      log.info(boardMapper);
   }
   
   @Test
   public void testGetList() {
      List<BoardVO> list = boardMapper.getList();
      
      for(BoardVO vo :list) {
         log.info(vo.getBcontent());
      }
   }
   
   @Test
   public void testRead() {
      BoardVO board = boardMapper.read(999);
      assertNotNull(board);
      assertEquals(999, board.getBid());
      assertEquals("test", board.getBname());
   }
   
   

}