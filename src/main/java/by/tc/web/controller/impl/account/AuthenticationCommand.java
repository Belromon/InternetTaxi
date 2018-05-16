package by.tc.web.controller.impl.account;

import by.tc.web.controller.ControllerCommand;
import by.tc.web.entity.Administrator;
import by.tc.web.entity.Customer;
import by.tc.web.entity.Driver;
import by.tc.web.entity.User;
import by.tc.web.service.Autentificator;
import by.tc.web.service.HashGenerator;
import by.tc.web.service.exception.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static by.tc.web.controller.impl.constant.ControllerConstants.*;

public class AuthenticationCommand implements ControllerCommand {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String login = request.getParameter(LOGIN);
        String password = request.getParameter(PASSWORD);



//        if (!Validator.isLoginValid(login)) {
//            response.sendRedirect("/error");
//            return;
//        }
//
//        if (!Validator.isPasswordValid(password)) {
//            response.sendRedirect("/error");
//            return;
//        }


        try {
            String hashedPassword = HashGenerator.encryptPassword(password);
           User user = Autentificator.authenticate(login, hashedPassword);
            Class definableClass = user.getClass();
            String sessionIdentifier = "";

            if(definableClass == Customer.class){
                sessionIdentifier = CUSTOMER_ROLE;
            }
            if(definableClass == Driver.class){
                sessionIdentifier = DRIVER_ROLE;
            }
            if(definableClass == Administrator.class){
               sessionIdentifier = ADMIN_ROLE;



            }

        if (user != null) {
            String lang = (String) session.getAttribute(LOCALE);
            session.invalidate();
            session = request.getSession();
            session.setAttribute(ROLE,sessionIdentifier);
            session.setAttribute(USER_ROLE, user);
            session.setAttribute(LOCALE, lang);
            response.sendRedirect(ACCOUNT_PAGE);
        } else {

            displayError("Incorrect login/password combination", request, response);
        }
        } catch (ServiceException| NullPointerException e) {
            displayError("Incorrect login/password combination", request, response);
        }


    }
    private void displayError(String error, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute(ERROR, error);
        req.getRequestDispatcher(LOGIN_PAGE).forward(req, resp);
    }
}
