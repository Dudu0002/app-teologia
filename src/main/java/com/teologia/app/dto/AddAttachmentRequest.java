package com.teologia.app.dto;

import jakarta.validation.constraints.NotBlank;

public record AddAttachmentRequest(
    @NotBlank(message = "O título do anexo é obrigatório.")
    String title,

    @NotBlank(message = "A URL ou caminho do arquivo é obrigatório.")
    String fileUrlOrPath,

    String fileType
) {}