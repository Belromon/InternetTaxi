package by.tc.web.service;

import by.tc.web.dao.DAO;
import by.tc.web.dao.DAOFactory;
import by.tc.web.dao.exception.DAOException;
import by.tc.web.entity.Driver;
import by.tc.web.service.exception.ServiceException;

import java.util.List;

public class DriverService implements UserService<Driver> {

    DAO<Driver> driverDAO = DAOFactory.getInstance().getDriverDAO();


    public void save(Driver driver) throws ServiceException {
        try {
            driverDAO.create(driver);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void delete(Driver driver) throws ServiceException {

        try {
            driverDAO.delete(driver);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }




    @Override
    public void update(Driver driver) throws ServiceException {
        try {
            driverDAO.update(driver);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    public List<Driver> getAllUsers() throws ServiceException {
        List<Driver> userList = null;
        try {
            userList =  driverDAO.getAllUsers();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return userList;
    }

    @Override
    public boolean block(int id) throws ServiceException {
        Driver driver = null;
        try {
            driver = (Driver) driverDAO.readByID(id);
            driver.setBanned(true);
            driverDAO.update(driver);
            return true;
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

    }

    @Override
    public boolean unblock(int id) throws ServiceException {
        Driver driver = null;
        try {
            driver = (Driver) driverDAO.readByID(id);
            driver.setBanned(false);
            driverDAO.update(driver);
            return true;
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Driver readByID(int id) throws ServiceException {
        Driver driver = null;

        try {
           driver = (Driver) driverDAO.readByID(id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return driver;
    }

    public boolean confirm(int id) throws ServiceException {
        Driver driver = null;
        try {
            driver = (Driver) driverDAO.readByID(id);
            driver.setConfirmed(true);
            driverDAO.update(driver);
            return true;
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

    }

    public List<Driver> getFreeDrivers() throws ServiceException {
        List<Driver> driverList = null;
        try {
           driverList = driverDAO.getAllFreeDrivers();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return driverList;
    }


}
