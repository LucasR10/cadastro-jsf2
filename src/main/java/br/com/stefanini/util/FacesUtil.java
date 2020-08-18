package br.com.stefanini.util;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Lucas Carvalho
 * @since 17/15/2020
 * */
public class FacesUtil {

	public static String getMensagemI18n(String chave) {
		FacesContext context = FacesContext.getCurrentInstance();
		String msg = context.getApplication().getResourceBundle(context, "msg").getString(chave);
		return msg;
	}

	public static void adicionarMensagem(Severity tipo, String msg) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(tipo, msg, msg));
	}

	public static Object getRequestAttribute(String name) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
		return request.getAttribute(name);
	}

	public static void adicionarMensagemError(String msg) {
		adicionarMensagem(FacesMessage.SEVERITY_ERROR, msg);
	}

	public static void adicionarMensagemInfo(String msg) {
		adicionarMensagem(FacesMessage.SEVERITY_INFO, msg);
	}

	public static void adicionarMensagemAlerta(String msg) {
		adicionarMensagem(FacesMessage.SEVERITY_WARN, msg);
	}
}
