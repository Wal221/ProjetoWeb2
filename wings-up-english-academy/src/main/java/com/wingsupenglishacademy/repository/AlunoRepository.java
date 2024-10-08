package com.wingsupenglishacademy.repository;

import com.wingsupenglishacademy.DTO.responses.ResponseAvaliacaDTO;
import com.wingsupenglishacademy.model.AlunoEntity;
import com.wingsupenglishacademy.model.Enum.StatusAvalicao;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlunoRepository extends JpaRepository<AlunoEntity, Long> {

    @Modifying
    @Transactional
    @Query(value = "UPDATE students_avaliacao SET status = :status WHERE AlunoEntity_id = :alunoId AND Avaliacao_id = :avaliacaoId", nativeQuery = true)
    void updateStatus(@Param("alunoId") Long alunoId, @Param("avaliacaoId") Long avaliacaoId, @Param("status") StatusAvalicao status);


    @Query(value = "SELECT * FROM students_avaliacao WHERE AlunoEntity_id = :alunoId", nativeQuery = true)
    List<ResponseAvaliacaDTO> findAllByAlunoId(@Param("alunoId") Long alunoId);

}
