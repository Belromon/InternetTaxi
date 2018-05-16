package by.tc.web.controller.impl.order;

import by.tc.web.controller.ControllerCommand;
import by.tc.web.controller.impl.constant.ControllerConstants;
import by.tc.web.entity.Order;
import by.tc.web.service.OrderService;
import by.tc.web.service.ServiceFactory;
import by.tc.web.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FindDriverCommand implements ControllerCommand{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws  IOException {
        int idDriver = Integer.valueOf(request.getParameter(ControllerConstants.ID_DRIVER));
        Order order = (Order)request.getSession().getAttribute(ControllerConstants.ORDER_ATTR);
        order.setId_driver(idDriver);
        try {

            OrderService orderService = ServiceFactory.getInstance().getOrderService();
            orderService.create(order);

            response.sendRedirect(ControllerConstants.FINISH_PAGE);
        } catch (ServiceException e) {
            response.sendRedirect("/error");
        }
    }
}
