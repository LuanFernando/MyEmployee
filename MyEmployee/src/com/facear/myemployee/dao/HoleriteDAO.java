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
	
	
	/*listar a tabela holerite de acordo com o empregador */
	private String INNERJOIN = ("SELECT * FROM TB_EMPREGADOR"
			+ "INNER JOIN  TB_CONTRATO ON (TB_CONTRATO.empregadorId == TB_EMPREGADOR.Id)"
			+ "WHERE empregador.nome =Josmar Bahia;");	
	
	
	public void insert(){
		
	}
	
	/*Method list*/
	public List<Holerite> listar() throws ClassNotFoundException,IOException,SQLException{

		List<Holerite> lista = new ArrayList<Holerite>();

 		openConnection();

		ps = connect.prepareStatement(INNERJOIN);

		ResultSet rs = ps.executeQuery();

		if(rs != null){
			while(rs.next()){
				
				
				Holerite ho = new Holerite();
				lista.add(ho);
			}
		}
		closeConnection();

		return lista;
	}
	
	

}
