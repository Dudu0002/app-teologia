package com.teologia.app.controller;

import com.teologia.app.dto.AddAttachmentRequest;
import com.teologia.app.dto.CreateSubjectRequest;
import com.teologia.app.model.Subject;
import com.teologia.app.service.SubjectService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/subjects")
public class SubjectController {

    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @PostMapping
    public ResponseEntity<Subject> createSubject(@Valid @RequestBody CreateSubjectRequest request) {
        Subject created = subjectService.createSubject(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping("/class-group/{classGroupId}")
    public ResponseEntity<List<Subject>> getSubjectsByClassGroup(@PathVariable Long classGroupId) {
        return ResponseEntity.ok(subjectService.findByClassGroup(classGroupId));
    }

    @PostMapping("/{subjectId}/attachments")
    public ResponseEntity<Subject> addAttachment(
            @PathVariable Long subjectId,
            @Valid @RequestBody AddAttachmentRequest request) {
        Subject updatedSubject = subjectService.addAttachment(subjectId, request);
        return ResponseEntity.ok(updatedSubject);
    }
}