package com.dev.theatre.dao;

import com.dev.theatre.model.Performance;
import java.util.List;
import java.util.Optional;

public interface PerformanceDao {
    Performance add(Performance performance);

    List<Performance> getAll();

    Optional<Performance> get(Long id);
}
