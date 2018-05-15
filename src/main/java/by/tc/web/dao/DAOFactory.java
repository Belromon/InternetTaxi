package by.tc.web.dao;

import by.tc.web.dao.impl.AdministratorDAOImpl;
import by.tc.web.dao.impl.CustomerDAOImpl;
import by.tc.web.dao.impl.DriverDAOImpl;
import by.tc.web.dao.impl.OrderDAOImpl;
import by.tc.web.entity.Administrator;
import by.tc.web.entity.Customer;
import by.tc.web.entity.Driver;
import by.tc.web.entity.Order;

public class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();
    private DAO<Administrator> administratorDAO = new AdministratorDAOImpl();
    private DAO<Order> orderDAO = new OrderDAOImpl();
    private DAO<Driver> driverDAO = new DriverDAOImpl();
    private DAO<Customer> customerDAO = new CustomerDAOImpl();
    private DAOFactory(){};

    public static DAOFactory getInstance() {
        return instance;
    }

    public DAO<Administrator> getAdministratorDAO() {
        return administratorDAO;
    }

    public DAO<Order> getOrderDAO() {
        return orderDAO;
    }

    public DAO<Driver> getDriverDAO() {
        return driverDAO;
    }

    public DAO<Customer> getCustomerDAO() {
        return customerDAO;
    }
}
