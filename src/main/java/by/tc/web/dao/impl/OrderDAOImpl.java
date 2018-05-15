package by.tc.web.dao.impl;

import by.tc.web.dao.AbstractDAO;
import by.tc.web.entity.Order;
import by.tc.web.entity.OrderStatus;
import by.tc.web.entity.Point;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDAOImpl extends AbstractDAO<Order> {
    private static final String CREATE_QUERY = "INSERT INTO Taxi.order(x_start, y_start, x_end, y_end, start_addr, end_addr, price, status, id_customer, id_driver) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private final static String UPDATE_QUERY = "UPDATE Taxi.order SET id_driver=?, status=? WHERE id = ?";
    private static final String DELETE_QUERY = "UPDATE Taxi.order SET is_active='0' WHERE id=?";
    private static final String READ_ALL_ORDERS = "SELECT * FROM Taxi.order";
    private static final String READ_ORDER_BY_ID = "SELECT * FROM Taxi.order WHERE id=?";
    private static final String READ_NEW_ORDERS_FOR_DRIVER = "SELECT * FROM Taxi.order WHERE NOT status = 'FINISHED' AND id_driver = ?";
    private static final String READ_ORDER_BY_CUSTOMER_ID = "SELECT * FROM Taxi.order WHERE NOT status = 'FINISHED' AND id_customer = ?";


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
        return READ_ALL_ORDERS;
    }

    @Override
    public String getQueryForAutentification() {
        throw new UnsupportedOperationException("Using authentification method in dao order class");
    }

    @Override
    public String getReadByIdQuery() {
        return READ_ORDER_BY_ID;
    }

    @Override
    public String getQueryForFreeDrivers() {
         throw new UnsupportedOperationException("Using driver method in dao order class");
    }

    public String getReadNewOrdersForDriverQuery() {
        return READ_NEW_ORDERS_FOR_DRIVER;
    }

    @Override
    public String getReadOrderByCustomerIDQuery() {
        return READ_ORDER_BY_CUSTOMER_ID;
    }

    @Override
    public void executeCreateQuery(PreparedStatement preparedStatement, Order order) throws SQLException {
        preparedStatement.setDouble(1, order.getStart().getX());
        preparedStatement.setDouble(2, order.getStart().getY());
        preparedStatement.setDouble(3, order.getEnd().getX());
        preparedStatement.setDouble(4, order.getEnd().getY());
        preparedStatement.setString(5, order.getFrom());
        preparedStatement.setString(6, order.getDestination());
        preparedStatement.setDouble(7, 100);
        preparedStatement.setString(8, order.getStatus().toString());
        preparedStatement.setInt(9, order.getId_customer());
        preparedStatement.setInt(10, order.getId_driver());


    }

    @Override
    public void executeUpdateQuery(PreparedStatement preparedStatement, Order order) throws SQLException {
        preparedStatement.setInt(1, order.getId_driver());
        preparedStatement.setString(2, order.getStatus().toString());
        preparedStatement.setInt(3, order.getId());

    }

    @Override
    public void executeDeleteQuery(PreparedStatement preparedStatement, Order id) throws SQLException {

    }

    @Override
    public Order parseResultSet(ResultSet resultSet) throws SQLException {
        Order order = new Order();
        order.setId(resultSet.getInt(1));
        Point point = new Point();
        point.setX(resultSet.getDouble(2));
        point.setY(resultSet.getDouble(3));
        order.setStart(point);
        point.setX(resultSet.getDouble(4));
        point.setY(resultSet.getDouble(5));
        order.setEnd(point);
        order.setFrom(resultSet.getString(6));
        order.setDestination(resultSet.getString(7));
        order.setPrice(resultSet.getDouble(8));
        order.setStatus(OrderStatus.valueOf(resultSet.getString(9)));
        order.setId_customer(resultSet.getInt(10));
        order.setId_driver(resultSet.getInt(11));
        return order;
    }


}
