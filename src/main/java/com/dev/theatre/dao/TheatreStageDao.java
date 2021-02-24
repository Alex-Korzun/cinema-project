package com.dev.theatre.dao;

import com.dev.theatre.model.TheatreStage;
import java.util.List;
import java.util.Optional;

public interface TheatreStageDao {
    TheatreStage add(TheatreStage theatreStage);

    List<TheatreStage> getAll();

    Optional<TheatreStage> get(Long id);
}
