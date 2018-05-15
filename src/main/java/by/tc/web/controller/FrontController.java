package by.tc.web.controller;

import by.tc.web.service.exception.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class FrontController extends HttpServlet {
    private static final String COMMAND = "command";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String command = request.getParameter(COMMAND);
        if (command != null) {
            try {
                CommandProvider.getCommand(command).execute(request, response);
            } catch (SQLException e) {
                response.sendRedirect("/error");
            } catch (ServiceException e) {
                response.sendRedirect("/error");
            }
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String command = request.getParameter(COMMAND);
        if (command != null) {
            try {
                CommandProvider.getCommand(command).execute(request, response);
            } catch (SQLException e) {
                response.sendRedirect("/error");
            } catch (ServiceException e) {
                response.sendRedirect("/error");
            }
        }


    }


}
