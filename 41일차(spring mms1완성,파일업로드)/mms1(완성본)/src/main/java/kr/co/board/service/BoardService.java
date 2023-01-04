package kr.co.board.service;

import java.util.List;
import java.util.Map;

import kr.co.board.domain.BoardDTO;
import kr.co.common.domain.PageTO;

public interface BoardService {

	void insert(BoardDTO dto);

	List<BoardDTO> list();

	PageTO<BoardDTO> list(Map<String, String> map);

	BoardDTO read(int bno);

	int update(Map<String, Object> map);

	Integer delete(Map<String, Object> map);

}
