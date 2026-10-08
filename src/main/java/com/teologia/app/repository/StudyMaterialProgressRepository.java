package com.teologia.app.repository;

import com.teologia.app.model.StudyMaterialProgress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudyMaterialProgressRepository extends JpaRepository<StudyMaterialProgress, Long> {

    List<StudyMaterialProgress> findByStudentId(Long studentId);

    Optional<StudyMaterialProgress> findByStudentEmailAndGoogleFormId(String email, String googleFormId);
}