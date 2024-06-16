package com.example.demo.command.impl;

import com.example.demo.command.Command;
import com.example.demo.entity.Order;
import com.example.demo.exception.CommandException;
import com.example.demo.exception.ServiceException;
import com.example.demo.service.OrderService;
import com.example.demo.service.impl.OrderServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class PlaceOrderCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String coffeeType = request.getParameter("coffee_type");
        String coffeeQuantityParam = request.getParameter("coffee_quantity");
        String dessertType = request.getParameter("dessert_type");
        String dessertQuantityParam = request.getParameter("dessert_quantity");
        String language = request.getParameter("language");


        if (coffeeType == null || coffeeType.isEmpty() ||
                coffeeQuantityParam == null || coffeeQuantityParam.isEmpty() ||
                dessertType == null || dessertType.isEmpty() ||
                dessertQuantityParam == null || dessertQuantityParam.isEmpty()) {

            return "order_unready.jsp?language=" + language;
        }


        int coffeeQuantity;
        int dessertQuantity;
        try {
            coffeeQuantity = Integer.parseInt(coffeeQuantityParam);
            dessertQuantity = Integer.parseInt(dessertQuantityParam);
        } catch (NumberFormatException e) {

            throw new CommandException("Error parsing quantity parameters", e);
        }


        HttpSession session = request.getSession();
        Integer userId = (Integer) session.getAttribute("user_id");
        String userName = (String) session.getAttribute("login");

        if (userId == null) {

            throw new CommandException("User ID not found in session");
        }


        Order order = new Order(coffeeType, coffeeQuantity, dessertType, dessertQuantity, userId, userName);


        OrderService orderService = OrderServiceImpl.getInstance();
        boolean placed;
        try {
            placed = orderService.addOrder(order);
        } catch (ServiceException e) {

            throw new CommandException("Failed to add order", e);
        }


        if (placed) {
            return "order_ready.jsp?language=" + language;
        } else {
            return "order_unready.jsp?language=" + language;
        }
    }
}
