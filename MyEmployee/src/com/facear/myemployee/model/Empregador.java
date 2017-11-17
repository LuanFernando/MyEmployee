package com.facear.myemployee.model;

public class Empregador {

	private int Id =0;
	private String razaoSocial = null;
	private String cpf = null;
	private String cnpj = null;
	
	public Empregador(int id, String razaoSocial, String cpf, String cnpj) {
		super();
		Id = id;
		this.razaoSocial = razaoSocial;
		this.cpf = cpf;
		this.cnpj = cnpj;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
}
