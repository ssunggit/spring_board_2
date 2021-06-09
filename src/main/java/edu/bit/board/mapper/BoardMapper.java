package edu.bit.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.bit.board.page.Criteria;
import edu.bit.board.vo.BoardVO;

@Mapper
public interface BoardMapper {
	List<BoardVO> getList();
	BoardVO read(int bid);
	void update(BoardVO boardVO);
	void delete(int bid);
	void insertBoard(BoardVO boardVO);
	
	void updateShape(BoardVO boardVO);
	void insertReply(BoardVO boardVO);
	void updateHit(int bid);
    int getTotalCount(Criteria cri);
    List<BoardVO> getListWithPaging(Criteria criteria);
   
    
}
