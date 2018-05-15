package by.tc.web.dao.impl;

import by.tc.web.dao.AbstractDAO;
import by.tc.web.entity.Driver;
import by.tc.web.entity.Point;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DriverDAOImpl extends AbstractDAO<Driver> {
    private static final String CREATE_QUERY = "INSERT INTO driver(name, surname, login, password, car_number, car_model, x_coord, y_coord) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String READ_BY_PHONE_AND_PASSWORD_QUERY = "SELECT * FROM driver WHERE login=? AND password=?";
    private final static String UPDATE_QUERY = "UPDATE driver SET name=? , surname=? , login=? , car_number=?, car_model=?, is_banned=?, is_free=?, is_confirmed=?, is_active=? WHERE id = ?";
    private static final String DELETE_QUERY = "UPDATE driver SET is_active='0' WHERE id=?";
    private static final String READ_ALL_DRIVERS = "SELECT * FROM driver";
    private static final String READ_DRIVER_BY_ID = "SELECT * FROM driver WHERE id=?";
    private static final String READ_ALL_FREE_DRIVERS = "SELECT * FROM driver WHERE (is_free='1' AND is_banned='0' and is_confirmed='1')";

    @Override
    public String getCreateQuery() {
        return CREATE_QUERY;
    }

    @Override
    public String getUpdateQuery() {
        return UPDATE_QUERY;
    }

    @Override
    public String getDeleteQuery() {
        return DELETE_QUERY;
    }

    @Override
    public String getQueryForAllUsers() {
        return READ_ALL_DRIVERS;
    }

    @Override
    public String getQueryForAutentification() {
        return READ_BY_PHONE_AND_PASSWORD_QUERY;
    }

    @Override
    public String getReadByIdQuery() {
        return READ_DRIVER_BY_ID;
    }

    public String getQueryForFreeDrivers() {
        return READ_ALL_FREE_DRIVERS;
    }

    @Override
    public String getReadNewOrdersForDriverQuery() {
        throw new UnsupportedOperationException("Using method for orders in customer dao class");
    }

    @Override
    public String getReadOrderByCustomerIDQuery() {
        throw new UnsupportedOperationException("Using method for orders in customer dao class");
    }

    @Override
    public void executeCreateQuery(PreparedStatement preparedStatement, Driver driver) throws SQLException {
        preparedStatement.setString(1, driver.getName());
        preparedStatement.setString(2, driver.getSurname());
        preparedStatement.setString(3, driver.getLogin());
        preparedStatement.setString(4, driver.getPassword());
        preparedStatement.setString(5, driver.getCarNumber());
        preparedStatement.setString(6, driver.getCarModel());
        preparedStatement.setDouble(7, driver.getLocation().getX());
        preparedStatement.setDouble(8, driver.getLocation().getY());

    }

    @Override
    public void executeUpdateQuery(PreparedStatement preparedStatement, Driver driver) throws SQLException {
        preparedStatement.setString(1, driver.getName());
        preparedStatement.setString(2, driver.getSurname());
        preparedStatement.setString(3, driver.getLogin());
        preparedStatement.setString(4, driver.getCarNumber());
        preparedStatement.setString(5, driver.getCarModel());
        preparedStatement.setBoolean(6, driver.isBanned());
        preparedStatement.setBoolean(7, driver.isFree());
        preparedStatement.setBoolean(8, driver.isConfirmed());
        preparedStatement.setBoolean(9, driver.isActive());
        preparedStatement.setInt(10, driver.getId());
    }

    @Override
    public void executeDeleteQuery(PreparedStatement preparedStatement, Driver driver) throws SQLException {
        preparedStatement.setInt(1, driver.getId());
    }

    @Override
    public Driver parseResultSet(ResultSet resultSet) throws SQLException {
        Driver driver = new Driver();
        driver.setId(resultSet.getInt(1));
        driver.setName(resultSet.getString(2));
        driver.setSurname(resultSet.getString(3));
        driver.setLogin(resultSet.getString(4));
        driver.setCarNumber(resultSet.getString(6));
        driver.setCarModel(resultSet.getString(7));
        driver.setBanned(resultSet.getBoolean(8));
        driver.setFree(resultSet.getBoolean(9));
        driver.setConfirmed(resultSet.getBoolean(10));
        double x = resultSet.getDouble(11);
        double y = resultSet.getDouble(12);
        Point point = new Point();
        point.setX(x);
        point.setX(y);
        driver.setLocation(point);
        driver.setActive(resultSet.getBoolean(13));
        return driver;

    }




}
