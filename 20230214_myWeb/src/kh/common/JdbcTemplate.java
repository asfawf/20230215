package kh.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTemplate {
	public static Connection getConnection() {
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "KH", "KH");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // oracle.jdbc 패키지 내부의 OracleDriver.class 파일
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(conn == null) {
				System.out.println(" conn(연결 통로) 에 의한 연결 실패 ");
			}else {
				System.out.println("연결성공");
			}
		
		
		return conn;
		}
	}
	
	public static void commit(Connection conn) {
		try {
			if(conn!= null && !conn.isClosed()) {
				conn.commit();
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void rollback(Connection conn) {
		try {
			if(conn!= null && !conn.isClosed()) {
				conn.commit();
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void close(Connection conn) {
		try {			
			if(conn!= null && !conn.isClosed()) {				
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void close(Statement pstmt) { // Statement 부모 PreparedStatement 자식이므로 둘 중에 하나만 작성해도 괜찮 
		try {			
			if(pstmt!= null && !pstmt.isClosed()) {				
				pstmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	} 
	
	public static void close(ResultSet result) {
		try {			
			if(result!= null && !result.isClosed()) {				
				result.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	} 
}
