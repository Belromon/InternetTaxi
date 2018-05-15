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

public class RegistrationCommand implements ControllerCommand {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServiceException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String hashedPassword = HashGenerator.encryptPassword(password);
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");

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

        request.getSession().setAttribute("user",user);
        response.sendRedirect("/index");

    }
}
