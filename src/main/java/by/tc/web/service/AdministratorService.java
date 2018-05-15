package by.tc.web.service;

import by.tc.web.dao.DAO;
import by.tc.web.dao.DAOFactory;
import by.tc.web.dao.exception.DAOException;
import by.tc.web.entity.Administrator;
import by.tc.web.service.exception.ServiceException;
import org.apache.log4j.Logger;

import java.util.List;

public class AdministratorService implements UserService<Administrator> {
    private static final Logger logger = Logger.getLogger(OrderService.class);
    DAO<Administrator> administratorDAO = DAOFactory.getInstance().getAdministratorDAO();
    @Override
    public void delete(Administrator administrator) throws ServiceException {
        try {
            administratorDAO.delete(administrator);
        } catch (DAOException e) {
            logger.error("Error in delete method in Admin service class ", e);
            throw new ServiceException(e);
        }
    }

    @Override
    public void save(Administrator administrator) throws ServiceException {
        try {
            administratorDAO.create(administrator);
        } catch (DAOException e) {
            logger.error("Cannot perform query", e);
            throw new ServiceException(e);
        }
    }

    @Override
    public void update(Administrator object) throws ServiceException {

    }

    @Override
    public List<Administrator> getAllUsers() throws ServiceException {
        List<Administrator> administratorList = null;
        try {
            administratorList = administratorDAO.getAllUsers();
        } catch (DAOException e) {
            logger.error("Cannot perform query", e);
            throw new ServiceException(e);
        }

        return administratorList;
    }

    @Override
    public boolean block(int userId) throws ServiceException {
        throw new UnsupportedOperationException("Using method from driver in admin service class");
    }

    @Override
    public boolean unblock(int userId) throws ServiceException {
        throw new UnsupportedOperationException("Using method from driver in admin service class");
    }

    @Override
    public Administrator readByID(int id) throws ServiceException {
        Administrator administrator = null;
        try {
            administrator = administratorDAO.readByID(id);
            } catch (DAOException e) {
            logger.error("Error in readByID method in Admin Service class ", e);
            throw new ServiceException(e);
        }
        return administrator;
    }

    @Override
    public boolean confirm(int id) throws ServiceException {
        throw new UnsupportedOperationException("Using method from driver in admin service class");
    }


}
