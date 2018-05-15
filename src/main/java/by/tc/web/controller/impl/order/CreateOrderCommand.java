package by.tc.web.controller.impl.order;

import by.tc.web.controller.ControllerCommand;
import by.tc.web.entity.*;
import by.tc.web.service.DriverService;
import by.tc.web.service.LocationHandler;
import by.tc.web.service.exception.ServiceException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class CreateOrderCommand implements ControllerCommand {


    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        DriverService driverService = new DriverService();
        Customer customer = (Customer) request.getSession().getAttribute("user");
        Order order = new Order();
        String from = request.getParameter("from");
        String destination = request.getParameter("destination");
        order.setFrom(from);
        order.setDestination(destination);
        order.setStatus(OrderStatus.NEW);
        order.setId_customer(customer.getId());

        Point startPoint = new Point();
        startPoint.setX(LocationHandler.getRandomCoordinate());
        startPoint.setY(LocationHandler.getRandomCoordinate());
        Point endPoint = new Point();
        endPoint.setX(LocationHandler.getRandomCoordinate());
        endPoint.setY(LocationHandler.getRandomCoordinate());

        order.setStart(startPoint);
        order.setEnd(endPoint);

        if (order != null) {
            try {
                HttpSession session = request.getSession();
                session.setAttribute("order", order);
                List<Driver> driverList = driverService.getFreeDrivers();

                String nextJSP = "/main";
                RequestDispatcher dispatcher = request.getRequestDispatcher(nextJSP);
                request.setAttribute("driverList", driverList);
                dispatcher.forward(request, response);
            } catch (ServiceException e) {
                response.sendRedirect("/error");
            }
        }


    }


}
