package by.tc.web.controller.impl.administrator;

import by.tc.web.controller.ControllerCommand;
import by.tc.web.controller.impl.constant.ControllerConstants;
import by.tc.web.entity.Customer;
import by.tc.web.service.ServiceFactory;
import by.tc.web.service.UserService;
import by.tc.web.service.exception.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ShowAllUsersCommandImpl implements ControllerCommand{
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            UserService<Customer> customerService = ServiceFactory.getInstance().getCustomerService();
            List<Customer> customerList = customerService.getAllUsers();
            request.setAttribute(ControllerConstants.CUSTOMER_LIST_ATTR, customerList);
            request.getRequestDispatcher(ControllerConstants.CUSOMER_PAGE).forward(request,response);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
}
