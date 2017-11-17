package com.facear.myemployee.model;

public class Contrato {

	private int codigo = 0;
	private Empregador empregador;
	private Empregado empregado;
	
	public Contrato(int codigo,Empregador empregador,Empregado empregado)
	{
		this.codigo = codigo;
		this.empregador = empregador;
		this.empregado = empregado;
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
	
	
}
