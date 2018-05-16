package by.tc.web.controller.impl.administrator;

import by.tc.web.controller.ControllerCommand;
import by.tc.web.controller.impl.constant.ControllerConstants;
import by.tc.web.entity.Administrator;
import by.tc.web.service.ServiceFactory;
import by.tc.web.service.UserService;
import by.tc.web.service.exception.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class AdminDeletingCommnad implements ControllerCommand {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ServiceException {
        int idAdmin = Integer.valueOf(request.getParameter(ControllerConstants.ID));
        try {
            UserService<Administrator> administratorService = ServiceFactory.getInstance().getAdministratorService();
            Administrator administrator = administratorService.readByID(idAdmin);

            administratorService.delete(administrator);


        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
}
