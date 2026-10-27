package com.alunos.cadastro_alunos.controller;

import com.alunos.cadastro_alunos.business.AlunosService;
import com.alunos.cadastro_alunos.infrastructure.entitys.Alunos;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alunos")
public class AlunosController {

    private final AlunosService alunosService;

    public AlunosController(AlunosService alunosService) {
        this.alunosService = alunosService;
    }

    @PostMapping
    public ResponseEntity<Alunos> salvarAlunos(@RequestBody Alunos alunos) {
        Alunos novoAluno = alunosService.salvarAlunos(alunos);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoAluno);
    }

    @GetMapping
    public ResponseEntity<Alunos> buscarAlunosPorEmail(@RequestParam String email) {
        return ResponseEntity.ok(alunosService.buscarAlunosPorEmail(email));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarAlunosPorEmail(@RequestParam String email) {
        alunosService.deletarAlunosPorEmail(email);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<Alunos> atualizarAlunosPorId(@RequestParam Integer id,
                                                       @RequestBody Alunos alunos) {
        Alunos alunoAtualizado = alunosService.atualizarAlunosPorId(id, alunos);
        return ResponseEntity.ok(alunoAtualizado);
    }
}