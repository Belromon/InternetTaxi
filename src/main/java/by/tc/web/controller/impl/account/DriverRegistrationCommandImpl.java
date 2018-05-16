package by.tc.web.controller.impl.account;

import by.tc.web.controller.ControllerCommand;
import by.tc.web.entity.Driver;
import by.tc.web.entity.Point;
import by.tc.web.service.HashGenerator;
import by.tc.web.service.LocationHandler;
import by.tc.web.service.ServiceFactory;
import by.tc.web.service.UserService;
import by.tc.web.service.exception.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import static by.tc.web.controller.impl.constant.ControllerConstants.*;

public class DriverRegistrationCommandImpl implements ControllerCommand {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ServiceException {
        String login = request.getParameter(LOGIN);
        String password = request.getParameter(PASSWORD);
        String hashedPassword = HashGenerator.encryptPassword(password);
        String name = request.getParameter(USER_NAME);
        String surname = request.getParameter(USER_SURNAME);
        String car_model = request.getParameter(DRIVER_CAR_MODEL);
        String car_number = request.getParameter(DRIVER_CAR_NUMBER);
        double localtion_x = LocationHandler.getRandomCoordinate();
        double location_y = LocationHandler.getRandomCoordinate();
        Point point = new Point();
        point.setX(localtion_x);
        point.setY(location_y);


        Driver driver = new Driver();
        driver.setLogin(login);
        driver.setPassword(hashedPassword);
        driver.setName(name);
        driver.setSurname(surname);
        driver.setCarNumber(car_number);
        driver.setCarModel(car_model);
        driver.setLocation(point);
        driver.setFree(true);
        driver.setBanned(false);
        driver.setConfirmed(false);

        try {
            UserService<Driver> driverService = ServiceFactory.getInstance().getDriverService();
            driverService.save(driver);
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        request.getSession().setAttribute(DRIVER_ROLE,driver);
        response.sendRedirect(INDEX_PAGE);
    }
}
