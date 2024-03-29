package kr.co.board.controller;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.omg.CORBA.portable.InputStream;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	
	@RequestMapping(value = "/showOrDownload", method = RequestMethod.GET)
	public ResponseEntity<byte[]> showOrDownload(String filename){
		ResponseEntity<byte[]> entity = null;
		
	    entity = UploadFileUtils.showOrDownload(uploadPath, filename);
		
		return entity;
	}	
	
	@RequestMapping(value = "/showimgfile", method = RequestMethod.GET)
	public ResponseEntity<byte[]> showImgFile(String filename){
		ResponseEntity<byte[]> entity = null;
		
	    FileInputStream in = null;
	    
	    try {
			in = new FileInputStream(uploadPath+filename);
			
			byte[] arr = IOUtils.toByteArray(in);
			
			entity = new ResponseEntity<byte[]>(arr, HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		} finally {
			if (in != null) {				
				try {
					in.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		}
		
		return entity;
	}
	
	@RequestMapping(value = "getFilenames", method = RequestMethod.GET)
	@ResponseBody
	public List<String> getFilenames(int bno){
		
		return bService.getFilenames(bno);
	}
	
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	@ResponseBody
	public String insert(MultipartHttpServletRequest request) {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		
		Map<String, MultipartFile> map = request.getFileMap();
		
		Set<String> set = map.keySet();
		
		List<String> list = new ArrayList<String>(set);
		
		List<String> uploadedFileList = new ArrayList<String>();	
		
		for(int i=0;i<list.size();i++) {
			String key = list.get(i);
			
			
			MultipartFile file = map.get(key);
			
			try {
				String uploadedFilename 
				= UploadFileUtils.uploadFile(uploadPath, file, sc);
				
				uploadedFileList.add(uploadedFilename);
				
				Thread.sleep(50);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		BoardDTO dto = new BoardDTO(id, pw, title, content);
		dto.setUploadedFileList(uploadedFileList);
		int result = 1;
		
		try {
			bService.insert(dto);
		} catch (Exception e1) {
			e1.printStackTrace();
			
			result = 0;
		}
		
		
		if(result == 0) {
			System.out.println("업로드한 파일을 삭제하자.");
			
			try {
				UploadFileUtils.deleteUploadFiles(uploadPath, uploadedFileList);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}
		
		return dto.getBno()+"";
	}
	
	@RequestMapping(value = "fuajaxtest", method = RequestMethod.POST)
	@ResponseBody
	public String fuAjaxTest(MultipartHttpServletRequest request) {
		
		String id = request.getParameter("id");
		
		Map<String, MultipartFile> map = request.getFileMap();
		
		Set<String> set = map.keySet();
		
		List<String> list = new ArrayList<String>(set);
		
			
		
		for(int i=0;i<list.size();i++) {
			String key = list.get(i);
			
			
			MultipartFile file = map.get(key);
			
			try {
				UploadFileUtils.uploadFile(uploadPath, file, sc);
				
				Thread.sleep(50);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return "ok";
	}
	

	
	
//	@RequestMapping(value = "fuajaxtest", method = RequestMethod.POST)
//	@ResponseBody
//	public String fuAjaxTest(MultipartHttpServletRequest request) {
//		
//		String id = request.getParameter("id");
//		
//		List<MultipartFile> list = request.getFiles("file");
//		
//		for(int i=0;i<list.size();i++) {
//			MultipartFile file = list.get(i);
//			
//			try {
//				UploadFileUtils.uploadFile(uploadPath, file, sc);
//				
//				Thread.sleep(50);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//		
//		return "ok";
//	}
	
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
	
	
	
//	@RequestMapping(value = "/update", method = RequestMethod.POST)
//	@ResponseBody
//	public int update(@RequestParam Map<String, Object> map) {
//		int result = 0;
//		
//		result = bService.update(map);
//		
//		
//		return result;
//	}
	
	@RequestMapping(value = "/update/{bno}", method = RequestMethod.POST)
	@ResponseBody
	public int update(@PathVariable("bno") Integer bno, 
						MultipartHttpServletRequest request) {
		int result = 1;
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		String uploadedFileDeleteListStr = request.getParameter("uploadedFileDeleteList");
		
		String[] uploadedFileDeleteListArr = uploadedFileDeleteListStr.split(",");
		
		List<String> uploadedFileDeleteList = new ArrayList<String>();
		
		for(int i=0; i<uploadedFileDeleteListArr.length; i++) {
			String filename = uploadedFileDeleteListArr[i].trim();
			uploadedFileDeleteList.add(filename);
		}
		
		BoardDTO dto = new BoardDTO(id, bno, pw, title, content);
		
		result = bService.update(dto, uploadedFileDeleteList);
	
		return result;
	}
		
	
	@RequestMapping(value = {"/updateui/{curpage}/{criteria}/{keyword}/{bno}", 
							"/updateui/{curpage}/{bno}"}, 
							method = RequestMethod.GET)
	public String update(@PathVariable Map<String, Object> map, Model model) {
		
		BoardDTO dto = bService.updateUI(map.get("bno"));
		
		
		
		model.addAttribute("dto", dto);
		model.addAttribute("curpage", map.get("curpage"));
		model.addAttribute("criteria", map.get("criteria"));
		model.addAttribute("keyword", map.get("keyword"));
		
		return "/board/update";
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

	@RequestMapping(value = "/insert2", method = RequestMethod.POST)
	public String insert(BoardDTO dto) {		
		//bService.insert(dto);
		
		return "redirect:/board/list/";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public void insert() {

	}

}
