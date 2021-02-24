package com.dev.theatre.model;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "theatre_session")
public class TheatreSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Performance performance;
    @ManyToOne
    @JoinColumn(name = "cinema_hall_id")
    private TheatreStage theatreStage;
    private LocalDateTime showTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Performance getPerformance() {
        return performance;
    }

    public void setPerformance(Performance performance) {
        this.performance = performance;
    }

    public TheatreStage getTheatreStage() {
        return theatreStage;
    }

    public void setTheatreStage(TheatreStage theatreStage) {
        this.theatreStage = theatreStage;
    }

    public LocalDateTime getShowTime() {
        return showTime;
    }

    public void setShowTime(LocalDateTime showTime) {
        this.showTime = showTime;
    }

    @Override
    public String toString() {
        return "TheatreSession{"
                + "id=" + id
                + ", performance=" + performance
                + ", theatreStage=" + theatreStage
                + ", showTime=" + showTime
                + '}';
    }
}
