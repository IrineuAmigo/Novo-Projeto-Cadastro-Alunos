package com.alunos.cadastro_alunos.business;

import com.alunos.cadastro_alunos.infrastructure.entitys.Alunos;
import com.alunos.cadastro_alunos.infrastructure.repository.AlunosRepository;
import org.springframework.stereotype.Service;

@Service
public class AlunosService {

    private final AlunosRepository repository;

    public AlunosService(AlunosRepository repository) {
        this.repository = repository;
    }

    public Alunos salvarAlunos(Alunos alunos) {
        return repository.saveAndFlush(alunos);
    }

    public Alunos buscarAlunosPorEmail(String email) {
        return repository.findByEmail(email).orElseThrow(
                () -> new RuntimeException("Email não encontrado: " + email)
        );
    }

    public void deletarAlunosPorEmail(String email) {
        repository.deleteByEmail(email);
    }

    public Alunos atualizarAlunosPorId(Integer id, Alunos alunos) {
        Alunos alunosEntity = repository.findById(id).orElseThrow(
                () -> new RuntimeException("Aluno não encontrado com o ID: " + id)
        );

        alunosEntity.setEmail(alunos.getEmail() != null ? alunos.getEmail() : alunosEntity.getEmail());
        alunosEntity.setNome(alunos.getNome() != null ? alunos.getNome() : alunosEntity.getNome());

        return repository.saveAndFlush(alunosEntity);
    }
}