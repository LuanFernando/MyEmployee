package com.facear.myemployee.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MetodosAuxiliaresDAO {

	
	
	public String date()
	{
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); 
		Date date = new Date(); 
		return		 dateFormat.format(date);
	
	}
}
