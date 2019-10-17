package com.thzhima.blog.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.thzhima.bean.Goods;
import com.thzhima.blog.dao.JdbcTemplate;
import com.thzhima.blog.dao.ResultSetExtractor;

public class GoodsService {

	private JdbcTemplate temp;
	
	public GoodsService() {
		this.temp = new JdbcTemplate();
	}
	
	public void publish(String name, String desc, String unit, 
			                    float price, String location, String picture) throws SQLException {
		String sql = "insert into t_goods(id,goods_name,description,unit,price,location,picture)"
				+ "values(seq_goods.nextval, ?,?,?,?,?,?)";
		this.temp.update(sql, name, desc, unit, price, location, picture);
	}
	
	public List<Goods> list(int page, int size) throws SQLException{
		List<Goods> list = null;
		
		String sql = "select * from " + 
				"(select a.*, rownum ro from (select * from t_goods order by id desc) a where rownum<=? )" + 
				"where ro>?";
		
		ResultSetExtractor<List<Goods>> ext = new ResultSetExtractor<List<Goods>>() {
			
			@Override
			public List<Goods> extract(ResultSet rst) throws SQLException {
				List<Goods> list = new ArrayList<>();
				while(rst.next()) {
					Integer id = rst.getInt("id");
					String goodsName = rst.getString("goods_name");
					String unit = rst.getString("unit");
					float price = rst.getFloat("price");
					String description = rst.getString("description");
					String location = rst.getString("location");
					String picture = rst.getString("picture");
					int status = rst.getInt("status");
					
					Goods g = new Goods(id, goodsName, description, unit, price, location, picture, status==1?true:false);
					list.add(g);
				}
				return list;
			}
		};
		
		list = this.temp.select(sql, ext, page*size, (page-1)*size);
		
		return list;
	}
}
