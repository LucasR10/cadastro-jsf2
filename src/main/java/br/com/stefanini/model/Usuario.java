package br.com.stefanini.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @author Lucas Carvalho
 * @since 17/15/2020
 * */

@NamedQueries({ 
	@NamedQuery(name = Usuario.LOGIN, query = "SELECT u FROM Usuario u WHERE u.login= ?1 AND u.senha = ?2"),
	@NamedQuery(name = Usuario.TODOS, query = "SELECT u FROM Usuario u ")
})
@Entity @Table(name = "TB_USUARIO")
public class Usuario implements Serializable {
	
	private static final long serialVersionUID = 1L;
    public static final String LOGIN ="buscar.login";
    public static final String TODOS ="buscar.todos";
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    
    @Column(name = "NOME", nullable = false)
    private String nome;
    
    @Column(name = "LOGIN", nullable = false, unique = true)
    private String login;
    
    @Column(name = "SENHA", nullable = false)
    private String senha;
   
    @Column(name = "ADMIN", nullable = false)
    private Boolean admin;
    
    public Usuario() {
    }

    public Usuario(String nome, String login, String senha, Boolean admin) {
		super();
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.admin = admin;
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

	public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", login=" + login + ", senha=" + senha + ", admin=" + admin
				+ "]";
	}
    
    
}
