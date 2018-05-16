package by.tc.web.controller.impl.account;

import by.tc.web.controller.ControllerCommand;
import by.tc.web.entity.Customer;
import by.tc.web.service.HashGenerator;
import by.tc.web.service.ServiceFactory;
import by.tc.web.service.UserService;
import by.tc.web.service.exception.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.tc.web.controller.impl.constant.ControllerConstants.*;


public class RegistrationCommand implements ControllerCommand {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServiceException {
        String login = request.getParameter(LOGIN);
        String password = request.getParameter(PASSWORD);
        String hashedPassword = HashGenerator.encryptPassword(password);
        String name = request.getParameter(USER_NAME);
        String surname = request.getParameter(USER_SURNAME);

        Customer user = new Customer();
        user.setLogin(login);
        user.setPassword(hashedPassword);
        user.setName(name);
        user.setSurname(surname);

        try {
            UserService<Customer> customerService = ServiceFactory.getInstance().getCustomerService();
            customerService.save(user);
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        request.getSession().setAttribute(USER_ROLE,user);
        response.sendRedirect(INDEX_PAGE);

    }
}
