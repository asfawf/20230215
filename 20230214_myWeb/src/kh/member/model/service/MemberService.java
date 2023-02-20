package kh.member.model.service;

import java.sql.Connection;

import static kh.common.JdbcTemplate.*;
import kh.member.model.dao.MemberDao;
import kh.member.model.vo.MemberVo;
public class MemberService {
	
	public MemberVo myInfo(String id) {
		MemberVo result = null;
		Connection conn =getConnection();
		result = new MemberDao().myInfo(conn, id);
		
		close(conn);
		return result;
	}
	
	public MemberVo login(MemberVo vo ) {
		MemberVo result = null;
		Connection conn =getConnection();
		result = new MemberDao().login(vo, conn);
		
		close(conn);
		return result;
		
	}
	
	
	// 회원가입 Insert 문은 무조건 int
		public int enroll( MemberVo vo) {
			int result= -1;
			Connection conn =getConnection();
			
			result = new MemberDao().enroll(conn, vo);
			
			close(conn);
			
			return result;
		}
}
