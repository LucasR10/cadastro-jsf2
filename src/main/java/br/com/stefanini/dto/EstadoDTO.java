package br.com.stefanini.dto;

import java.io.Serializable;

public class EstadoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String nome;
	private String sigla;

	public String getId() {
		return id;
	}

	public EstadoDTO() {
		
	}
	
	
	public EstadoDTO(String id, String nome, String sigla) {
		this.id = id;
		this.nome = nome;
		this.sigla = sigla;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	@Override
	public String toString() {
		return " id =" + id + ", nome=" + nome + ", sigla=" + sigla ;
	}
	
	
	

}
