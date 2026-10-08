package com.teologia.app.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_attachments")
public class Attachment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title; // Ex: "Apostila Módulo 1", "Slides da Aula 2"

    @Column(nullable = false)
    private String fileUrlOrPath; // URL do Google Drive, AWS S3 ou caminho do arquivo

    private String fileType; // Ex: "PDF", "LINK", "SLIDE"

    private LocalDateTime uploadedAt;

    public Attachment() {
        this.uploadedAt = LocalDateTime.now();
    }

    public Attachment(String title, String fileUrlOrPath, String fileType) {
        this();
        this.title = title;
        this.fileUrlOrPath = fileUrlOrPath;
        this.fileType = fileType;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFileUrlOrPath() {
        return fileUrlOrPath;
    }

    public void setFileUrlOrPath(String fileUrlOrPath) {
        this.fileUrlOrPath = fileUrlOrPath;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public LocalDateTime getUploadedAt() {
        return uploadedAt;
    }

    public void setUploadedAt(LocalDateTime uploadedAt) {
        this.uploadedAt = uploadedAt;
    }
}