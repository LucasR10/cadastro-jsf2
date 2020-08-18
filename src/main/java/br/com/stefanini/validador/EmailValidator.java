package br.com.stefanini.validador;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 * @author Lucas Carvalho
 * @since 17/15/2020
 * */
@FacesValidator("emailValidator")
public class EmailValidator implements Validator {

		
	
		final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		
		private Pattern pattern;
		private Matcher matcher;

		public EmailValidator(){
			  pattern = Pattern.compile(EMAIL_PATTERN);
		}

		@Override
		public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {

	      String emial = value.toString();
	      
		  if( (null != emial && emial.length() > 0 /*digitou alguma coisa*/) ) {	
			matcher = pattern.matcher( value.toString());
			
			if(!matcher.matches()){
				
				FacesMessage msg = new FacesMessage("E-mail não é valido.", "E-mail não é valido.");
				msg.setSeverity(FacesMessage.SEVERITY_ERROR);
				throw new ValidatorException(msg);

			}

		}

  }
}
