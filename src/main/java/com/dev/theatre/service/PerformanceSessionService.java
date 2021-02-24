package com.dev.theatre.service;

import com.dev.theatre.model.TheatreSession;
import java.time.LocalDate;
import java.util.List;

public interface PerformanceSessionService {
    TheatreSession add(TheatreSession theatreSession);

    List<TheatreSession> findAvailableSessions(Long performanceId, LocalDate date);

    TheatreSession get(Long id);

    TheatreSession update(TheatreSession theatreSession);

    void delete(Long id);
}
