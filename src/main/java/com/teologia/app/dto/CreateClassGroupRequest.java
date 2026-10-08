package com.teologia.app.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateClassGroupRequest(
    @NotBlank(message = "O nome da turma é obrigatório.")
    String name,

    @NotBlank(message = "A categoria/modalidade é obrigatória.")
    String category,

    String description
) {}