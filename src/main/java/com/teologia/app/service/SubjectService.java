package com.teologia.app.service;

import com.teologia.app.dto.AddAttachmentRequest;
import com.teologia.app.dto.CreateSubjectRequest;
import com.teologia.app.model.Attachment;
import com.teologia.app.model.ClassGroup;
import com.teologia.app.model.Subject;
import com.teologia.app.repository.ClassGroupRepository;
import com.teologia.app.repository.SubjectRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SubjectService {

    private final SubjectRepository subjectRepository;
    private final ClassGroupRepository classGroupRepository;

    public SubjectService(SubjectRepository subjectRepository, ClassGroupRepository classGroupRepository) {
        this.subjectRepository = subjectRepository;
        this.classGroupRepository = classGroupRepository;
    }

    @Transactional
    public Subject createSubject(CreateSubjectRequest request) {
        ClassGroup classGroup = classGroupRepository.findById(request.classGroupId())
                .orElseThrow(() -> new IllegalArgumentException("Turma não encontrada."));

        Subject subject = new Subject(request.name(), request.description(), classGroup);
        return subjectRepository.save(subject);
    }

    public List<Subject> findByClassGroup(Long classGroupId) {
        return subjectRepository.findByClassGroupId(classGroupId);
    }

    @Transactional
    public Subject addAttachment(Long subjectId, AddAttachmentRequest request) {
        Subject subject = subjectRepository.findById(subjectId)
                .orElseThrow(() -> new IllegalArgumentException("Disciplina não encontrada."));

        Attachment attachment = new Attachment(request.title(), request.fileUrlOrPath(), request.fileType());
        subject.addAttachment(attachment);

        return subjectRepository.save(subject);
    }
}