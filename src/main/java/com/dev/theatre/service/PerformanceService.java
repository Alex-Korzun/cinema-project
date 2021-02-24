package com.dev.theatre.service;

import com.dev.theatre.model.Performance;
import java.util.List;

public interface PerformanceService {
    Performance add(Performance performance);

    List<Performance> getAll();

    Performance get(Long id);
}
