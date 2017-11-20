package com.facear.myemployee.dao;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.facear.myemployee.model.Holerite;

public class HoleriteDAO extends GenericDAO
                                    {
	private PreparedStatement ps;
	
	/*Inserir holerite no database*/
	private String INSERT_SQL = ("INSERT INTO holerite (EmpregadorId,EmpregadoId,SalarioBase,Desconto,Irrf,Inss,"
			                    + "Transporte,DataGerar,TotalLiquido,Status) "
			                    + "VALUES(?,?,?,?,?,?,?,?,?,?)");
	
	/*listar a tabela holerite de acordo com o empregador */
	private String INNERJOIN = ("SELECT * FROM TB_EMPREGADOR"
			                   + "INNER JOIN  TB_CONTRATO ON (TB_CONTRATO.empregadorId == TB_EMPREGADOR.Id)"
			                   + "WHERE empregador.nome =Josmar Bahia;");	
	
	
	


	public void insert(Holerite h)
	                            {
		try{
			openConnection();
			
			ps = connect.prepareStatement(INSERT_SQL);
			
			ps.setInt(1, h.getEmployee().getCodigo());
			ps.setInt(2, h.getEmployer().getCodigo());
			ps.setDouble(3,h.getContract_agreement().getSalario());
			ps.setDouble(4, h.getDesconto());
			ps.setDouble(5, h.getImpostos().getValor());//IRRF
			ps.setDouble(6, h.getImpostos().getValor());//INSS
			ps.setDouble(7, h.getImpostos().getValor());//TRANSPORTE
			ps.setString(8, h.getDatagerar());
			ps.setDouble(9, h.getTotalliquido());
			ps.setString(10, h.getStatus());
			
			
            ps.executeUpdate();
			
            closeConnection();
            
		} catch (ClassNotFoundException e) {
			System.out.println("Class not Found");
		} catch (IOException e) {
			System.out.println("File not Found");
		} catch (SQLException e) {
			System.out.println("Error on Connecting(SALVAR)");
		}
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
