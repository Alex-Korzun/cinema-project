package com.dev.theatre.service.impl;

import com.dev.theatre.dao.TheatreSessionDao;
import com.dev.theatre.model.TheatreSession;
import com.dev.theatre.service.PerformanceSessionService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerformanceSessionServiceImpl implements PerformanceSessionService {
    private final TheatreSessionDao theatreSessionDao;

    @Autowired
    public PerformanceSessionServiceImpl(TheatreSessionDao theatreSessionDao) {
        this.theatreSessionDao = theatreSessionDao;
    }

    @Override
    public TheatreSession add(TheatreSession session) {
        return theatreSessionDao.add(session);
    }

    @Override
    public List<TheatreSession> findAvailableSessions(Long movieId, LocalDate date) {
        return theatreSessionDao.findAvailableSessions(movieId, date);
    }

    @Override
    public TheatreSession get(Long id) {
        return theatreSessionDao.get(id).get();
    }

    @Override
    public TheatreSession update(TheatreSession theatreSession) {
        return theatreSessionDao.update(theatreSession);
    }

    @Override
    public void delete(Long id) {
        theatreSessionDao.delete(id);
    }
}
