package br.com.stefanini.costante;

/**
 * @author Lucas Carvalho
 * @since 17/15/2020
 * */

public enum Genero {
	
	M("Masculino",'M'), F("Feminino",'F'), Outos("Outros",'O') ;

	private String texto;
	private char codigo;
	
	private Genero(String texto, char sexo) {
		this.texto = texto;
		this.codigo = sexo;
	}
	
	public char getCodigo() {
		return codigo;
	}
	
	public String getTexto() {
		return texto;
	}
}
