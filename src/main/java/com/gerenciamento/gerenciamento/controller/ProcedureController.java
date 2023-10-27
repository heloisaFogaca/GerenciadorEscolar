package com.gerenciamento.gerenciamento.controller;

import com.gerenciamento.gerenciamento.Service.BancoDeDados.ProcedureService;
import com.gerenciamento.gerenciamento.model.Boletim;
import com.gerenciamento.gerenciamento.model.DisciplinaMediaDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@AllArgsConstructor
@RequestMapping("/procedure")
public class ProcedureController {

    private final ProcedureService procedureService;

    @GetMapping("/boletim/{id_disciplina}")
    public Collection<DisciplinaMediaDTO> disciplina(@PathVariable Integer id_disciplina){
        return procedureService.callGerarMediaDisciplina(id_disciplina);
    }

}
