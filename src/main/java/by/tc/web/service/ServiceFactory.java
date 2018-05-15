package by.tc.web.service;

import by.tc.web.entity.Administrator;
import by.tc.web.entity.Customer;
import by.tc.web.entity.Driver;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();
    private UserService<Customer> customerService = new CustomerService();
    private UserService<Driver> driverService = new DriverService();
    private UserService<Administrator> administratorService = new AdministratorService();
    private OrderService orderService = new OrderService();
    private ServiceFactory(){}

    public static ServiceFactory getInstance() {
        return instance;
    }

    public UserService<Customer> getCustomerService() {
        return customerService;
    }

    public UserService<Driver> getDriverService() {
        return driverService;
    }

    public UserService<Administrator> getAdministratorService() {
        return administratorService;
    }

    public OrderService getOrderService() {
        return orderService;
    }
}
