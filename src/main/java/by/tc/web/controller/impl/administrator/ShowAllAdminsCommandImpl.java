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
import java.util.List;

public class ShowAllAdminsCommandImpl implements ControllerCommand {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            UserService<Administrator> administratorService = ServiceFactory.getInstance().getAdministratorService();
            List<Administrator> administratorList = null;
            administratorList = administratorService.getAllUsers();
            request.setAttribute(ControllerConstants.ADMIN_LIST_ATTR, administratorList);
            request.getRequestDispatcher(ControllerConstants.ADMINS_PAGE).forward(request,response);
        } catch (ServiceException| IOException e) {
            request.getRequestDispatcher("").forward(request,response);
        }

    }
}
