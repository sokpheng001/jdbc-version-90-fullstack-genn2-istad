package model.dto;

import java.time.LocalDate;

public record StudentCreateDto(
        String userName,
        String email,
        String password,
        LocalDate birdOfDate
) { }
