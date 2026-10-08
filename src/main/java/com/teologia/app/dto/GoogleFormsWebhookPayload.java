package com.teologia.app.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record GoogleFormsWebhookPayload(
    @NotBlank(message = "O e-mail do aluno é obrigatório.")
    String studentEmail,

    @NotBlank(message = "O ID do formulário é obrigatório.")
    String formId,

    @NotNull(message = "A nota é obrigatória.")
    Double score
) {}