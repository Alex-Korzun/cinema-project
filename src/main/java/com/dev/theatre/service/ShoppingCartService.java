package com.dev.theatre.service;

import com.dev.theatre.model.TheatreSession;
import com.dev.theatre.model.ShoppingCart;
import com.dev.theatre.model.User;

public interface ShoppingCartService {
    void addSession(TheatreSession theatreSession, User user);

    ShoppingCart getByUser(User user);

    void registerNewShoppingCart(User user);

    void clear(ShoppingCart shoppingCart);
}
