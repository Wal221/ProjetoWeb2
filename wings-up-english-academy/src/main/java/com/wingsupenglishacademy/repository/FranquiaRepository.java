package com.wingsupenglishacademy.repository;

import com.wingsupenglishacademy.model.FranquiaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FranquiaRepository extends JpaRepository<FranquiaEntity, Long> {

}
