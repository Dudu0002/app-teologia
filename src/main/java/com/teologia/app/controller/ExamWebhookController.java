package com.teologia.app.controller;

import com.teologia.app.dto.GoogleFormsWebhookPayload;
import com.teologia.app.service.GradeProcessingService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/webhooks")
public class ExamWebhookController {

    private final GradeProcessingService gradeProcessingService;

    public ExamWebhookController(GradeProcessingService gradeProcessingService) {
        this.gradeProcessingService = gradeProcessingService;
    }

    @PostMapping("/google-forms")
    public ResponseEntity<Void> receiveFormGrade(@Valid @RequestBody GoogleFormsWebhookPayload payload) {
        gradeProcessingService.processStudentExamResult(payload);
        return ResponseEntity.ok().build();
    }
}