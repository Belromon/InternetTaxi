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

import static by.tc.web.controller.impl.constant.ControllerConstants.TRUE_VALUE;

public class DriverBlockingCommand implements ControllerCommand{
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int idDriver = Integer.valueOf(request.getParameter(ControllerConstants.ID));
        try {
            UserService<Driver> driverService = ServiceFactory.getInstance().getDriverService();
            boolean confirm =  driverService.block(idDriver);
            if (confirm){
            }
            response.setContentType("text/plain");
            response.getWriter().write(TRUE_VALUE);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
}
