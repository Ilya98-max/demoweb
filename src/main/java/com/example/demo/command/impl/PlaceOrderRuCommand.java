package com.example.demo.command.impl;

import com.example.demo.command.Command;
import com.example.demo.entity.Order;
import com.example.demo.exception.CommandException;
import com.example.demo.exception.ServiceException;
import com.example.demo.service.OrderService;
import com.example.demo.service.impl.OrderServiceImpl;

import javax.servlet.http.HttpServletRequest;

public class PlaceOrderRuCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String coffeeType = request.getParameter("coffee_type");
        String coffeeQuantityParam = request.getParameter("coffee_quantity");
        String dessertType = request.getParameter("dessert_type");
        String dessertQuantityParam = request.getParameter("dessert_quantity");
        String language = request.getParameter("language");

        if (coffeeQuantityParam == null || coffeeQuantityParam.isEmpty() ||
                coffeeType == null || coffeeType.isEmpty() ||
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

        Order order = new Order(coffeeType, coffeeQuantity, dessertType, dessertQuantity);

        OrderService orderService = OrderServiceImpl.getInstance();
        boolean placed;
        try {
            placed = orderService.addOrder(order);
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }

        if (placed) {

            return "order_ready.jsp?language=" + language;
        } else {

            return "order_unready.jsp?language=" + language;
        }
    }
}