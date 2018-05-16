package by.tc.web.controller.impl.administrator;

import by.tc.web.controller.ControllerCommand;
import by.tc.web.controller.impl.constant.ControllerConstants;
import by.tc.web.entity.Order;
import by.tc.web.service.OrderService;
import by.tc.web.service.exception.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ShowAllOrdersCommand implements ControllerCommand {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ServiceException {
        OrderService orderService = new OrderService();
        List<Order> orderList = orderService.getAllOrders();
        request.setAttribute(ControllerConstants.ORDER_LIST_ATTR, orderList);
        request.getRequestDispatcher(ControllerConstants.ORDERS_PAGE).forward(request,response);

    }
}
