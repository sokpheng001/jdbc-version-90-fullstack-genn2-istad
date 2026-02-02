package model.dto;

import java.time.LocalDate;

public record StudentUpdateDto (
        String userName,
        String email,
        String profile,
        LocalDate birdOfDate
){ }
