package com.wingsupenglishacademy.repository;

import com.wingsupenglishacademy.model.ClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRepository extends JpaRepository<ClassEntity,Long> {

}
