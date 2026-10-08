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
        if (payload == null) {
            throw new IllegalArgumentException("O payload do webhook não pode ser nulo.");
        }
        // Chamada direta usando os componentes do Record (sem 'get')
        processStudentExamResult(
            payload.studentEmail(),
            payload.formId(),
            payload.score()
        );
    }

    @Transactional
    public void processStudentExamResult(String email, String formId, Double score) {
        if (email == null || formId == null) {
            throw new IllegalArgumentException("E-mail e Form ID são obrigatórios.");
        }

        StudyMaterialProgress progress = progressRepository
                .findByStudentEmailIgnoreCaseAndGoogleFormId(email.trim(), formId.trim())
                .orElseThrow(() -> new IllegalArgumentException(
                        String.format("Registro não encontrado para o e-mail [%s] e formulário [%s].", email, formId)
                ));

        // Usa a regra de negócio da própria entidade
        progress.processGrade(score);

        progressRepository.save(progress);
    }
}