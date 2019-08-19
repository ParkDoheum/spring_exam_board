package com.doheum.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doheum.board.dao.BoardMapper;
import com.doheum.board.model.BoardVO;

@Service
public class BoardService {
	
	@Autowired
	private BoardMapper mapper;
	
	public List<BoardVO> getBoardList() {
		return mapper.getBoardList();
	}
}
