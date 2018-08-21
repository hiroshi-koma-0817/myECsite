package com.internousdev.ecsite.action;

import java.sql.SQLException;

import com.internousdev.ecsite.dao.KanriLoginDAO;
import com.internousdev.ecsite.dto.KanriLoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class KanriLoginAction extends ActionSupport{
	private String name;
	private String password;

	public String execute() throws SQLException {
		String ret=ERROR;
		KanriLoginDAO dao=new KanriLoginDAO();
		KanriLoginDTO dto=new KanriLoginDTO();

		dto=dao.select(name,password);
		if(name.equals(dto.getName())){
			if(password.equals(dto.getPassword())){
				ret=SUCCESS;
			}
		}
		return  ret;
		}


	public String getName() {
		return name;

		}
		public void setName(String name) {
		this.name = name;

		}
		public String getPassword() {

		return password;

		}
		public void setPassword(String password) {
		this.password = password;
		}

}
