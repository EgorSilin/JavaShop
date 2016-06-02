package ru.javashop.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.ResourceBundle;
import java.util.ArrayList;

/**
 * Created by Admin on 30.05.2016.
 */

@FacesValidator("ru.javashop.validators.LoginValidator")
public class LoginValidator implements Validator {
    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {

        ResourceBundle resourceBundle = ResourceBundle.getBundle("ru.javashop.nls.messages", FacesContext.getCurrentInstance().getViewRoot().getLocale());


        try {
            String newValue = o.toString();
            if (newValue.length() < 5) {
                throw new IllegalArgumentException(resourceBundle.getString("login_length_error"));
            }
            if (!Character.isLetter(newValue.charAt(0))) {
                throw new IllegalArgumentException(resourceBundle.getString("first_letter_error"));
            }
            if (getTestArray().contains(newValue)) {
                throw new IllegalArgumentException(resourceBundle.getString("used_name"));
            }
        } catch (IllegalArgumentException e) {
            FacesMessage facesMessage = new FacesMessage(e.getMessage());
            facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(facesMessage);
        }

    }

    private ArrayList<String> getTestArray() {
        ArrayList<String> list = new ArrayList<String>();
        list.add("username");
        list.add("login");
        return list;
    }
}
