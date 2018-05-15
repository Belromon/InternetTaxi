package by.tc.web.service;

import org.apache.log4j.Logger;

public class Validator {
    private static final Logger logger = Logger.getLogger(Validator.class);
    private static final String NAME_REGEX = "[A-Z][a-z]+";
    private static final String SURNAME_REGEX = "[A-Z][a-z]+";
    private static final String PASSWORD_REGEX = "^(?=^.{6,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$";

    public static boolean isNameValid(String name) {
        return name != null && name.matches(NAME_REGEX);
    }

    public static boolean isSurnameValid(String surname) {
        return surname != null && surname.matches(SURNAME_REGEX);
    }

    public static boolean isLoginValid(String login) {
        return login != null && login.matches(NAME_REGEX);
    }

    public static boolean isPasswordsValid(String firstPassword, String secondPassword) {
        return firstPassword != null && firstPassword.matches(PASSWORD_REGEX) && firstPassword.equals(secondPassword);
    }
    public static boolean isPasswordValid(String password) {
        return password != null && password.matches(PASSWORD_REGEX);
    }


}
