package by.tc.web.dao.pool;

import by.tc.web.dao.exception.ConnectionPoolException;

import java.sql.Connection;

public interface ConnectionPool {
    Connection getConnection() throws ConnectionPoolException;

    boolean returnConnection(Connection connection) throws ConnectionPoolException;


}
