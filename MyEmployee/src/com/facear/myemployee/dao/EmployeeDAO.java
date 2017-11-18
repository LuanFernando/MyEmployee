package com.facear.myemployee.dao;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.facear.myemployee.model.Contract_agreement;
import com.facear.myemployee.model.Employee;
import com.facear.myemployee.model.Employer;


public class EmployeeDAO extends GenericDAO{

	private PreparedStatement ps;
	private Employee employee;
	private Employer employer;
	
	private String SQL_INNERJOIN = ("SELECT contract_agreement.EmpregadoId,employee.Nome,contract_agreement.EmpregadorId,"
			                      + "contract_agreement.Codigo,cargo.Descricao,contract_agreement.Salario,contract_agreement.DataInicio,"
			                      + "contract_agreement.DataFinal,contract_agreement.CargaHoraria"
			                      + " FROM employer "
			                      + "INNER JOIN contract_agreement ON (employer.Codigo = contract_agreement.EmpregadorId) "
			                      + "INNER JOIN employee ON (employee.Codigo = contract_agreement.EmpregadoId) "
			                      + "INNER JOIN cargo ON (cargo.Codigo = contract_agreement.CargoId) "
			                      + "WHERE employer.Nome=?;"
			                      + "");
	
	/*Method list*/
	public List<Contract_agreement> listar() throws ClassNotFoundException,IOException,SQLException{

		List<Contract_agreement> lista = new ArrayList<Contract_agreement>();

 		openConnection();

		ps = connect.prepareStatement(SQL_INNERJOIN);
		ps.setString(1, "Maria Luiza Souza Marques");

		ResultSet rs = ps.executeQuery();

		if(rs != null){
			while(rs.next()){
				
				/*Empregado*/
				employee.setCodigo(rs.getInt("contract_agreement.EmpregadoId"));
				employee.setNomeCompleto(rs.getString("employee.Nome"));
				/*Empregador*/
				employer.setCodigo(rs.getInt("contract_agreement.EmpregadorId"));
				
				Contract_agreement ct = new Contract_agreement(
						rs.getInt("contract_agreement.Codigo"),
						employer,
						employee,
						rs.getString("cargo.Descricao"),
						rs.getDouble("contract_agreement.Salario"),
						rs.getString("contract_agreement.DataInicio"),
						rs.getString("contract_agreement.DataFinal"),
						rs.getInt("contract_agreement.CargaHoraria"));
				
				lista.add(ct);
			}
		}
		closeConnection();

		return lista;
	}
	
}
