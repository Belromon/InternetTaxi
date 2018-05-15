package by.tc.web.dao;

import by.tc.web.dao.exception.ConnectionPoolException;
import by.tc.web.dao.exception.DAOException;
import by.tc.web.dao.pool.ConnectionPool;
import by.tc.web.dao.pool.ConnectionPoolImpl;
import by.tc.web.dao.pool.MySQLConnection;
import by.tc.web.entity.Driver;
import by.tc.web.entity.Order;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDAO<T> implements DAO<T> {
    protected final Logger logger = Logger.getLogger(getClass());

    private final ConnectionPool connectionPool = ConnectionPoolImpl.getInstance();

    public abstract String getCreateQuery();

    public abstract String getUpdateQuery();

    public abstract String getDeleteQuery();

    public abstract String getQueryForAllUsers();

    public abstract String getQueryForAutentification();

    public abstract String getReadByIdQuery();

    public abstract String getQueryForFreeDrivers();

    public abstract String getReadNewOrdersForDriverQuery();

    public abstract String getReadOrderByCustomerIDQuery();

    public abstract void executeCreateQuery(PreparedStatement preparedStatement, T object) throws SQLException;

    public abstract void executeUpdateQuery(PreparedStatement preparedStatement, T object) throws SQLException;

    public abstract void executeDeleteQuery(PreparedStatement preparedStatement, T id) throws SQLException;

    public abstract T parseResultSet(ResultSet resultSet) throws SQLException;

    @Override
    public void create(T obj) throws DAOException {
        try (MySQLConnection connection = new MySQLConnection(connectionPool.getConnection());
             PreparedStatement pstmt = connection.getPreparedStatement(getCreateQuery())) {
            executeCreateQuery(pstmt, obj);
            pstmt.executeUpdate();

        } catch (ConnectionPoolException e) {
            logger.error("Cannot execute query -> ConnectionPool", e);
            throw new DAOException(e);
        } catch (SQLException e) {
            logger.error("Cannot create user -> Sql error", e);
            throw new DAOException(e);
        }
    }

    @Override
    public void update(T obj) throws DAOException {
        try (MySQLConnection connection = new MySQLConnection(connectionPool.getConnection());
             PreparedStatement pstmt = connection.getPreparedStatement(getUpdateQuery())) {
            executeUpdateQuery(pstmt, obj);

            pstmt.executeUpdate();

        } catch (ConnectionPoolException e) {
            logger.error("Cannot execute query -> ConnectionPool", e);
            throw new DAOException(e);
        } catch (SQLException e) {
            logger.error("Cannot update user -> Sql error", e);
            throw new DAOException(e);
        }
    }

    @Override
    public void delete(T obj) throws DAOException {
        try (MySQLConnection connection = new MySQLConnection(connectionPool.getConnection());
             PreparedStatement pstmt = connection.getPreparedStatement(getDeleteQuery())) {
            executeDeleteQuery(pstmt,obj);

            if (pstmt.executeUpdate() != 1) {
                throw new DAOException("Error in delete query");
            }

        } catch (ConnectionPoolException e) {
            logger.error("Cannot execute query -> ConnectionPool", e);
            throw new DAOException(e);
        } catch (SQLException e) {
            logger.error("Cannot delete user -> Sql error", e);
            throw new DAOException(e);
        }
    }

    @Override
    public List<T> getAllUsers() throws DAOException{
        List<T> userList = new ArrayList<>();
        try (MySQLConnection connection = new MySQLConnection(connectionPool.getConnection());
             PreparedStatement pstmt = connection.getPreparedStatement(getQueryForAllUsers())) {
           ResultSet resultSet =  pstmt.executeQuery();
            while(resultSet.next()){
                userList.add(parseResultSet(resultSet));
            }
            } catch (ConnectionPoolException e) {
            logger.error("Cannot execute query -> ConnectionPool", e);
            throw new DAOException(e);
        } catch (SQLException e) {
            logger.error("Cannot execute query -> SQL error", e);
            throw new DAOException(e);
        }
        return userList;
    }

    @Override
    public T readByLoginAndPassword(String login, String password) throws DAOException {
        try (MySQLConnection connection = new MySQLConnection(connectionPool.getConnection());
             PreparedStatement pstmt = connection.getPreparedStatement(getQueryForAutentification())) {
            pstmt.setString(1,login);
            pstmt.setString(2,password);
            ResultSet resultSet = pstmt.executeQuery();

            if (resultSet.last()) {
                if (resultSet.getRow() != 1) {
                    return null;
                } else {
                    resultSet.beforeFirst();
                }
            }

            if (!resultSet.next()) {
                return null;
            }

           return parseResultSet(resultSet);
        } catch (ConnectionPoolException e) {
            logger.error("Cannot execute query -> ConnectionPool", e);
            throw new DAOException(e);
        } catch (SQLException e) {
            logger.error("Cannot execute query -> Sql error", e);
            throw new DAOException(e);
        }
    }

    @Override
    public T readByID(int id) throws DAOException {
        try (MySQLConnection connection = new MySQLConnection(connectionPool.getConnection());
             PreparedStatement pstmt = connection.getPreparedStatement(getReadByIdQuery())) {
            pstmt.setInt(1,id);
            ResultSet resultSet =  pstmt.executeQuery();
            while(resultSet.next()){
                return parseResultSet(resultSet);
            }
        } catch (ConnectionPoolException e) {
            logger.error("Cannot execute query -> ConnectionPool", e);
            throw new DAOException(e);
        } catch (SQLException e) {
            logger.error("Cannot execute query -> Sql error", e);
            throw new DAOException(e);
        }
        return null;
    }

    public List<Driver> getAllFreeDrivers() throws DAOException {
        ConnectionPool connectionPool = ConnectionPoolImpl.getInstance();
        List<Driver> driverList = new ArrayList<>();
        try (MySQLConnection connection = new MySQLConnection(connectionPool.getConnection());
             PreparedStatement pstmt = connection.getPreparedStatement(getQueryForFreeDrivers())) {
            ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                driverList.add((Driver) parseResultSet(resultSet));
            }
        } catch (ConnectionPoolException e) {
            logger.error("Cannot create user -> ConnectionPool", e);
            throw new DAOException(e);
        } catch (SQLException e) {
            logger.error("Cannot execute query -> Sql error", e);
            throw new DAOException(e);
        }
        return driverList;
    }

    public List<Order> getOrdersForDriver(int idDriver) throws DAOException {
        ConnectionPool connectionPool = ConnectionPoolImpl.getInstance();
        List<Order> orderList = new ArrayList<>();
        try (MySQLConnection connection = new MySQLConnection(connectionPool.getConnection());
             PreparedStatement pstmt = connection.getPreparedStatement(getReadNewOrdersForDriverQuery())) {
            pstmt.setInt(1, idDriver);
            ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                orderList.add((Order) parseResultSet(resultSet));
            }
        } catch (ConnectionPoolException e) {
            logger.error("Cannot create user -> ConnectionPool", e);
            throw new DAOException(e);
        } catch (SQLException e) {
            logger.error("Cannot create user -> Sql error", e);
            throw new DAOException(e);
        }
        return orderList;
    }

    public Order getOrderByCustomerID(int idCustomer) throws DAOException {
        try (MySQLConnection connection = new MySQLConnection(connectionPool.getConnection());
             PreparedStatement pstmt = connection.getPreparedStatement(getReadOrderByCustomerIDQuery())) {
            pstmt.setInt(1,idCustomer);
            ResultSet resultSet =  pstmt.executeQuery();
            while(resultSet.next()){
                return (Order) parseResultSet(resultSet);
            }
        } catch (ConnectionPoolException e) {
            logger.error("Cannot execute query -> ConnectionPool", e);
            throw new DAOException(e);
        } catch (SQLException e) {
            logger.error("Cannot execute query -> Sql error", e);
            throw new DAOException(e);
        }
        return null;
    }


}
