package com.bg.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bg.model.Order;

public class OrderDao {
	private Connection con;
	private String query;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public OrderDao(Connection con)
	{
		this.con = con;
	}
	public boolean insertOrder(Order order)
	{
		boolean result = false;
		try {
			
			query = "insert into orders(product_id,user_id,quantity,order_date,order_total) "
					+ "values(?,?,?,?,?)";
			pst = this.con.prepareStatement(query);
			//pst.setInt(1,order.getOrderId());
			pst.setInt(1, order.getItemId());
			pst.setInt(2, order.getUid());
			pst.setInt(3, order.getQuantity());
			String str=order.getDate();
			Date date=Date.valueOf(str);//converting string into sql date.

			pst.setDate(4,date);
			pst.setInt(5,order.getOrderTotal());
			System.out.println("orderDao line 32: query");
			System.out.println(" query "+query);
			pst.executeQuery();
			result = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
		
	}
}
