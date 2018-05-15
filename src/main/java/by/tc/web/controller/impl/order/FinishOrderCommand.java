package by.tc.web.controller.impl.order;

import by.tc.web.controller.ControllerCommand;
import by.tc.web.entity.Order;
import by.tc.web.entity.OrderStatus;
import by.tc.web.service.OrderService;
import by.tc.web.service.ServiceFactory;
import by.tc.web.service.exception.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class FinishOrderCommand implements ControllerCommand {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String idOrder = request.getParameter("id");
        try {
            OrderService orderService = ServiceFactory.getInstance().getOrderService();
            Order order = orderService.readByID(Integer.valueOf(idOrder));
            order.setStatus(OrderStatus.FINISHED);
            orderService.update(order);
            response.setContentType("text/plain");
            response.getWriter().write("true");


        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
}
