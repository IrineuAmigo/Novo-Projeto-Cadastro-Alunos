package com.alunos.cadastro_alunos.infrastuture.repository;

import com.alunos.cadastro_alunos.infrastuture.entitys.Alunos;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface AlunosRepository extends JpaRepository<Alunos, Integer>  {

    Optional<Alunos> findByEmail(String email);

    @Transactional
    void deleteByEmail(String email);

}
