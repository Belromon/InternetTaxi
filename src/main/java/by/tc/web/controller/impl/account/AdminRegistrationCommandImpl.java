package by.tc.web.controller.impl.account;

import by.tc.web.controller.ControllerCommand;
import by.tc.web.entity.Administrator;
import by.tc.web.service.HashGenerator;
import by.tc.web.service.ServiceFactory;
import by.tc.web.service.UserService;
import by.tc.web.service.exception.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import static by.tc.web.controller.impl.constant.ControllerConstants.*;

public class AdminRegistrationCommandImpl implements ControllerCommand {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ServiceException {
        String login = request.getParameter(LOGIN);
        String password = request.getParameter(PASSWORD);
        String hashedPassword = HashGenerator.encryptPassword(password);
        String name = request.getParameter(USER_NAME);
        String surname = request.getParameter(USER_SURNAME);

        Administrator admin = new Administrator();
        admin.setLogin(login);
        admin.setPassword(hashedPassword);
        admin.setName(name);
        admin.setSurname(surname);
        admin.setRole(ADMIN_ROLE);

        try {
            UserService<Administrator> administratorService = ServiceFactory.getInstance().getAdministratorService();
            administratorService.save(admin);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        response.sendRedirect(ACCOUNT_PAGE);
    }
}
