package by.tc.web.controller.impl.account;

import by.tc.web.controller.ControllerCommand;
import by.tc.web.entity.Customer;
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

public class CheckActiveCustomerOrderCommand implements ControllerCommand {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ServiceException {
        OrderService orderService = ServiceFactory.getInstance().getOrderService();
        Customer customer = (Customer) request.getSession().getAttribute("user");
        try {
            Order order = orderService.getOrderByCustomerID(customer.getId());
            String status = order.getStatus().name();

            if(status.equals(OrderStatus.FINISHED) || status.equals(OrderStatus.DECLINED)) {
                response.sendRedirect("/main");
            }else {
                response.sendRedirect("/finish");
            }


        } catch (ServiceException| IOException e) {
            e.printStackTrace();
        }
    }
}
