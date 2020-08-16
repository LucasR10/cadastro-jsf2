package br.com.stefanini.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.com.stefanini.filter.LoginPhaseListener;
import br.com.stefanini.model.Usuario;
import br.com.stefanini.repository.UsuarioRepository;

@ManagedBean 
@SessionScoped
public class LoginBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Usuario usuarioLogado;
    private String login;
    private String senha;
   
    
    private UsuarioRepository usuarioRepository = new UsuarioRepository() ;

    public LoginBean() {
    }

    @PostConstruct
    public void init() {
        this.login = "";
        this.senha = "";
        usuarioRepository.salvar(new Usuario("Neymar JR", "neymarjr", "12345", Boolean.FALSE));
        usuarioRepository.salvar(new Usuario("Paula Silva", "admin", "12345", Boolean.TRUE) );
       
    }

    public String logIn() {
        usuarioLogado = usuarioRepository.buscar(login, senha);
        if (usuarioLogado == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário ou Senha Inválidos", "Login Inválido"));
            return null;
        } else {
            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            if (session != null) {
                session.setAttribute(LoginPhaseListener.USUARIO_LOGADO, usuarioLogado);
            }
            return "/index?faces-redirect=true";
        }
    }

    public String logOff() {
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
        session.invalidate();
        return "/login?faces-redirect=true";
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

	public void setSenha(String senha) {
		this.senha = senha;
	}
    
    public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}
    

}
