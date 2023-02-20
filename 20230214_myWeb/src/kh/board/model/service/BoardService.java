package kh.board.model.service;

import java.sql.Connection;
import java.util.List;

import kh.board.model.dao.BoardDao;
import kh.board.model.vo.BoardVo;
import kh.common.JdbcTemplate;

public class BoardService {
	public List<BoardVo> getBoardList(){
		List<BoardVo> result = null;
		Connection conn = JdbcTemplate.getConnection();
		result = new BoardDao().getBoardList(conn);
		JdbcTemplate.close(conn);
		return result;
	}
	// getBoardList의 오버로딩
	public List<BoardVo> getBoardList(int srnum, int ernum){
		List<BoardVo> result = null;
		Connection conn = JdbcTemplate.getConnection();
		result = new BoardDao().getBoardList(conn, srnum, ernum);
		JdbcTemplate.close(conn);
		return result;
	}
	
	public int getCountBoard(){
		int result= 0;
		Connection conn = JdbcTemplate.getConnection();
		result= new BoardDao().getCountBoard(conn);
		System.out.println("글 개수 From BoardService: "+ result);
		JdbcTemplate.close(conn);
		return result;
	}
}