package com.alunos.cadastro_alunos.business;

import com.alunos.cadastro_alunos.infrastuture.entitys.Alunos;
import com.alunos.cadastro_alunos.infrastuture.repository.AlunosRepository;
import org.springframework.stereotype.Service;

@Service

public class AlunosService {

    private final AlunosRepository repository;

    public AlunosService(AlunosRepository repository) {
        this.repository = repository;
    }

    public void salvarAlunos(Alunos alunos) {
        repository.saveAndFlush(alunos);
    }

    public Alunos buscarAlunosPorEmail(String email) {

        return repository.findByEmail(email).orElseThrow(
                () -> new RuntimeException("Email não encontrado")
        );

    }

    public void deletarAlunosPorEmail(String email) {
        repository.deleteByEmail(email);
    }

    public void atualizarAlunosPorId(Integer id, Alunos alunos){
        Alunos alunosEntity = repository.findById(id).orElseThrow(() ->
            new RuntimeException("Aluno não encontrado"));

        Alunos alunosAtualizado = Alunos.builder()
                .email(alunos.getEmail() != null ? alunos.getEmail() :
                        alunosEntity.getEmail())
                .nome(alunos.getNome() != null ? alunos.getNome() :
                        alunosEntity.getNome())
                .id(alunosEntity.getId())
                .build();

        repository.saveAndFlush(alunosAtualizado);


    }

}
