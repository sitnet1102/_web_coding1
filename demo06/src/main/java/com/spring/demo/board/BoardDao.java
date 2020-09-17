package com.spring.demo.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;

public class BoardDao {
	@Autowired
	BasicDataSource dataSource;
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	
//	  private static final String DRIVER = "com.mysql.jdbc.Driver"; 
//	  private static final String URL = "jdbc:mysql://127.0.0.1:3306/springDB"; 
//	  private static final String USER ="root"; 
//	  private static final String PW = "root"; 
	 
	 

	public void insertBoard(Board board) {

		int ref = 0;
		int num = 0;
		try {
			conn = dataSource.getConnection();
			String refSql = "SELECT MAX(ref) FROM board";
			pstmt = conn.prepareStatement(refSql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				ref = rs.getInt(1) + 1;
			}
			String numSql = "SELECT MAX(num) FROM board";
			pstmt = conn.prepareStatement(numSql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				num = rs.getInt(1) + 1;
			}

			String sql = "INSERT INTO board (num , writer, email, subject, "
					+ "password, reg_date, ref, re_step, re_level, "
					+ "readcount, content) VALUES(?, ?, ?, ?, ?, now(),?, 1, 1, 0, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, board.getWriter());
			pstmt.setString(3, board.getEmail());
			pstmt.setString(4, board.getSubject());
			pstmt.setString(5, board.getPassword());
			pstmt.setInt(6, ref);
			pstmt.setString(7, board.getContent());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	public int getAllCount() {
		int count = 0;
		try {
			conn = dataSource.getConnection();
			String sql = "SELECT COUNT(*) FROM board";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1); 
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			}
		}
		return count;
	}

	public Vector<Board> getAllBoard(int start, int count) {

		
		Vector<Board> vec = new Vector<Board>();

		try {
			conn = dataSource.getConnection();
			
			String sql = "SELECT * FROM board ORDER BY ref DESC , re_level LIMIT ?, ?;";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, count);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				Board bean = new Board();
				bean.setNum(rs.getInt(1));
				bean.setWriter(rs.getString(2));
				bean.setEmail(rs.getString(3));
				bean.setSubject(rs.getString(4));
				bean.setPassword(rs.getString(5));
				bean.setReg_date(rs.getDate(6).toString());
				bean.setRef(rs.getInt(7));
				bean.setRe_step(rs.getInt(8));
				bean.setRe_level(rs.getInt(9));
				bean.setReadcount(rs.getInt(10));
				bean.setContent(rs.getString(11));
				vec.add(bean);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
				}
			}
		}
		return vec;
	}
	
	public Board getOneBoard(int num) {

		
		Board bean = new Board();

		try {
			conn =  dataSource.getConnection();	
			String readsql = "UPDATE board SET readcount=readcount+1 WHERE NUM=?";
			pstmt = conn.prepareStatement(readsql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();

			
			String sql = "SELECT * FROM board WHERE NUM=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				bean.setNum(rs.getInt(1));
				bean.setWriter(rs.getString(2));
				bean.setEmail(rs.getString(3));
				bean.setSubject(rs.getString(4));
				bean.setPassword(rs.getString(5));
				bean.setReg_date(rs.getDate(6).toString());
				bean.setRef(rs.getInt(7));
				bean.setRe_step(rs.getInt(8));
				bean.setRe_level(rs.getInt(9));
				bean.setReadcount(rs.getInt(10));
				bean.setContent(rs.getString(11));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
				}
			}
		}
		return bean;
	}

	
public void reWriteBoard(Board bean) {
		
		int ref = bean.getRef();
		int re_step = bean.getRe_step();
		int re_level = bean.getRe_level();
		
		int num = 0;
		
		try {
			conn = dataSource.getConnection();	
			
			String numSql = "SELECT MAX(num) FROM board";
			pstmt = conn.prepareStatement(numSql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				num = rs.getInt(1) + 1;
			}

					
			
			String levelsql = "UPDATE board SET re_level=re_level+1 WHERE ref=? and re_level > ?";
			
			pstmt = conn.prepareStatement(levelsql);
			pstmt.setInt(1, ref);
			pstmt.setInt(2, re_level);
			
			pstmt.executeUpdate();		
			
			String sql = "INSERT INTO board (num , writer, email, subject, password, "
					+ "reg_date, ref, re_step, re_level, readcount, content) "
					+ "VALUES (?,?,?,?,?,now(),?,?,?,0,?)";
			pstmt = conn.prepareStatement(sql);
			// ? �� ���� ����
			pstmt.setInt(1, num);
			pstmt.setString(2, bean.getWriter());
			pstmt.setString(3, bean.getEmail());
			pstmt.setString(4, bean.getSubject());
			pstmt.setString(5, bean.getPassword());
			pstmt.setInt(6, ref);				
			pstmt.setInt(7, re_step + 1);		
			pstmt.setInt(8, re_level + 1);
			pstmt.setString(9, bean.getContent());			
			pstmt.executeUpdate();			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt != null) { try { pstmt.close(); } catch (SQLException e) {}}
			if(rs != null) { try { rs.close(); } catch (SQLException e) {}}
			if(conn != null) { try { conn.close(); } catch (SQLException e) {}}
		}
	}
	
}
