package com.dev.theatre.dao;

import com.dev.theatre.model.ShoppingCart;
import com.dev.theatre.model.User;

public interface ShoppingCartDao {
    ShoppingCart add(ShoppingCart shoppingCart);

    ShoppingCart getByUser(User user);

    void update(ShoppingCart shoppingCart);
}
