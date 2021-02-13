package com.dev.cinema.service.mapper;

import com.dev.cinema.model.MovieSession;
import com.dev.cinema.model.dto.request.MovieSessionRequestDto;
import com.dev.cinema.model.dto.response.MovieSessionResponseDto;
import com.dev.cinema.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MovieSessionMapper {
    private final MovieService movieService;

    @Autowired
    public MovieSessionMapper(MovieService movieService) {
        this.movieService = movieService;
    }

    public MovieSessionResponseDto toDto(MovieSession movieSession) {
        MovieSessionResponseDto movieSessionResponseDto = new MovieSessionResponseDto();
        movieSessionResponseDto.setMovieSessionId(movieSession.getId());
        movieSessionResponseDto.setMovieTitle(movieSession.getMovie().getTitle());
        movieSessionResponseDto.setShowTime(movieSession.getShowTime().toString());
        movieSessionResponseDto.setCinemaHallId(movieSession.getCinemaHall().getId());
        movieSessionResponseDto.setCinemaHallCapacity(movieSession.getCinemaHall().getCapacity());
        return movieSessionResponseDto;
    }

    public MovieSession fromDto(MovieSessionRequestDto movieSessionRequestDto) {
        MovieSession movieSession = new MovieSession();
        movieSession.setId(movieSessionRequestDto.getId());
        movieSession.setMovie(movieService.);
    }
}
