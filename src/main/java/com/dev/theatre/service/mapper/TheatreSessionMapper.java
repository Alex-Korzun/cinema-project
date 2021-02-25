package com.dev.theatre.service.mapper;

import com.dev.theatre.model.TheatreSession;
import com.dev.theatre.model.dto.request.TheatreSessionRequestDto;
import com.dev.theatre.model.dto.response.TheatreSessionResponseDto;
import com.dev.theatre.service.PerformanceService;
import com.dev.theatre.service.TheatreStageService;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TheatreSessionMapper {
    private final PerformanceService performanceService;
    private final TheatreStageService theatreStageService;

    @Autowired
    public TheatreSessionMapper(PerformanceService performanceService,
                                TheatreStageService theatreStageService) {
        this.performanceService = performanceService;
        this.theatreStageService = theatreStageService;
    }

    public TheatreSessionResponseDto toDto(TheatreSession theatreSession) {
        TheatreSessionResponseDto theatreSessionResponseDto = new TheatreSessionResponseDto();
        theatreSessionResponseDto.setTheatreSessionId(theatreSession.getId());
        theatreSessionResponseDto.setPerformanceTitle(theatreSession.getPerformance().getTitle());
        theatreSessionResponseDto.setShowTime(theatreSession.getShowTime().toString());
        theatreSessionResponseDto.setTheatreStageId(theatreSession.getTheatreStage().getId());
        theatreSessionResponseDto.setTheatreStageCapacity(theatreSession
                .getTheatreStage().getCapacity());
        return theatreSessionResponseDto;
    }

    public TheatreSession fromDto(TheatreSessionRequestDto theatreSessionRequestDto) {
        TheatreSession theatreSession = new TheatreSession();
        theatreSession.setPerformance(performanceService
                .get(theatreSessionRequestDto.getMovieId()));
        theatreSession.setTheatreStage(theatreStageService
                .get(theatreSessionRequestDto.getCinemaHallId()));
        LocalDateTime localDateTime = LocalDateTime
                .parse(theatreSessionRequestDto
                        .getShowTime(), DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        theatreSession.setShowTime(localDateTime);
        return theatreSession;
    }
}
