package com.dev.theatre.model.dto.response;

public class TheatreSessionResponseDto {
    private Long theatreSessionId;
    private String performanceTitle;
    private String showTime;
    private Long theatreStageId;
    private int theatreStageCapacity;

    public Long getTheatreSessionId() {
        return theatreSessionId;
    }

    public void setTheatreSessionId(Long theatreSessionId) {
        this.theatreSessionId = theatreSessionId;
    }

    public String getPerformanceTitle() {
        return performanceTitle;
    }

    public void setPerformanceTitle(String performanceTitle) {
        this.performanceTitle = performanceTitle;
    }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }

    public Long getTheatreStageId() {
        return theatreStageId;
    }

    public void setTheatreStageId(Long theatreStageId) {
        this.theatreStageId = theatreStageId;
    }

    public int getTheatreStageCapacity() {
        return theatreStageCapacity;
    }

    public void setTheatreStageCapacity(int theatreStageCapacity) {
        this.theatreStageCapacity = theatreStageCapacity;
    }
}
