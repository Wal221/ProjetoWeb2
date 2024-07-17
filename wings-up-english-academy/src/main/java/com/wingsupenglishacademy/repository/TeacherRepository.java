package com.wingsupenglishacademy.repository;

import com.wingsupenglishacademy.model.ProfessorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<ProfessorEntity, Long> {
}
