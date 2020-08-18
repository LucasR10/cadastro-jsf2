package br.com.stefanini.phaseListener;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpSession;

import br.com.stefanini.model.Usuario;

/**
 * @author Lucas Carvalho
 * @since 17/15/2020
 * */
public class LoginPhaseListener implements PhaseListener {


	public static final String USUARIO_LOGADO = "usuario";

	private static final long serialVersionUID = 1L;

	private FacesContext facesContext;
   
	public LoginPhaseListener() {
    }
	
    @Override
    public void afterPhase(PhaseEvent event) {
        facesContext = event.getFacesContext();
        String viewId = facesContext.getViewRoot().getViewId();

        NavigationHandler nh = facesContext.getApplication().getNavigationHandler();
        boolean paginaLogin = viewId.lastIndexOf("login") > -1;

        if (existeUsuarioLogado() && paginaLogin) {
            nh.handleNavigation(facesContext, null, "/index?faces-redirect=true");
        } else if (!existeUsuarioLogado() && !paginaLogin) {
            nh.handleNavigation(facesContext, null, "/login?faces-redirect=true");
        }
    }

    public boolean existeUsuarioLogado() {
        return (((Usuario) getAtributoSessao(USUARIO_LOGADO)) != null);
    }

    public Object getAtributoSessao(String attributeName) {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        if (session != null) {
            return session.getAttribute(attributeName);
        }
        return null;
    }

    @Override
    public void beforePhase(PhaseEvent event) {
        
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }


}
