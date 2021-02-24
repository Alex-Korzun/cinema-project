package com.dev.theatre.service;

import com.dev.theatre.model.TheatreStage;
import java.util.List;

public interface TheatreStageService {
    TheatreStage add(TheatreStage theatreStage);

    List<TheatreStage> getAll();

    TheatreStage get(Long id);
}
