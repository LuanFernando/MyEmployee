package com.facear.myemployee.model;

public class Usuario {

	
	private int usuarioId = 0;
	private String usuarioName = null;
	private String usuarioPass = null;
	private String type = null;
	
	public Usuario(int id ,String user,String password,String type)
	{
		this.usuarioId = id;
		this.usuarioName = user;
		this.usuarioPass = password;
		this.type = type;
	}
	
	public int getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
	}
	public String getUsuarioName() {
		return usuarioName;
	}
	public void setUsuarioName(String usuarioName) {
		this.usuarioName = usuarioName;
	}
	public String getUsuarioPass() {
		return usuarioPass;
	}
	public void setUsuarioPass(String usuarioPass) {
		this.usuarioPass = usuarioPass;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	

}
