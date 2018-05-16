package by.tc.web.controller.impl.order;

import by.tc.web.controller.ControllerCommand;
import by.tc.web.controller.impl.constant.ControllerConstants;
import by.tc.web.entity.Driver;
import by.tc.web.entity.Order;
import by.tc.web.service.OrderService;
import by.tc.web.service.ServiceFactory;
import by.tc.web.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class ProvideOrdersToDriverCommand implements ControllerCommand {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws  IOException{
        Driver driver = (Driver) request.getSession().getAttribute(ControllerConstants.USER_ROLE);
        if (driver != null) {

            try {
                OrderService orderService = ServiceFactory.getInstance().getOrderService();
                List<Order> orderList = orderService.getOrdersForDriver(driver.getId());
                HttpSession session = request.getSession();
                session.setAttribute("orderList", orderList);
                response.sendRedirect("driverorders");
            } catch (ServiceException e) {
                e.printStackTrace();
            }


        }
    }
}
