package com.teologia.app.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public record CreateScheduleEventRequest(
    @NotBlank(message = "O título do evento é obrigatório.")
    String title,

    String description,

    @NotNull(message = "A data/hora de início é obrigatória.")
    LocalDateTime startTime,

    @NotNull(message = "A data/hora de término é obrigatória.")
    LocalDateTime endTime,

    String locationOrLink,

    @NotNull(message = "O ID da turma é obrigatório.")
    Long classGroupId
) {}