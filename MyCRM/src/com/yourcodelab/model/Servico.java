package com.yourcodelab.model;

public class Servico {
	private Integer id;
	private String categoria;
	private String status;
	
	public Servico(Integer id ,String categoria,String status){
		this.id = id;
		this.categoria = categoria;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
