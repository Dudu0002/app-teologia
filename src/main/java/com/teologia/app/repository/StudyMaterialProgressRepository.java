package com.teologia.app.repository;

import com.teologia.app.model.StudyMaterialProgress;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface StudyMaterialProgressRepository extends JpaRepository<StudyMaterialProgress, Long> {
    
    // Ignora maiúsculas e minúsculas no e-mail
    Optional<StudyMaterialProgress> findByStudentEmailIgnoreCaseAndGoogleFormId(String email, String googleFormId);
}