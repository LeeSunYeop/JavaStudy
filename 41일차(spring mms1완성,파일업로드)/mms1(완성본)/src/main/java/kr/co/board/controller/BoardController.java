package kr.co.board.controller;

import java.io.File;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.board.domain.BoardDTO;
import kr.co.board.service.BoardService;
import kr.co.common.domain.PageTO;
import kr.co.common.utils.UploadFileUtils;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Inject
	private BoardService bService;
	
	
	@RequestMapping(value = "/delete/{bno}", method = RequestMethod.POST)
	@ResponseBody
	public Integer delete(@PathVariable Integer bno, 
			@RequestParam Map<String, Object> map) {
		Integer result = 0;
		
		map.put("bno", bno);
		
		result = bService.delete(map);
		
		return result;
	}
	
	
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public int update(@RequestParam Map<String, Object> map) {
		int result = 0;
		
		result = bService.update(map);
		
		
		return result;
	}
	
	

	@RequestMapping(value = {"/read/{bno}/{curpage}/{criteria}/{keyword}", 
			                 "/read/{bno}", 
			                 "/read/{bno}/{curpage}"}, method = RequestMethod.GET)
	public String read(@PathVariable Map<String, String> map, Model model) {
		
		String sBno = map.get("bno");
		int bno = -1;
		
		if(sBno != null) {
			bno = Integer.parseInt(sBno);
		}
		
		BoardDTO dto = bService.read(bno);
		
		model.addAttribute("dto", dto);
		
		
		String scurpage = map.get("curpage");
		int curpage = 1;
		
		if(scurpage != null) {
			curpage = Integer.parseInt(scurpage);
		}
		
		model.addAttribute("curpage", curpage);
		
		String criteria = map.get("criteria");
		String keyword = map.get("keyword");
		
		model.addAttribute("criteria", criteria);
		model.addAttribute("keyword", keyword);

		return "board/read";
	}

	@RequestMapping(value = { "/list/{criteria}/{keyword}" }, method = RequestMethod.POST)
	public String list2(Model model, @PathVariable Map<String, String> map) {

		PageTO<BoardDTO> pt = bService.list(map);

		model.addAttribute("list", pt.getList());
		model.addAttribute("pt", pt);

		return "board/list";
	}

	@RequestMapping(value = { "/list", "/list/{curpage}", "/list/{curpage}/{criteria}/{keyword}",
			"/list/{criteria}/{keyword}" }, method = RequestMethod.GET)
	public String list(Model model, @PathVariable Map<String, String> map) {
		
		UploadFileUtils.makePath("D:"+File.separator+"upload");

		PageTO<BoardDTO> pt = bService.list(map);

		model.addAttribute("list", pt.getList());
		model.addAttribute("pt", pt);

		return "board/list";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(BoardDTO dto) {
		bService.insert(dto);

		return "redirect:/board/list/";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public void insert() {

	}

}
