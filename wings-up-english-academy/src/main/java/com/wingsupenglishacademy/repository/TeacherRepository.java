package com.wingsupenglishacademy.repository;

import com.wingsupenglishacademy.model.StudentEntity;
import com.wingsupenglishacademy.model.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<TeacherEntity, Long> {
}
