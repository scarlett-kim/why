package kr.or.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import kr.or.bit.dto.Board;
import kr.or.bit.dto.Campingjang;
import kr.or.bit.dto.Zzim_List;
import kr.or.bit.utils.ConnectionHelper;

public class ZzimDao {
DataSource ds = null;
	
	public ZzimDao() throws NamingException {
		Context context = new InitialContext();
		ds = (DataSource)context.lookup("java:comp/env/jdbc/oracle");
	}
	
	public int zzimInsert(Campingjang campingjang, Zzim_List zzim_list) {   //찜 리스트 추가
		PreparedStatement pstmt =null;
		Connection conn = null;
		//String sql = "insert all into campingjang(contentid, title, addr1, tel, firstimage) values(?,?,?,?,?) into zzim_List (contentid, id) values(?,?) select * from dual";	
		String sql = "insert all when contentid !=" + campingjang.getContentid() + " then"
				+ "into campingjang(contentid, title, addr1, tel, firstimage) values(?,?,?,?,?)"
				+ "into zzim_list(contentid, id) values(?,?)"
				+ "else "
				+ "into zzim_list(contentid, id) values(?,?)"
				+ "select contentid from campingjang";
		int resultrow = 0;		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, campingjang.getContentid());
			pstmt.setString(2, campingjang.getTitle());
			pstmt.setString(3, campingjang.getAddr1());
			pstmt.setInt(4, campingjang.getTel());
			pstmt.setString(5, campingjang.getFirstimage());
			pstmt.setInt(6, zzim_list.getContentid());
			pstmt.setString(7, zzim_list.getId());
			pstmt.setInt(8, zzim_list.getContentid());
			pstmt.setString(9, zzim_list.getId());
			
			resultrow = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();//반환
			}catch (Exception e) {
			}
		}
		return resultrow;
	}
	

	public ArrayList<Zzim_List> zzimSearch(int contentId) {
		
		  Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
		  ArrayList<Zzim_List> zzimlist = new ArrayList<>();

		  
        try {
	        conn = ConnectionHelper.getConnection("oracle");
          String sql="select camidx, id from zzim_list where camidx=?";  //이건 바꾸기 
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, contentId);
			rs = pstmt.executeQuery();
			
			
			while(rs.next()) {
				Zzim_List zzim = new Zzim_List();
				zzim.setContentid(rs.getInt("camidx"));
				zzim.setId(rs.getString("id"));
				System.out.println("번호 : "+rs.getInt("camidx"));
				System.out.println("아이디 : "+rs.getString("id"));
				
				zzimlist.add(zzim);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
        
		return zzimlist;
		
	}
	
	
	
	
}
