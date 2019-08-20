package com.doheum.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.doheum.board.model.BoardVO;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService service;
		
	@GetMapping("/list")
	public String list(Model model) {	
		model.addAttribute("list", service.getBoardList());
		return returnFilePath("list");
	}
	
	@GetMapping("/regmodForm/{i}")
	public String writeForm(@PathVariable("i") int i, Model model) {
		BoardVO vo = null;
		if(i > 0) { //수정
			BoardVO param = new BoardVO();
			param.setI(i);
			vo = service.getBoard(param);
		} else {
			vo = new BoardVO();
		}
		
		model.addAttribute("boardVO", vo);
		return returnFilePath("regmodForm");
	}
	
	@PostMapping("/regmod")
	public RedirectView write(@ModelAttribute BoardVO boardVO) {
		System.out.println("i : " + boardVO.getI());
		System.out.println("title : " + boardVO.getTitle());
		System.out.println("content : " + boardVO.getContent());
		
		if(boardVO.getI() == 0) { //등록
			service.insertBoard(boardVO);			
		} else { //수정
			service.modBoard(boardVO);
		}		
		
		return new RedirectView("list");
	}
	
	@GetMapping("/detail/{i}")
	public String detail(@PathVariable("i") int i, Model model) {
		BoardVO param = new BoardVO();
		param.setI(i);
		System.out.println(" i : " + i);
		model.addAttribute("data", service.getBoard(param));
		
		return returnFilePath("detail");
	}
	
	private String returnFilePath(final String fileNm) {
		return "board/" + fileNm;
	}
}





