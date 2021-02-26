package com.dev.theatre.controller;

import com.dev.theatre.model.TheatreSession;
import com.dev.theatre.model.dto.request.TheatreSessionRequestDto;
import com.dev.theatre.model.dto.response.TheatreSessionResponseDto;
import com.dev.theatre.service.PerformanceSessionService;
import com.dev.theatre.service.mapper.TheatreSessionMapper;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/theatre-sessions")
public class TheatreSessionController {
    private final PerformanceSessionService performanceSessionService;
    private final TheatreSessionMapper theatreSessionMapper;

    @Autowired
    public TheatreSessionController(PerformanceSessionService performanceSessionService,
                                    TheatreSessionMapper theatreSessionMapper) {
        this.performanceSessionService = performanceSessionService;
        this.theatreSessionMapper = theatreSessionMapper;
    }

    @PostMapping
    public void add(@RequestBody @Valid TheatreSessionRequestDto theatreSessionRequestDto) {
        TheatreSession theatreSession = theatreSessionMapper.fromDto(theatreSessionRequestDto);
        performanceSessionService.add(theatreSession);
    }

    @GetMapping("/available")
    public List<TheatreSessionResponseDto> getAllAvailable(@RequestParam Long movieId,
                                                           @RequestParam
                                     @DateTimeFormat(pattern = "dd.MM.yyyy") LocalDate localDate) {
        return performanceSessionService.findAvailableSessions(movieId, localDate)
                .stream()
                .map(theatreSessionMapper::toDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id,
                       @RequestBody @Valid TheatreSessionRequestDto theatreSessionRequestDto) {
        TheatreSession theatreSession = theatreSessionMapper.fromDto(theatreSessionRequestDto);
        theatreSession.setId(id);
        performanceSessionService.update(theatreSession);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        performanceSessionService.delete(id);
    }
}
