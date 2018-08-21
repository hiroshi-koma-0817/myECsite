package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;

public class ItemAddCompleteDAO {
	private DBConnector dbConnector=new DBConnector();

	private Connection connection=dbConnector.getConnection();



	private String sql="INSERT INTO item_info_transaction(item_name,item_price,item_stock)VALUES(?,?,?)";

	public void createAdd(String itemName,String itemPrice,String itemStock)throws SQLException{

		try{
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1,itemName);
			preparedStatement.setString(2,itemPrice);
			preparedStatement.setString(3,itemStock);


			preparedStatement.execute();

		}catch(Exception e){
			e.printStackTrace();
		}finally{
			connection.close();
		}
	}

}
