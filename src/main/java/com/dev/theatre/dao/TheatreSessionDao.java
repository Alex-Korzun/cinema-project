package com.dev.theatre.dao;

import com.dev.theatre.model.TheatreSession;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface TheatreSessionDao {
    TheatreSession add(TheatreSession theatreSession);

    List<TheatreSession> findAvailableSessions(Long performanceId, LocalDate date);

    Optional<TheatreSession> get(Long id);

    TheatreSession update(TheatreSession theatreSession);

    void delete(Long id);
}
