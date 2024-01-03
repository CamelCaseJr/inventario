package br.com.inventario.controller;


import br.com.inventario.domain.model.funcionario.FuncionarioDto;
import br.com.inventario.domain.model.funcionario.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    FuncionarioService funcionarioService;



    public ResponseEntity<Page<FuncionarioDto>> getFuncionario(Pageable pageable){
        var funcionarios = funcionarioService.findAll(pageable);

        return ResponseEntity.ok(funcionarios);
    }



}
