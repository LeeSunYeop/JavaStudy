package kr.co.board.repository;

import java.util.List;
import java.util.Map;

import kr.co.board.domain.ReplyDTO;

public interface ReplyDAO {

	void insert(Map<String, Object> map);

	List<ReplyDTO> list(Integer bno);

}
