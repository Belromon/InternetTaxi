package by.tc.web.controller.impl;

import by.tc.web.controller.ControllerCommand;
import by.tc.web.controller.impl.constant.ControllerConstants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LocalizationCommand implements ControllerCommand {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession(true).setAttribute(ControllerConstants.LOCALE, request.getParameter(ControllerConstants.LOCALE));
        request.getRequestDispatcher(request.getParameter(ControllerConstants.FROM)).forward(request, response);
    }
}
