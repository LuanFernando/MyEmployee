package com.facear.myemployee.dao;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.facear.myemployee.model.*;

public class HoleriteDAO extends GenericDAO
                                    {
	private PreparedStatement ps = null;
	
	private Holerite ho ;
	private Employee employee = new Employee(0, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null);
	private Employer employer = new Employer(0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
	private Cargo cargo;
	private Contract_agreement contract = new Contract_agreement(0, null, null, null, null, null, null, 0);
	private Employee_taxes taxes;
	private Benefits benefits;
	
	
	/*Inserir holerite no database*/
	private String INSERT_SQL = ("INSERT INTO holerite (EmpregadorId,EmpregadoId,SalarioBase,Desconto,Irrf,Inss,"
			                    + "Transporte,DataGerar,TotalLiquido,Status) "
			                    + "VALUES(?,?,?,?,?,?,?,?,?,?)");
	
	/*listar a tabela holerite de acordo com o empregador */
	private String SELECT_HOLERITE = ("SELECT * FROM contract_agreement"
			                        + " INNER JOIN employee ON (contract_agreement.EmpregadoId = employee.Codigo)"
			                        + " INNER JOIN employer ON (contract_agreement.EmpregadorId = employer.Codigo)"
			                        + " INNER JOIN cargo ON (contract_agreement.CargoId = cargo.Codigo)"
			                        + " INNER JOIN holerite ON (contract_agreement.EmpregadoId = holerite.EmpregadoId)"
			                        + " WHERE employee.Nome=?");	
	

	public void insert(Contract_agreement h)
	                            {
		try{
			openConnection();
			
			ps = connect.prepareStatement(INSERT_SQL);
		
		    
			ps.setInt(1, h.getEmployer().getCodigo());
			ps.setInt(2, h.getEmployee().getCodigo());
			ps.setDouble(3,h.getSalario());
			ps.setDouble(4, h.getHolerite().getDesconto());
			ps.setDouble(5, h.getHolerite().getIrrf());//IRRF
			ps.setDouble(6, h.getHolerite().getInss());//INSS
			ps.setDouble(7, h.getHolerite().getTransporte());//TRANSPORTE
			ps.setString(8, h.getHolerite().getDatagerar());
			ps.setDouble(9, h.getHolerite().getTotalliquido());
			ps.setString(10, "Ativo");
			
			
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
	
	
	/*Method list holerite*/
	public List<Holerite> listar() throws ClassNotFoundException,IOException,SQLException{

		List<Holerite> lista = new ArrayList<Holerite>();
		

 		openConnection();

		ps = connect.prepareStatement(SELECT_HOLERITE);
		ps.setString(1, "Mariela Gomes Lian");

		ResultSet rs = ps.executeQuery();

		if(rs != null){
			while(rs.next()){
				
				ho = new Holerite();
				employee = new Employee();
				employer = new Employer();
				contract = new Contract_agreement(0, employer, employee, null, null, null, null, 0);
				cargo = new Cargo(0, null, null);
				
				employee.setCodigo(rs.getInt("employee.Codigo"));
				employee.setNomeCompleto(rs.getString("employee.Nome"));
				
				employer.setCodigo(rs.getInt("employer.Codigo"));
				employer.setNomeCompleto(rs.getString("employer.Nome"));
				
				contract.setCodigo(rs.getInt("contract_agreement.Codigo"));
				contract.setSalario(rs.getDouble("contract_agreement.Salario"));
				
				cargo.setCodigo(rs.getInt("cargo.Codigo"));
				cargo.setDescricao(rs.getString("cargo.Descricao"));
	
				
				/*Passando os valores para o objeto holerite*/
				ho.setCodigo(rs.getInt("holerite.Codigo"));
				
				ho.setEmployee(employee);
				ho.setCargo(cargo);
				ho.setEmployer(employer);
				ho.setContract_agreement(contract);
				ho.setImpostos(taxes);
				ho.setBenefits(benefits);
				
				ho.setDatagerar(rs.getString("holerite.DataGerar"));
                ho.setStatus(rs.getString("holerite.Status"));
                ho.setTotalliquido(rs.getDouble("holerite.TotalLiquido"));
                ho.setDesconto(rs.getDouble("holerite.Desconto"));
                
				lista.add(ho);
			}
		}
		closeConnection();

		return lista;
	}
}
