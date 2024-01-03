package br.com.inventatio.controller;


import br.com.inventario.domain.model.funcionario.FuncionarioDto;
import br.com.inventario.domain.model.funcionario.FuncionarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    FuncionarioService funcionarioService;



    public ResponseEntity<List<FuncionarioDto>> getFuncionario(){
        var funcionarios = funcionarioService.findAll();

        return ResponseEntity.ok(funcionarios);
    }
    
}
