package com.teologia.app.service;

import com.teologia.app.dto.GoogleFormsWebhookPayload;
import com.teologia.app.model.StudyMaterialProgress;
import com.teologia.app.repository.StudyMaterialProgressRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GradeProcessingService {

    private final StudyMaterialProgressRepository progressRepository;

    public GradeProcessingService(StudyMaterialProgressRepository progressRepository) {
        this.progressRepository = progressRepository;
    }

    @Transactional
    public void processStudentExamResult(GoogleFormsWebhookPayload payload) {
        StudyMaterialProgress progress = progressRepository
                .findByStudentEmailAndGoogleFormId(payload.studentEmail(), payload.formId())
                .orElseThrow(() -> new IllegalArgumentException("Registro de apostila/prova não encontrado para o aluno e formulário informados."));

        progress.processGrade(payload.score());
        progressRepository.save(progress);
    }
}