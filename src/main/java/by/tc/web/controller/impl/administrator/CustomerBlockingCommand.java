package by.tc.web.controller.impl.administrator;

import by.tc.web.controller.ControllerCommand;
import by.tc.web.entity.Customer;
import by.tc.web.service.ServiceFactory;
import by.tc.web.service.UserService;
import by.tc.web.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomerBlockingCommand implements ControllerCommand {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws  IOException {
        int idDriver = Integer.valueOf(request.getParameter("id"));
        try {
            UserService<Customer> customerService = ServiceFactory.getInstance().getCustomerService();
            boolean confirm =  customerService.block(idDriver);
            if (confirm){
                response.setContentType("text/plain");
                response.getWriter().write("true");
            }
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
}
