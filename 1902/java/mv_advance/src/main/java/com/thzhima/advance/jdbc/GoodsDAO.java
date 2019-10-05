package com.thzhima.advance.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbcp2.DelegatingCallableStatement;

import com.thzhima.advance.entity.Goods;

import oracle.jdbc.internal.OracleTypes;

public class GoodsDAO {

	public List<Goods> list(int page, int size) throws SQLException{
		List<Goods> list = new ArrayList<>();
		String sql = "{call p_list_goods(?,?,?)}";
		Connection conn = null;
		CallableStatement stm = null;
		ResultSet rst = null;
		try {
			conn = ConnectionUtil.getConnection();
			stm = conn.prepareCall(sql);
			stm.setInt(1, page);
			stm.setInt(2, size);
			stm.registerOutParameter(3, OracleTypes.CURSOR);
	
			stm.execute();
			
			rst = (ResultSet) stm.getObject(3);
			
			while(rst.next()) {
				int id = rst.getInt("id");
				String goodsName = rst.getString("goods_name");
				int kindID = rst.getInt("kind_id");
				String unit = rst.getString("unit");
				Goods g = new Goods(id, goodsName, kindID, unit);
				
				list.add(g);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(null != rst) {
				rst.close();
			}
			if(null != stm) {
				stm.close();
			}
			if(null != conn) {
				conn.close();
			}
		}
		
		return list;
	}
	
	public static void main(String[] args) throws SQLException {
		GoodsDAO dao = new GoodsDAO();
		System.out.println(dao.list(1, 10));
	}
}
