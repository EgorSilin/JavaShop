package ru.javashop.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.ResourceBundle;

/**
 * Created by Admin on 30.05.2016.
 */

@FacesValidator("ru.javashop.validators.LoginValidator")
public class LoginValidator implements Validator {
    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        if (o.toString().length() < 5) {
            ResourceBundle resourceBundle = ResourceBundle.getBundle("ru.javashop.nls.messages", FacesContext.getCurrentInstance().getViewRoot().getLocale());
            FacesMessage facesMessage = new FacesMessage(resourceBundle.getString("login_length_error"));
            facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(facesMessage);
        }
    }
}
