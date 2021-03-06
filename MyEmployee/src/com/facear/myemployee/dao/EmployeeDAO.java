package com.facear.myemployee.dao;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.facear.myemployee.model.Contract_agreement;
import com.facear.myemployee.model.Employee;
import com.facear.myemployee.model.Employer;
import com.facear.myemployee.model.Holerite;


public class EmployeeDAO extends GenericDAO{

	private PreparedStatement ps;
	private Employee employee = new Employee(0, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null);
	private Employer employer = new Employer(0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
	private Holerite holerite;
	private String SQL_INNERJOIN = ("SELECT contract_agreement.EmpregadoId,employee.Nome,contract_agreement.EmpregadorId,"
			                      + "contract_agreement.Codigo,cargo.Descricao,contract_agreement.Salario,contract_agreement.DataInicio,"
			                      + "contract_agreement.DataFinal,contract_agreement.CargaHoraria,employer.Nome"
			                      + " FROM employer "
			                      + "INNER JOIN contract_agreement ON (employer.Codigo = contract_agreement.EmpregadorId) "
			                      + "INNER JOIN employee ON (employee.Codigo = contract_agreement.EmpregadoId) "
			                      + "INNER JOIN cargo ON (cargo.Codigo = contract_agreement.CargoId) "
			                      + "WHERE employer.Nome=?;"
			                      + "");

	
	/*Method list*/
	public List<Contract_agreement> listar(){

		List<Contract_agreement> lista = new ArrayList<Contract_agreement>();
		
		Holerite holerite = new Holerite();
		ImpostosDAO impostos = new ImpostosDAO();
		BeneficiosDAO beneficios = new BeneficiosDAO();
		Contract_agreement ct = null;
		MetodosAuxiliaresDAO aux = new MetodosAuxiliaresDAO();
		
 		try {
			openConnection();
			
			ps = connect.prepareStatement(SQL_INNERJOIN);
			ps.setString(1, "Maria Luiza Souza Marques");

			ResultSet rs = ps.executeQuery();

			if(rs != null){
				while(rs.next()){
					/*new object para nao dar bug de sobrecrever os dados anteriores*/
					employee = new Employee();
					holerite = new Holerite();
					
					/*Empregado*/
					employee.setCodigo(rs.getInt("contract_agreement.EmpregadoId"));
					employee.setNomeCompleto(rs.getString("employee.Nome"));
					/*Empregador*/
					employer.setCodigo(rs.getInt("contract_agreement.EmpregadorId"));
					employer.setNomeCompleto(rs.getString("employer.Nome"));
					
					ct = new Contract_agreement(
							rs.getInt("contract_agreement.Codigo"),
							employer,
							employee,
							rs.getString("cargo.Descricao"),
							rs.getDouble("contract_agreement.Salario"),
							rs.getString("contract_agreement.DataInicio"),
							rs.getString("contract_agreement.DataFinal"),
							rs.getInt("contract_agreement.CargaHoraria")							);
					
					holerite.setInss(impostos.Calculoinss(rs.getDouble("contract_agreement.Salario")));
					holerite.setTransporte(beneficios.transporte(rs.getDouble("contract_agreement.Salario")-holerite.getInss()));
					
					holerite.setDatagerar(aux.date());
					/*soma dos descontos*/
					holerite.setDesconto(holerite.getInss()+holerite.getTransporte()+holerite.getIrrf());
					/*total liquido*/
					holerite.setTotalliquido(rs.getDouble("contract_agreement.Salario")-holerite.getDesconto());
					
					ct.setHolerite(holerite);
					
					lista.add(ct);
				}
			}
			
		
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println(e);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		closeConnection();

		return lista;
	}
	
}
