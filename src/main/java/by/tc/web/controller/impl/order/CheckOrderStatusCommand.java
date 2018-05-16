package by.tc.web.controller.impl.order;

import by.tc.web.controller.ControllerCommand;
import by.tc.web.controller.impl.constant.ControllerConstants;
import by.tc.web.entity.Customer;
import by.tc.web.entity.Order;
import by.tc.web.service.OrderService;
import by.tc.web.service.ServiceFactory;
import by.tc.web.service.exception.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CheckOrderStatusCommand implements ControllerCommand {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException  {
        OrderService orderService = ServiceFactory.getInstance().getOrderService();
        Customer customer = (Customer) request.getSession().getAttribute("user");
        try {
            Order order = orderService.getOrderByCustomerID(customer.getId());
            String message = null;
            if(order!=null){
               message = order.getStatus().name();
            }else{
                message = ControllerConstants.FINISHED_VALUE;
            }


            response.setContentType("text/plain");
            request.setAttribute(ControllerConstants.MESSAGE, message);
            request.getRequestDispatcher(ControllerConstants.FINISH_PAGE).forward(request,response);

        } catch (ServiceException|IOException e) {
            e.printStackTrace();
        }






    }
}
