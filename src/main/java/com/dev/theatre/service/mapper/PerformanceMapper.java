package com.dev.theatre.service.mapper;

import com.dev.theatre.model.Performance;
import com.dev.theatre.model.dto.request.PerformanceRequestDto;
import com.dev.theatre.model.dto.response.PerformanceResponseDto;
import org.springframework.stereotype.Component;

@Component
public class PerformanceMapper {
    public PerformanceResponseDto toDto(Performance performance) {
        PerformanceResponseDto performanceResponseDto = new PerformanceResponseDto();
        performanceResponseDto.setId(performance.getId());
        performanceResponseDto.setTitle(performance.getTitle());
        performanceResponseDto.setDescription(performance.getDescription());
        return performanceResponseDto;
    }

    public Performance fromDto(PerformanceRequestDto performanceRequestDto) {
        Performance performance = new Performance();
        performance.setTitle(performanceRequestDto.getTitle());
        performance.setDescription(performanceRequestDto.getDescription());
        return performance;
    }
}
