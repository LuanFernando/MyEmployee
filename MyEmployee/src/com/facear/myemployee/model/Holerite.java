package com.facear.myemployee.model;

import java.util.Date;

public class Holerite 
                  {
	          private int codigo = 0;
	          private Employer  employer;
	          private Employee employee;
	          private Contract_agreement contract_agreement;
	          private Benefits  benefits;
	          private Double desconto = 0.00;
	          private String datagerar;
	          private Double totalliquido = 0.00;
	          private String status;// TRUE FALSE
	          private Employee_taxes impostos = new Employee_taxes(codigo, null, codigo);
	          private Cargo cargo;
	          
	
	public Holerite()
	{
		//Construct default
	}
	
	public Holerite(int codigo, Employer employer, Employee employee, Contract_agreement contract_agreement,
			Benefits benefits, Employee_taxes impostos,Double desconto,String datagerar,Double totaliquido,String status ) {
		     super();
		     this.codigo = codigo;
		     this.employer = employer;
		     this.employee = employee;
		     this.contract_agreement = contract_agreement;
		     this.benefits = benefits;
		     this.impostos = impostos;
		     this.desconto = desconto;
		     this.datagerar = datagerar;
		     this.totalliquido = totaliquido;
		     this.status = status;
		     
	}

	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Employer getEmployer() {
		return employer;
	}
	public void setEmployer(Employer employer) {
		this.employer = employer;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Contract_agreement getContract_agreement() {
		return contract_agreement;
	}
	public void setContract_agreement(Contract_agreement contract_agreement) {
		this.contract_agreement = contract_agreement;
	}
	public Benefits getBenefits() {
		return benefits;
	}
	public void setBenefits(Benefits benefits) {
		this.benefits = benefits;
	}
	public Employee_taxes getImpostos() {
		return impostos;
	}
	public void setImpostos(Employee_taxes impostos) {
		this.impostos = impostos;
	}

	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

	public String getDatagerar() {
		return datagerar;
	}

	public void setDatagerar(String datagerar) {
		this.datagerar = datagerar;
	}

	public Double getTotalliquido() {
		return totalliquido;
	}

	public void setTotalliquido(Double totalliquido) {
		this.totalliquido = totalliquido;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}	
	
	
}
