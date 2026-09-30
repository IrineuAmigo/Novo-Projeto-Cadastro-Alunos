package com.alunos.cadastro_alunos.controller;

import com.alunos.cadastro_alunos.business.AlunosService;
import com.alunos.cadastro_alunos.infrastuture.entitys.Alunos;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alunos")
@RequiredArgsConstructor
public class AlunosController {

    private final AlunosService alunosService;

    @PostMapping
    public ResponseEntity<Void> salvarAlunos(@RequestBody Alunos alunos) {
        alunosService.salvarAlunos(alunos);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Alunos> buscarAlunosPorEmail(@RequestParam String email) {
        return ResponseEntity.ok(alunosService.buscarAlunosPorEmail(email));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarAlunosPorEmail(@RequestParam String email) {
        alunosService.deletarAlunosPorEmail(email);
        return ResponseEntity.ok().build();
    }
    @PutMapping
    public  ResponseEntity<Void> atualizarAlunosPorId(@RequestParam Integer id, 
                                                        @RequestBody Alunos alunos) {
        alunosService.atualizarAlunosPorId(id, alunos);
        return ResponseEntity.ok().build();
    }

}