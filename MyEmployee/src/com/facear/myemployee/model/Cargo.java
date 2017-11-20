package com.facear.myemployee.model;

public class Cargo 
               {

	         private int codigo = 0;
	         private String descricao = null;
	         private String status = null;
	
	public Cargo(int codigo, String descricao, String status) {
		     super();
		     this.codigo = codigo;
		     this.descricao = descricao;
		     this.status = status;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
