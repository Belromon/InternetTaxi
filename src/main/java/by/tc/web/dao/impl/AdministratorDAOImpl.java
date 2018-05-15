package by.tc.web.dao.impl;

import by.tc.web.dao.AbstractDAO;
import by.tc.web.entity.Administrator;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdministratorDAOImpl extends AbstractDAO<Administrator> {
    private static final String CREATE_QUERY = "INSERT INTO user(name, surname, login, password, role) VALUES (?, ?, ?, ?, ?)";
    private static final String READ_BY_PHONE_AND_PASSWORD_QUERY = "SELECT * FROM user WHERE login=? AND password=? AND role='admin'";
    private final static String UPDATE_QUERY = "UPDATE user SET name=? , surname=?  WHERE id = ? AND role = 'admin'";
    private static final String DELETE_QUERY = "UPDATE user SET is_active='0' WHERE id=? AND role = 'admin'";
    private static final String READ_USER_BY_ID = "SELECT * FROM user WHERE id=? AND role = 'admin'";
    private static final String READ_ALL_ADMINS = "SELECT * FROM user WHERE role = 'admin'";
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
        return READ_ALL_ADMINS;
    }

    @Override
    public String getQueryForAutentification() {
        return READ_BY_PHONE_AND_PASSWORD_QUERY;
    }

    @Override
    public String getReadByIdQuery() {
        return READ_USER_BY_ID ;
    }

    @Override
    public String getQueryForFreeDrivers() {
        throw new UnsupportedOperationException("Using method for driver in administrator dao class");
    }

    @Override
    public String getReadNewOrdersForDriverQuery() {
        throw new UnsupportedOperationException("Using method for driver in administrator dao class");
    }

    @Override
    public String getReadOrderByCustomerIDQuery() {
        throw new UnsupportedOperationException("Using method for order in administrator dao class");
    }


    @Override
    public void executeCreateQuery(PreparedStatement preparedStatement, Administrator administrator) throws SQLException {
        preparedStatement.setString(1,administrator.getName());
        preparedStatement.setString(2,administrator.getSurname());
        preparedStatement.setString(3,administrator.getLogin());
        preparedStatement.setString(4, administrator.getPassword());
        preparedStatement.setString(5,"admin");
    }

    @Override
    public void executeUpdateQuery(PreparedStatement preparedStatement, Administrator administrator) throws SQLException {
        preparedStatement.setString(1,administrator.getName());
        preparedStatement.setString(2,administrator.getSurname());
        preparedStatement.setString(3,"admin");
    }

    @Override
    public void executeDeleteQuery(PreparedStatement preparedStatement, Administrator administrator) throws SQLException {
        preparedStatement.setInt(1,administrator.getId());
    }

    @Override
    public Administrator parseResultSet(ResultSet resultSet) throws SQLException {
        Administrator administrator = new Administrator();
        administrator.setId(resultSet.getInt(1));
        administrator.setName(resultSet.getString(2));
        administrator.setSurname(resultSet.getString(3));
        administrator.setLogin(resultSet.getString(4));
        administrator.setPassword(resultSet.getString(5));
        administrator.setBanned(resultSet.getBoolean(7));
        administrator.setRole(resultSet.getString(8));
        administrator.setActive(resultSet.getBoolean(9));
        return administrator;
    }



}
