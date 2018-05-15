package by.tc.web.dao;

import by.tc.web.dao.exception.DAOException;
import by.tc.web.entity.Driver;
import by.tc.web.entity.Order;

import java.util.List;

public interface DAO<T> {
    /**
     * This method save an object of type T to the database
     *
     * @param obj an object for saving
     * @throws DAOException if cannot save object to the database
     */
    void create(T obj) throws DAOException;

    /**
     * This method update appropriate database table
     *
     * @param obj an object for updating
     * @throws DAOException if cannot save object to the database
     */
    void update(T obj) throws DAOException;

    /**
     * This method deletes objecct from appropriate database table
     *
     * @param obj an object for updating
     * @throws DAOException if cannot save object to the database
     */
    void delete(T obj) throws DAOException;

    /**
     * This method gets user by login and password from database
     *
     * @param login    a login
     * @param password a password
     * @return a user or null if incorrect data was provided
     * @throws DAOException if cannot save object to the database
     */
    T readByLoginAndPassword(String login, String password) throws DAOException;

    /**
     * This method get an object of type T from database
     *
     * @param id an object identifier
     * @return an received object
     * @throws DAOException if cannot get object from the database
     */
    T readByID(int id) throws DAOException;

    /**
     * This method get a  of List objects of type T from database
     *
     * @return a List of objects
     * @throws DAOException if cannot get object from the database
     */
    List<T> getAllUsers() throws DAOException;

    /**
     * This method get a of List objects of type Driver with status Free from database
     *
     * @return a received List of objects
     * @throws DAOException if cannot get object from the database
     */
    List<Driver> getAllFreeDrivers() throws DAOException;


    /**
     * This method get a of List objects of type Order from database
     *
     * @param idDriver an object identifier
     * @return a received List of object
     * @throws DAOException if cannot get object from the database
     */
    List<Order> getOrdersForDriver(int idDriver) throws DAOException;

    /**
     * This method get an objects of type Order from database by Customer id
     *
     * @param idCustomer an object identifier
     * @return a received object
     * @throws DAOException if cannot get object from the database
     */
    Order getOrderByCustomerID(int idCustomer) throws DAOException;

}
