package com.doheum.board.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.doheum.board.model.BoardVO;

@Mapper
@Repository
public interface BoardMapper {
	List<BoardVO> getBoardList();
	BoardVO getBoard(BoardVO vo);
	
	void insertBoard(BoardVO vo);
	
}
