package com.teologia.app.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_study_material_progress")
public class StudyMaterialProgress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String materialTitle; // Ex: "Apostila 1 - Bibliologia"

    private String googleFormId;   // ID do formulário do Google Forms correspondente

    private Double examGrade;      // Nota obtida

    private Double passingGrade;   // Nota mínima para aprovação (ex: 7.0)

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ModuleStatus status = ModuleStatus.PENDING;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    private LocalDateTime completedAt;

    public StudyMaterialProgress() {}

    public StudyMaterialProgress(String materialTitle, String googleFormId, Double passingGrade, Student student) {
        this.materialTitle = materialTitle;
        this.googleFormId = googleFormId;
        this.passingGrade = passingGrade;
        this.student = student;
    }

    // Regra de negócio: Processa a nota do Google Forms e atualiza o status
    public void processGrade(Double grade) {
        this.examGrade = grade;
        if (grade != null && grade >= this.passingGrade) {
            this.status = ModuleStatus.COMPLETED;
            this.completedAt = LocalDateTime.now();
        } else {
            this.status = ModuleStatus.IN_PROGRESS;
        }
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMaterialTitle() {
        return materialTitle;
    }

    public void setMaterialTitle(String materialTitle) {
        this.materialTitle = materialTitle;
    }

    public String getGoogleFormId() {
        return googleFormId;
    }

    public void setGoogleFormId(String googleFormId) {
        this.googleFormId = googleFormId;
    }

    public Double getExamGrade() {
        return examGrade;
    }

    public Double getPassingGrade() {
        return passingGrade;
    }

    public ModuleStatus getStatus() {
        return status;
    }

    public Student getStudent() {
        return student;
    }

    public LocalDateTime getCompletedAt() {
        return completedAt;
    }
}