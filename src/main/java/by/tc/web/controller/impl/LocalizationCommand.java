package by.tc.web.controller.impl;

import by.tc.web.controller.ControllerCommand;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LocalizationCommand implements ControllerCommand {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession(true).setAttribute("locale", request.getParameter("locale"));
        request.getRequestDispatcher(request.getParameter("from")).forward(request, response);
    }
}
