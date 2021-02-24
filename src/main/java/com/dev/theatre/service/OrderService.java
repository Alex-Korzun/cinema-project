package com.dev.theatre.service;

import com.dev.theatre.model.Order;
import com.dev.theatre.model.ShoppingCart;
import com.dev.theatre.model.User;
import java.util.List;

public interface OrderService {
    Order completeOrder(ShoppingCart shoppingCart);

    List<Order> getOrdersHistory(User user);
}
