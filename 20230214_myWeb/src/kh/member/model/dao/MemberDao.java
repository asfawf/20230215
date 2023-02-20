package kh.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kh.common.JdbcTemplate;
import kh.member.model.vo.MemberVo;

public class MemberDao {
	//내정보
	public MemberVo myInfo(Connection conn, String id) {
		MemberVo result = null;
		String sql="select ID, NAME, EMAIL from test_member where ID=?";
		
		PreparedStatement pstmt = null;
		ResultSet rest= null;
				
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rest=pstmt.executeQuery();
			result= new MemberVo();
			if(rest.next()) {
				result.setEmail(rest.getString("email"));
				result.setId(rest.getString("id"));
				result.setName(rest.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcTemplate.close(rest);
			JdbcTemplate.close(pstmt);
		}
		
		System.out.println(result);
		
		
		return result;
		
	}
	
	//login
	public MemberVo login(MemberVo vo , Connection conn) {
		MemberVo result = null;
		String sql="select ID, NAME, EMAIL from test_member where ID=? and PASSWD=?";
		PreparedStatement pstmt = null;
		ResultSet rest= null;
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPasswd());
			rest=pstmt.executeQuery();
			if(rest.next()) {
				result= new MemberVo();
				result.setEmail(rest.getString("email"));
				result.setId(rest.getString("id"));
				result.setName(rest.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcTemplate.close(rest);
			JdbcTemplate.close(pstmt);
		}
		
		System.out.println(result);
		
		return result;
	}
	
	// 회원가입 Insert 문은 무조건 int
	public int enroll( Connection conn , MemberVo vo) {
		int result= -1;
		String query= "insert into TEST_MEMBER values (?,?,?,?)";
		
		PreparedStatement pstmt = null;
		ResultSet rest= null;

		try {
			pstmt= conn.prepareStatement(query);
			
			//? 채우기
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPasswd());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getEmail());
			
			// pstmt 실행
			// 결과값 result에 대입
			result=pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			JdbcTemplate.close(pstmt);	
		}
		
		
		System.out.print("DAO return: "+ result);
		
				
		return result;
	}


}
