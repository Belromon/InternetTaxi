package by.tc.web.dao.pool;

import by.tc.web.dao.exception.CloseConnectionException;
import by.tc.web.dao.exception.ConnectionPoolException;

import java.io.Closeable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLConnection implements Closeable {
    private Connection connection;

    public MySQLConnection(Connection connection){
        this.connection = connection;
    }

    @Override
    public void close() throws CloseConnectionException {
        try {
            ConnectionPoolImpl.getInstance().returnConnection(connection);
        } catch (ConnectionPoolException e) {
            throw new CloseConnectionException(e);

        }

    }
    public PreparedStatement getPreparedStatement(String sqlQuery) throws SQLException {
        return connection.prepareStatement(sqlQuery);
    }

    public Statement createStatement() throws SQLException {
        return connection.createStatement();
    }

    public void setAutoCommit(boolean flag) throws SQLException {
        connection.setAutoCommit(flag);
    }


    public void commit() throws SQLException {
        connection.commit();
    }

    public void rollback() throws SQLException {
        connection.rollback();
    }
}
