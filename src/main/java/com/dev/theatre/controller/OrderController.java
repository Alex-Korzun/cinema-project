package com.dev.theatre.controller;

import com.dev.theatre.model.User;
import com.dev.theatre.model.dto.response.OrderResponseDto;
import com.dev.theatre.service.OrderService;
import com.dev.theatre.service.ShoppingCartService;
import com.dev.theatre.service.UserService;
import com.dev.theatre.service.mapper.OrderMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public OrderResponseDto complete(Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String email = userDetails.getUsername();
        User user = userService.findByEmail(email).get();
        return orderMapper.toDto(orderService.completeOrder(shoppingCartService.getByUser(user)));
    }

    @GetMapping
    public List<OrderResponseDto> getOrdersById(Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String email = userDetails.getUsername();
        User user = userService.findByEmail(email).get();
        return orderService.getOrdersHistory(user)
                .stream()
                .map(orderMapper::toDto)
                .collect(Collectors.toList());
    }
}
