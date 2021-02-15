package com.dev.cinema.controller;

import com.dev.cinema.model.ShoppingCart;
import com.dev.cinema.model.dto.response.OrderResponseDto;
import com.dev.cinema.service.OrderService;
import com.dev.cinema.service.ShoppingCartService;
import com.dev.cinema.service.UserService;
import com.dev.cinema.service.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    private final OrderMapper orderMapper;
    private final ShoppingCartService shoppingCartService;
    private final UserService userService;

    @Autowired
    public OrderController(OrderService orderService,
                           OrderMapper orderMapper,
                           ShoppingCartService shoppingCartService,
                           UserService userService) {
        this.orderService = orderService;
        this.orderMapper = orderMapper;
        this.shoppingCartService = shoppingCartService;
        this.userService = userService;
    }

    @PostMapping("/complete")
    public OrderResponseDto complete(@RequestParam Long id) {
        OrderResponseDto orderResponseDto = orderMapper
                .toDto(orderService.completeOrder(shoppingCartService.getByUser(userService.get)))
    }
}
