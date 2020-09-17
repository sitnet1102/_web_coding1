package _05_bookstore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BuyDAO {

	private BuyDAO() {}
	private static BuyDAO instance = new BuyDAO();
	public static BuyDAO getInstance() { return instance; }
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	// DB����
	private Connection getConnection() throws Exception {
		String dbURL = "jdbc:mysql://localhost:3306/bookstoredb05?serverTimezone=UTC";
		String dbID = "root";
		String dbPassword = "root";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	// buy ���̺��� ��ü ���ڵ� ��
	public int getListCount() {
		
		int count = 0;
		
		try {
			conn = getConnection();
			
			String sql = "SELECT COUNT(*) FROM buy";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null) {try {rs.close();} catch (SQLException e) {}}
			if(pstmt != null) {try {pstmt.close();} catch (SQLException e) {}}
			if(conn != null) {try {conn.close();} catch (SQLException e) {}}
		}
		return count;
	}
	
	// bank ���̺� ���� ��������
	public List<String> getAccount(){

		List<String> accountList = null;
		
		try {
			
			conn = getConnection();
			
			String sql = "SELECT * FROM bank";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			accountList = new ArrayList<String>();
			
			while(rs.next()) {
				String account = rs.getString("account") + " " + rs.getString("bank") + " " + rs.getString("name");
				accountList.add(account);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null) {try {rs.close();} catch (SQLException e) {}}
			if(pstmt != null) {try {pstmt.close();} catch (SQLException e) {}}
			if(conn != null) {try {conn.close();} catch (SQLException e) {}}
		}
		return accountList;
	}
	
    //���� ���̺��� buy�� ���Ÿ�� ���
    public void insertBuy( List<CartDTO> lists, String id, String account, String deliveryName, String deliveryTel, String deliveryAddress){
       
        int buyId = 0; 
        int nowCount = 0;		
        
        try {

        	conn = getConnection();
            
            String sql = "SELECT MAX(buy_id) FROM buy";
            pstmt = conn.prepareStatement(sql);
            
            rs = pstmt.executeQuery();
            if(rs.next()) {
            	buyId = rs.getInt(1);
            }
            
            for(int i=0; i<lists.size();i++){
            	//�ش� ���̵� ���� cart���̺� ���ڵ���� �������� buy���̺� �߰�
            	CartDTO cart = lists.get(i);
            	
            	sql = "INSERT INTO buy (buy_id,buyer,book_id,book_title,buy_price,buy_count,";
                sql += "book_image,buy_date,account,deliveryName,deliveryTel,deliveryAddress,sanction)";
                sql += " values (?,?,?,?,?,?,?,now(),?,?,?,?,?)";
                pstmt = conn.prepareStatement(sql);
            
                pstmt.setLong(1, buyId + 1);
                pstmt.setString(2, id);
                pstmt.setInt(3, cart.getBook_id());
                pstmt.setString(4, cart.getBook_title());
                pstmt.setInt(5, cart.getBuy_price());
                pstmt.setInt(6, cart.getBuy_count());
                pstmt.setString(7, cart.getBook_image());
                pstmt.setString(8, account);
                pstmt.setString(9, deliveryName);
                pstmt.setString(10, deliveryTel);
                pstmt.setString(11, deliveryAddress);
                pstmt.setString(12, "����غ���");
                pstmt.executeUpdate();

                //��ǰ�� ���� �Ǿ����Ƿ� book���̺��� ��ǰ������ ��������
                sql = "SELECT book_count FROM book WHERE book_id=?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, cart.getBook_id());
                rs = pstmt.executeQuery();
                
                if(rs.next()) {
                	nowCount = rs.getInt(1) - cart.getBuy_count();
                }
                
                sql = "UPDATE book SET book_count=? WHERE book_id=?";
                pstmt = conn.prepareStatement(sql);
           
                pstmt.setInt(1, nowCount);
    			pstmt.setInt(2, cart.getBook_id());
                
                pstmt.executeUpdate(); 
            }
            
            // ��ٱ��� ����
            sql = "DELETE FROM cart WHERE buyer=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
          
            pstmt.executeUpdate();
            
        }catch(Exception e) {
        	e.printStackTrace();
        } finally {
            if (pstmt != null) {try { pstmt.close(); } catch(SQLException ex) {}}
            if (conn != null) {try { conn.close(); } catch(SQLException ex) {}}
        }
    }
    
    //id�� �ش��ϴ� buy���̺��� ���ڵ���� ���� �޼ҵ�
    public int getListCount(String id) {

        int count = 0;

        try {
            conn = getConnection();
            
            String sql = "SELECT COUNT(*) FROM buy WHERE buyer=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
               count = rs.getInt(1);
			}
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            if(rs != null) {try {rs.close();} catch (SQLException e) {}}
            if(pstmt != null) {try {pstmt.close();} catch (SQLException e) {}}
            if(conn != null) {try {conn.close();} catch (SQLException e) {}}
        }
		return count;
    }
    

    //id�� �ش��ϴ� buy���̺��� ���Ÿ�ϸ� ���� �޼ҵ�
    public List<BuyDTO> getBuyList(String id) {

    	BuyDTO buy = null;
        List<BuyDTO> lists = null;
        
        try {
       	    conn = getConnection();
       	 
       	    String sql = "SELECT * FROM buy WHERE buyer=?";
            pstmt = conn.prepareStatement(sql);
            
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            
            lists = new ArrayList<BuyDTO>();

            while (rs.next()) {
              buy = new BuyDTO();
           	 
           	  buy.setBuy_id(rs.getInt("buy_id"));
           	  buy.setBook_id(rs.getInt("book_id"));
           	  buy.setBook_title(rs.getString("book_title"));
           	  buy.setBuy_price(rs.getInt("buy_price"));
           	  buy.setBuy_count(rs.getByte("buy_count")); 
           	  buy.setBook_image(rs.getString("book_image"));
           	  buy.setSanction(rs.getString("sanction"));
           	 
           	  lists.add(buy);
			}
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            if(rs != null) {try {rs.close();} catch (SQLException e) {}}
            if(pstmt != null) {try {pstmt.close();} catch (SQLException e) {}}
            if(conn != null) {try {conn.close();} catch (SQLException e) {}}
        }
		return lists;
    }
    
    //buy���̺��� ��ü ����� ���� �޼ҵ�
    public List<BuyDTO> getBuyList()  {
        BuyDTO buy=null;
        List<BuyDTO> lists = null;	
        
        try {
       	 	conn = getConnection();
       	 
       	 	String sql = "SELECT * FROM buy";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            
            lists = new ArrayList<BuyDTO>();

            while (rs.next()) {
              buy = new BuyDTO();
           	 
           	  buy.setBuy_id(rs.getInt("buy_id"));
           	  buy.setBuyer(rs.getString("buyer"));
           	  buy.setBook_id(rs.getInt("book_id"));
           	  buy.setBook_title(rs.getString("book_title"));
           	  buy.setBuy_price(rs.getInt("buy_price"));
           	  buy.setBuy_count(rs.getByte("buy_count")); 
           	  buy.setBook_image(rs.getString("book_image"));
           	  buy.setBuy_date(rs.getString("buy_date"));
           	  buy.setAccount(rs.getString("account"));
           	  buy.setDeliveryName(rs.getString("deliveryName"));
           	  buy.setDeliveryTel(rs.getString("deliveryTel"));
           	  buy.setDeliveryAddress(rs.getString("deliveryAddress"));
           	  buy.setSanction(rs.getString("sanction"));
           	 
           	  lists.add(buy);
		    }
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            if(rs != null) {try {rs.close();} catch (SQLException e) {}}
            if(pstmt != null) {try {pstmt.close();} catch (SQLException e) {}}
            if(conn != null) {try {conn.close();} catch (SQLException e) {}}
        }
		return lists;
    }
}



































