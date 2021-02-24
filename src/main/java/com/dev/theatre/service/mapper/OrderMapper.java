package com.dev.theatre.service.mapper;

import com.dev.theatre.model.Order;
import com.dev.theatre.model.Ticket;
import com.dev.theatre.model.dto.response.OrderResponseDto;
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
