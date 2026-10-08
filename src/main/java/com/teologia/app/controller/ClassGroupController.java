package com.teologia.app.controller;

import com.teologia.app.dto.CreateClassGroupRequest;
import com.teologia.app.model.ClassGroup;
import com.teologia.app.service.ClassGroupService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/class-groups")
public class ClassGroupController {

    private final ClassGroupService service;

    public ClassGroupController(ClassGroupService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ClassGroup> createClassGroup(@Valid @RequestBody CreateClassGroupRequest request) {
        ClassGroup created = service.createClassGroup(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping
    public ResponseEntity<List<ClassGroup>> getAllClassGroups() {
        return ResponseEntity.ok(service.findAllActive());
    }

    @GetMapping("/categories")
    public ResponseEntity<List<String>> getExistingCategories() {
        return ResponseEntity.ok(service.findDistinctCategories());
    }
}