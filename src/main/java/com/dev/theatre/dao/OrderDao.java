package com.dev.theatre.dao;

import com.dev.theatre.model.Order;
import com.dev.theatre.model.User;
import java.util.List;

public interface OrderDao {
    Order add(Order order);

    List<Order> getOrdersHistory(User user);
}
