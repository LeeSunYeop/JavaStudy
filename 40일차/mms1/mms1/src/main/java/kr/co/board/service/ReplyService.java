package kr.co.board.service;

import java.util.List;
import java.util.Map;

import kr.co.board.domain.ReplyDTO;

public interface ReplyService {

	void insert(Map<String, Object> map);

	List<ReplyDTO> list(Integer bno);

}
