package by.tc.web.controller.impl.account;

import by.tc.web.controller.ControllerCommand;
import by.tc.web.entity.Administrator;
import by.tc.web.entity.Customer;
import by.tc.web.entity.Driver;
import by.tc.web.entity.User;
import by.tc.web.service.ServiceFactory;
import by.tc.web.service.UserService;
import by.tc.web.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AccountEditCommandImpl implements ControllerCommand {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User) request.getSession().getAttribute("user");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        user.setName(name);
        user.setSurname(surname);


        Class userClass = user.getClass();
        UserService service;


        if (userClass == Customer.class) {
            service = ServiceFactory.getInstance().getCustomerService();
        } else if (userClass == Driver.class) {
            service = ServiceFactory.getInstance().getDriverService();
        } else if (userClass == Administrator.class) {
            service = ServiceFactory.getInstance().getAdministratorService();
        } else {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return;
        }


        try {
            service.update(user);
            response.sendRedirect("/account");
        } catch (ServiceException e) {
            e.printStackTrace();
        }


    }
}
