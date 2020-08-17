package br.com.stefanini.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.com.stefanini.model.Usuario;
import br.com.stefanini.phaseListener.LoginPhaseListener;
import br.com.stefanini.repository.UsuarioRepository;

@ManagedBean 
@SessionScoped
public class LoginBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private static final String ADMIN = "admin";
	private static final String ADMIN_PASS = "122334444";
	
	private static final String NEYMARJR = "neymarjr";
	private static final String NY_PASS = "12345";
	
	private Usuario usuarioLogado;
    private String login;
    private String senha;
    List<Usuario> usuarios = new ArrayList<Usuario>() ;
    private Boolean criado =false;
    ;
    private UsuarioRepository usuarioRepository = new UsuarioRepository() ;

    public LoginBean() {
    }

    @PostConstruct
    public void init() {
        this.login = "";
        this.senha = "";
       
        if( !criado ) {
        	 usuarioRepository.salvar( usuariosMock().get(0) );
        	 usuarioRepository.salvar( usuariosMock().get(1) );
        	 criado = true;
        } 
        if( usuarioLogado != null ) {
            usuarios  = usuarioRepository.listar();
        }
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
    
	private List<Usuario> usuariosMock() {
		List<Usuario> us = new ArrayList<Usuario>();
	    us.add( new Usuario("Paula Silva", ADMIN, ADMIN_PASS, Boolean.TRUE));
	    us.add( new Usuario("Neymar JR", NEYMARJR, NY_PASS, Boolean.FALSE) );
	    return us;
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
    
   
    public List<Usuario> getUsuarios() {
		return usuarios;
	}

}
