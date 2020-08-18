package br.com.stefanini.validador;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import br.com.stefanini.util.AppUtil;

/**
 * @author Lucas Carvalho
 * @since 17/15/2020
 * */

@FacesValidator("cpfValidator")
public class CpfValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		
		   String cpf =  "" ; 
		
		   if( !value.toString().isEmpty() ) {
			   cpf = AppUtil.removerCaracterCPF( value.toString() );
		    }
			
			if( !AppUtil.isCPF( cpf ) ) {
			    FacesMessage msg = new FacesMessage("CPF não é válido.", "CPF não é válido");
				 msg.setSeverity(FacesMessage.SEVERITY_ERROR); 
				throw new ValidatorException(msg);
			}
		}
		
	}


