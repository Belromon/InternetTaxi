package by.tc.web.dao.impl;

import by.tc.web.dao.AbstractDAO;
import by.tc.web.entity.Customer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDAOImpl extends AbstractDAO<Customer> {
    private static final String CREATE_QUERY = "INSERT INTO user(name, surname, login, password) VALUES (?, ?, ?, ?)";
    private static final String READ_BY_PHONE_AND_PASSWORD_QUERY = "SELECT * FROM user WHERE login=? AND password=? AND role='user' AND is_active='1'";
    private final static String UPDATE_QUERY = "UPDATE user SET name=? , surname=?, is_banned=? WHERE id = ?";
    private static final String DELETE_QUERY = "UPDATE user SET is_active='0' WHERE id=?";
    private static final String READ_ALL_USERS = "SELECT * FROM user";
    private static final String READ_USER_BY_ID = "SELECT * FROM user WHERE id=? AND role = 'user'";

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
        return READ_ALL_USERS;
    }

    @Override
    public String getQueryForAutentification() {
        return READ_BY_PHONE_AND_PASSWORD_QUERY;
    }

    @Override
    public String getReadByIdQuery() {
        return READ_USER_BY_ID;
    }

    @Override
    public String getQueryForFreeDrivers() {
        throw new UnsupportedOperationException("Using method for driver in customer dao class");
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
    public void executeCreateQuery(PreparedStatement preparedStatement, Customer user) throws SQLException {
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getSurname());
        preparedStatement.setString(3, user.getLogin());
        preparedStatement.setString(4, user.getPassword());
    }

    @Override
    public void executeUpdateQuery(PreparedStatement preparedStatement, Customer user) throws SQLException {
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getSurname());
        preparedStatement.setBoolean(3,user.isBanned());
        preparedStatement.setInt(4,user.getId());
    }

    @Override
    public void executeDeleteQuery(PreparedStatement preparedStatement, Customer user) throws SQLException {
        preparedStatement.setInt(1, user.getId());
    }



    @Override
    public Customer parseResultSet(ResultSet resultSet) throws SQLException {
        Customer customer = new Customer();
        customer.setId(resultSet.getInt(1));
        customer.setName(resultSet.getString(2));
        customer.setSurname(resultSet.getString(3));
        customer.setLogin(resultSet.getString(4));
        customer.setDiscount(resultSet.getInt(6));
        customer.setBanned(resultSet.getBoolean(7));
        customer.setRole(resultSet.getString(8));
        customer.setActive(resultSet.getBoolean(9));
        return customer;
    }



}
