package com.teologia.app.service;

import com.teologia.app.dto.CreateClassGroupRequest;
import com.teologia.app.model.ClassGroup;
import com.teologia.app.repository.ClassGroupRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassGroupService {

    private final ClassGroupRepository repository;

    public ClassGroupService(ClassGroupRepository repository) {
        this.repository = repository;
    }

    public ClassGroup createClassGroup(CreateClassGroupRequest request) {
        ClassGroup classGroup = new ClassGroup(request.name(), request.category(), request.description());
        return repository.save(classGroup);
    }

    public List<ClassGroup> findAllActive() {
        return repository.findByActiveTrue();
    }

    public List<String> findDistinctCategories() {
        return repository.findDistinctCategories();
    }
}