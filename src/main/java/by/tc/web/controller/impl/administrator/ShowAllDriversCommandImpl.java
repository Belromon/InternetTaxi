package by.tc.web.controller.impl.administrator;

import by.tc.web.controller.ControllerCommand;
import by.tc.web.controller.impl.constant.ControllerConstants;
import by.tc.web.entity.Driver;
import by.tc.web.service.ServiceFactory;
import by.tc.web.service.UserService;
import by.tc.web.service.exception.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ShowAllDriversCommandImpl implements ControllerCommand{
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {


        try {
            UserService<Driver> driverService = ServiceFactory.getInstance().getDriverService();
            List<Driver> driverList = driverService.getAllUsers();
            request.setAttribute(ControllerConstants.DRIVER_LIST_ATTR, driverList);
            request.getRequestDispatcher(ControllerConstants.DRIVERS_PAGE).forward(request,response);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
}
