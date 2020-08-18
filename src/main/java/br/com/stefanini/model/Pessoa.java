package br.com.stefanini.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.br.CPF;

import br.com.stefanini.costante.Genero;

/**
 * @author Lucas Carvalho
 * @since 17/15/2020
 * */

@NamedQueries({ @NamedQuery(name = Pessoa.LISTAR_TODOS, query = "SELECT p FROM Pessoa p"), @NamedQuery(name = Pessoa.BUSCAR_POR_CPF, query = "SELECT p FROM Pessoa p WHERE p.cpf = ?1") })
@Entity
@Table(name = "TB_PESSOA")
public class Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final String LISTAR_TODOS = "pessoa.listarTodos";

	public static final String BUSCAR_POR_CPF = "buscarPorCpf";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false)
	private Long id;

	@Column(name = "NOME", nullable = false, length = 150)
	private String nome;

	@Column(name = "SEXO", length = 5)
	@Enumerated(EnumType.STRING)
	private Genero sexo;

	@Column(name = "EMAIL", length = 50)
	private String email;

	@Column(name = "DT_NASCIMENTO", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;

	@Column(name = "DT_CADASTRO", nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataCadastro;

	@Column(name = "DT_UTIMA_ATUALIZACAO", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataUtimaAtualizacao;

	@Column(name = "NATURALIDADE", length = 60)
	private String naturalidade;

	@Column(name = "NACIONALIDADE", length = 60)
	private String nacionalidade;

	@Column(name = "CPF", length = 12, nullable = false, unique = true)
	@CPF(message = "CPF invalido ")
	private String cpf;

	public Pessoa() {

	}

	public Pessoa(Long id, String nome, Genero sexo, String email, Date dataNascimento, Calendar dataCadastro,
			Calendar dataUtimaAtualizacao, String naturalidade, String nacionalidade, String cpf) {
		this.id = id;
		this.nome = nome;
		this.sexo = sexo;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.dataCadastro = dataCadastro;
		this.dataUtimaAtualizacao = dataUtimaAtualizacao;
		this.naturalidade = naturalidade;
		this.nacionalidade = nacionalidade;
		this.cpf = cpf;
	}
	
	public Pessoa(Long id) {
		this.id = id;
	}
	
	public Pessoa( String nome, Genero sexo, String email, Date dataNascimento, Calendar dataCadastro,
			Calendar dataUtimaAtualizacao, String naturalidade, String nacionalidade, String cpf) {
		this.nome = nome;
		this.sexo = sexo;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.dataCadastro = dataCadastro;
		this.dataUtimaAtualizacao = dataUtimaAtualizacao;
		this.naturalidade = naturalidade;
		this.nacionalidade = nacionalidade;
		this.cpf = cpf;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Genero getSexo() {
		return sexo;
	}

	public void setSexo(Genero sexo) {
		this.sexo = sexo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Calendar getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Calendar getDataUtimaAtualizacao() {
		return dataUtimaAtualizacao;
	}

	public void setDataUtimaAtualizacao(Calendar dataUtimaAtualizacao) {
		this.dataUtimaAtualizacao = dataUtimaAtualizacao;
	}

	public String getNaturalidade() {
		return naturalidade;
	}

	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Pessoa) {
			Pessoa p = (Pessoa) obj;
			return this.cpf.equals(p.cpf);
		}
		return false;

	}

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + ", sexo=" + sexo + ", email=" + email + ", dataNascimento="
				+ dataNascimento + ", dataCadastro=" + dataCadastro + ", dataUtimaAtualizacao=" + dataUtimaAtualizacao
				+ ", naturalidade=" + naturalidade + ", nacionalidade=" + nacionalidade + ", cpf=" + cpf + "]";
	}
	
	

}
