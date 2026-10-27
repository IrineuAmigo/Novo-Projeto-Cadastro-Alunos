package com.alunos.cadastro_alunos.infrastructure.repository;

import com.alunos.cadastro_alunos.infrastructure.entitys.Alunos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface AlunosRepository extends JpaRepository<Alunos, Integer> {

    Optional<Alunos> findByEmail(String email);

    @Transactional
    void deleteByEmail(String email);
}