package by.tc.web.service;

import by.tc.web.dao.DAO;
import by.tc.web.dao.DAOFactory;
import by.tc.web.dao.exception.DAOException;
import by.tc.web.entity.Administrator;
import by.tc.web.entity.Customer;
import by.tc.web.entity.Driver;
import by.tc.web.entity.User;
import by.tc.web.service.exception.ServiceException;

public class Autentificator {
    private static final DAO<Customer> customerDAO = DAOFactory.getInstance().getCustomerDAO();
    private static final DAO<Driver> driverDAO = DAOFactory.getInstance().getDriverDAO();
    private static final DAO<Administrator> administratorDAO = DAOFactory.getInstance().getAdministratorDAO();


    public static User authenticate(String login, String password) throws ServiceException {
        try {
            Customer customer = customerDAO.readByLoginAndPassword(login, password);
            if (customer != null) {
                return customer;
            }

            Driver driver = driverDAO.readByLoginAndPassword(login, password);
            if (driver != null) {
                return driver;
            }

            Administrator administrator = administratorDAO.readByLoginAndPassword(login, password);
            if (administrator != null) {
                return administrator;
            }
        } catch (DAOException e) {
            throw new ServiceException(e);
        }


        return null;
    }
}
