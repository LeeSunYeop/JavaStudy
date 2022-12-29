package kr.co.board.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.board.domain.BoardDTO;
import kr.co.board.repository.BoardDAO;
import kr.co.common.domain.PageTO;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Inject
	private BoardDAO bDao;
	
	@Override
	public void insert(BoardDTO dto) {
		
		bDao.insert(dto);
	}

	@Override
	public List<BoardDTO> list() {
		List<BoardDTO> list = bDao.list();
		
		return list;
	}

	@Override
	public PageTO<BoardDTO> list(Map<String, String> map) {
		int curpage = -1;
		
		String scurpage = map.get("curpage");
		if (scurpage != null) {
			curpage = Integer.parseInt(scurpage);
		}
		
		int amount = bDao.getAmount(map);
		
		PageTO<BoardDTO> pt =
				new PageTO<BoardDTO>(curpage, amount, map.get("criteria"), map.get("keyword"));
		
		List<BoardDTO> list = bDao.list(map, pt);
		
		pt.setList(list);
		
		return pt;
	}

}
