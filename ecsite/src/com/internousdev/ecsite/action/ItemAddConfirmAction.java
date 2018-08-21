package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemAddCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemAddConfirmAction extends ActionSupport implements SessionAware{

	private String itemName;
	private String itemPrice;
	private String itemStock;
	public Map<String,Object>session;
	private String errorMassage;

	public String execute() throws SQLException{

		String result=SUCCESS;

		if(!(itemName.equals(""))
				&&!(itemPrice.equals(""))
				&&!(itemStock.equals(""))){

			ItemAddCompleteDAO iac=new ItemAddCompleteDAO();


			iac.createAdd(itemName,itemPrice,itemStock);


		}else{
			setErrorMassage("未入力の項目があります。");
			result=ERROR;
		}
		return result;

	}

	public String getItemName(){
		return itemName;
	}

	public void setItemName(String itemName){
		this.itemName=itemName;
	}

	public String getItemPrice(){
		return itemPrice;
	}

	public void setItemPrice(String itemPrice){
		this.itemPrice=itemPrice;
	}

	public String getItemStock(){
		return itemStock;
	}

	public void setItemStock(String itemStock){
		this.itemStock=itemStock;
	}

	@Override
	public void setSession(Map<String,Object>session){
		this.session=session;
	}

	public String getErrorMassage(){
		return errorMassage;
	}

	public void setErrorMassage(String errorMassage){
		this.errorMassage=errorMassage;
	}

}
