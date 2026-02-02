package model.dto;

import java.time.LocalDate;

public record StudentResponseDto(
         String uuid,
         String userName,
         String email,
         String profile,
         String cardId,
         LocalDate birthOfDate
) { }
