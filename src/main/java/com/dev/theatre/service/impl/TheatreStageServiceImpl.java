package com.dev.theatre.service.impl;

import com.dev.theatre.dao.TheatreStageDao;
import com.dev.theatre.model.TheatreStage;
import com.dev.theatre.service.TheatreStageService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TheatreStageServiceImpl implements TheatreStageService {
    private final TheatreStageDao theatreStageDao;

    @Autowired
    public TheatreStageServiceImpl(TheatreStageDao theatreStageDao) {
        this.theatreStageDao = theatreStageDao;
    }

    @Override
    public TheatreStage add(TheatreStage theatreStage) {
        return theatreStageDao.add(theatreStage);
    }

    @Override
    public List<TheatreStage> getAll() {
        return theatreStageDao.getAll();
    }

    @Override
    public TheatreStage get(Long id) {
        return theatreStageDao.get(id).get();
    }
}
