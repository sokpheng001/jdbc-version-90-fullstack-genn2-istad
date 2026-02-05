package model.dto;

import java.time.LocalDate;

// dto - data transfer object
public record StudentCreateDto(
        String userName,
        String email,
        String password,
        LocalDate birdOfDate
) { }
