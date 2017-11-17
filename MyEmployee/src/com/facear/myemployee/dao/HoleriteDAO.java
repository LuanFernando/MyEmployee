package com.facear.myemployee.dao;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.facear.myemployee.model.Holerite;

public class HoleriteDAO extends GenericDAO{

	private PreparedStatement ps;	
	private String SQL_INSERT = ("");
	private String SQL_SELECT = ("");	
	
	
	public void insert(){
		
	}
	
	/*method list*/
	public List<Holerite> listar() throws ClassNotFoundException,IOException,SQLException{

		List<Holerite> lista = new ArrayList<Holerite>();

 		openConnection();

		ps = connect.prepareStatement("");

		ResultSet rs = ps.executeQuery();

		if(rs != null){
			while(rs.next()){
				Holerite ho = new Holerite(0,null, null, null, null);
				lista.add(ho);
			}
		}
		closeConnection();

		return lista;
	}
	
	

}
