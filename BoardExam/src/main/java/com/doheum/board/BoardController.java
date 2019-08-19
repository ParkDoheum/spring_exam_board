package com.doheum.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService service;
		
	@GetMapping("/list")
	public String list(Model model) {	
		model.addAttribute("list", service.getBoardList());
		return "list";
	}
}





