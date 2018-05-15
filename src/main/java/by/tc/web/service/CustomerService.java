package by.tc.web.service;

import by.tc.web.dao.DAO;
import by.tc.web.dao.DAOFactory;
import by.tc.web.dao.exception.DAOException;
import by.tc.web.entity.Customer;
import by.tc.web.service.exception.ServiceException;

import java.util.List;

public class CustomerService implements UserService<Customer> {
    DAO<Customer> customerDAO = DAOFactory.getInstance().getCustomerDAO();

    public void save(Customer user) throws ServiceException {

        try {
            customerDAO.create(user);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    public void update(Customer user) throws ServiceException {
        try {
            customerDAO.update(user);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

    }

    public void delete(Customer user) throws ServiceException {
        try {
            customerDAO.delete(user);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }


    public List<Customer> getAllUsers() throws ServiceException {
        List<Customer> userList = null;
        try {
            userList = customerDAO.getAllUsers();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return userList;
    }

    public boolean block(int userId) throws ServiceException {
        Customer customer = null;

        try {
            customer = customerDAO.readByID(userId);
            customer.setBanned(true);
            customerDAO.update(customer);
            return true;
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

    }

    @Override
    public boolean unblock(int userId) throws ServiceException {
        Customer customer = null;

        try {
            customer = customerDAO.readByID(userId);
            customer.setBanned(false);
            customerDAO.update(customer);
            return true;
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Customer readByID(int id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean confirm(int id) {
        throw new UnsupportedOperationException();
    }


}
