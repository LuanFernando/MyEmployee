package com.facear.myemployee.model;

public class Holerite {
	
	private int codigo = 0;
	private Empregador  empregador;
	private Empregado empregado;
	private Beneficios  beneficios;
	private Contrato contrato;
	
	public Holerite(int codigo,Empregador empregador,Empregado empregado,Beneficios beneficios, Contrato contrato)
	{
		this.codigo = codigo;
		this.empregador =  empregador;
		this.empregado = empregado;
		this.beneficios = beneficios;
		this.contrato = contrato;
	}
	
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Empregador getEmpregador() {
		return empregador;
	}
	public void setEmpregador(Empregador empregador) {
		this.empregador = empregador;
	}
	public Empregado getEmpregado() {
		return empregado;
	}
	public void setEmpregado(Empregado empregado) {
		this.empregado = empregado;
	}
	public Beneficios getBeneficios() {
		return beneficios;
	}
	public void setBeneficios(Beneficios beneficios) {
		this.beneficios = beneficios;
	}
	public Contrato getContrato() {
		return contrato;
	}
	public void setContrato(Contrato contrato) {
		this.contrato = contrato;
	}
	
	
	
	
	
}
