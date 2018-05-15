package by.tc.web.controller;

import by.tc.web.service.exception.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public interface ControllerCommand {
    void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ServiceException;
}
