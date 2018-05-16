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

import static by.tc.web.controller.impl.constant.ControllerConstants.*;

public class CheckActiveCustomerOrderCommand implements ControllerCommand {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ServiceException {
        OrderService orderService = ServiceFactory.getInstance().getOrderService();
        Customer customer = (Customer) request.getSession().getAttribute(USER_ROLE);
        try {
            Order order = orderService.getOrderByCustomerID(customer.getId());
            if(order == null || order.getStatus().equals(OrderStatus.DECLINED)) {
                response.sendRedirect(MAIN_PAGE);
            }else {
                response.sendRedirect(FINISH_PAGE);
            }


        } catch (ServiceException| IOException e) {
            e.printStackTrace();
        }
    }
}
