package com.dev.cinema.model.dto.request;

import javax.validation.constraints.Min;

public class CinemaHallRequestDto {
    @Min(50)
    private int capacity;
    private String description;

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
