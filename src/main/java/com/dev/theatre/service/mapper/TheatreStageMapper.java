package com.dev.theatre.service.mapper;

import com.dev.theatre.model.TheatreStage;
import com.dev.theatre.model.dto.request.TheatreStageRequestDto;
import com.dev.theatre.model.dto.response.TheatreStageResponseDto;
import org.springframework.stereotype.Component;

@Component
public class TheatreStageMapper {
    public TheatreStageResponseDto toDto(TheatreStage theatreStage) {
        TheatreStageResponseDto theatreStageResponseDto = new TheatreStageResponseDto();
        theatreStageResponseDto.setId(theatreStage.getId());
        theatreStageResponseDto.setCapacity(theatreStage.getCapacity());
        theatreStageResponseDto.setDescription(theatreStage.getDescription());
        return theatreStageResponseDto;
    }

    public TheatreStage fromDto(TheatreStageRequestDto theatreStageRequestDto) {
        TheatreStage theatreStage = new TheatreStage();
        theatreStage.setCapacity(theatreStageRequestDto.getCapacity());
        theatreStage.setDescription(theatreStageRequestDto.getDescription());
        return theatreStage;
    }
}
