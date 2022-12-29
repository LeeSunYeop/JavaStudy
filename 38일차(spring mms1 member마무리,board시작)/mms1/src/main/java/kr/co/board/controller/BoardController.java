package kr.co.board.controller;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.board.domain.BoardDTO;
import kr.co.board.service.BoardService;
import kr.co.common.domain.PageTO;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Inject
	private BoardService bService;
	
	@RequestMapping(value = {"/list", "/list/{curpage}", 
								"/list/{curpage}/{criteria}/{keyword}"}, 
							method = RequestMethod.GET)	
	public String list(Model model, @PathVariable Map<String, String> map) {	
		
		PageTO<BoardDTO> pt = bService.list(map);
		
		model.addAttribute("list", pt.getList());
		model.addAttribute("pt", pt);
		
		return "board/list";
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(BoardDTO dto) {
				
		bService.insert(dto);
	
		return "redirect:/board/list";
		
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public void insert() {
		
	}
	
	

}
