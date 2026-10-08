package com.teologia.app.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateSubjectRequest(
    @NotBlank(message = "O nome da disciplina é obrigatório.")
    String name,

    String description,

    @NotNull(message = "O ID da turma é obrigatório.")
    Long classGroupId
) {}