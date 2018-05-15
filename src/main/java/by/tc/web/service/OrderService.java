package by.tc.web.service;

import by.tc.web.dao.DAO;
import by.tc.web.dao.DAOFactory;
import by.tc.web.dao.exception.DAOException;
import by.tc.web.entity.Order;
import by.tc.web.service.exception.ServiceException;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class OrderService {
    private static final Logger logger = Logger.getLogger(OrderService.class);
    DAO<Order> orderDAO = DAOFactory.getInstance().getOrderDAO();

    public void create(Order order) throws ServiceException {
        try {
            orderDAO.create(order);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    public void update(Order order) throws ServiceException{
        try {
            orderDAO.update(order);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

    }

    public List<Order> getOrdersForDriver(int idDriver) throws ServiceException{
        List<Order> orderList = new ArrayList<>();

        try {
            orderList = orderDAO.getOrdersForDriver(idDriver);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

        return orderList;
    }

    public Order readByID(int idOrer) throws ServiceException {
        Order order = null;
        try {
            order = orderDAO.readByID(idOrer);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return order;

    }

    public List<Order> getAllOrders() throws ServiceException {
        List<Order> orderList = null;

        try {
            orderList = orderDAO.getAllUsers();
        } catch (DAOException e) {
            logger.error("Cannot perform query", e);
            throw new ServiceException(e);
        }

        return orderList;
    }

  public Order getOrderByCustomerID(int idCustomer) throws ServiceException {
        Order order = null;

      try {
         order =  orderDAO.getOrderByCustomerID(idCustomer);
      } catch (DAOException e) {
          logger.error("Cannot perform query", e);
          throw new ServiceException(e);
      }
      return order;
  }



}
