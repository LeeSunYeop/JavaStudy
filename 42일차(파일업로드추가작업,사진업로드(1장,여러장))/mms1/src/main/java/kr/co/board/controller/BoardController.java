package kr.co.board.controller;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.ServletContext;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;

import kr.co.board.domain.BoardDTO;
import kr.co.board.service.BoardService;
import kr.co.common.domain.PageTO;
import kr.co.common.utils.UploadFileUtils;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Inject
	private BoardService bService;
	
	@Inject
	private ServletContext sc;
		
	private String uploadPath = "D:"+File.separator+"upload";
	
	@RequestMapping(value = "fuajaxtest", method = RequestMethod.POST)
	@ResponseBody
	public String fuAjaxTest(MultipartHttpServletRequest request) {
		
		String id = request.getParameter("id");
		System.out.println(id);
		
		List<MultipartFile> list = request.getFiles("file");
		
		for(int i=0; i<list.size(); i++) {
			MultipartFile file = list.get(i);
			// list.get(i) 하고 request.getFile("file") 은 같다
			
			try {
				UploadFileUtils.uploadFile(uploadPath, file, sc);
				
				Thread.sleep(50);
			} catch (Exception e) {			
				e.printStackTrace();
			}
			
		}
		
		return "ok";
	}
	
	@RequestMapping(value = "futest", method = RequestMethod.POST)
	public String fileUploadTest(MultipartHttpServletRequest request) {
		String id = request.getParameter("id");
		MultipartFile file = request.getFile("file");
		
		try {
			UploadFileUtils.uploadFile(uploadPath, file, sc);
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
		return "redirect:/board/list";
	}
	
	@RequestMapping(value = "futest", method = RequestMethod.GET)
	//futest: fileuploadtest 줄임
	public String fileUploadTest() {
		return "/board/futest";
	}
	
	
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
		
//		String fn = UploadFileUtils.makeFilename("text.png");
//		
//		// 서버명의 파일이름이 아닌 원래의파일명을 가져오기
//		int idx = fn.indexOf("_") + 1;
//		String oriName = fn.substring(idx);  
//		System.out.println(oriName);   테스트하기위해 적은것임
		
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
