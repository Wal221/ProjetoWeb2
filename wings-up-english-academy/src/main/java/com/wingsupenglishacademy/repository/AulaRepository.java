package com.wingsupenglishacademy.repository;

import com.wingsupenglishacademy.model.AulaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AulaRepository extends JpaRepository<AulaEntity, Long> {
}
