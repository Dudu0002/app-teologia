package com.teologia.app.repository;

import com.teologia.app.model.ClassGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassGroupRepository extends JpaRepository<ClassGroup, Long> {

    List<ClassGroup> findByActiveTrue();

    @Query("SELECT DISTINCT c.category FROM ClassGroup c WHERE c.active = true")
    List<String> findDistinctCategories();
}