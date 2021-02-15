package com.dev.cinema.service.mapper;

import com.dev.cinema.model.Order;
import com.dev.cinema.model.Ticket;
import com.dev.cinema.model.dto.response.OrderResponseDto;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {
    public OrderResponseDto toDto(Order order) {
        OrderResponseDto orderResponseDto = new OrderResponseDto();
        orderResponseDto.setId(order.getId());
        orderResponseDto.setDate(order.getOrderDate().toString());
        orderResponseDto.setEmail(orderResponseDto.getEmail());
        orderResponseDto.setTicketIds(order.getTickets()
                .stream()
                .map(Ticket::getId)
        .collect(Collectors.toList()));
        return orderResponseDto;
    }
}
