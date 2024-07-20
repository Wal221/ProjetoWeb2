package com.wingsupenglishacademy.repository;

import com.wingsupenglishacademy.model.TurmaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurmaRepository extends JpaRepository<TurmaEntity,Long> {
}
