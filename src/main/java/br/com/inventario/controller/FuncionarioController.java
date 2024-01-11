package br.com.inventario.controller;


import br.com.inventario.domain.model.funcionario.FuncionarioDto;
import br.com.inventario.domain.model.funcionario.FuncionarioService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.UUID;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    final
    FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @GetMapping
    public ResponseEntity<Page<FuncionarioDto>> getFuncionarios(Pageable pageable){
        var funcionarios = funcionarioService.findAll(pageable);

        return ResponseEntity.ok(funcionarios);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<FuncionarioDto> Save(
            @RequestBody  @Valid FuncionarioDto funcionarioDto,
            UriComponentsBuilder uriBuilder){

        var funcionario = funcionarioService.save(funcionarioDto);
        var uri = uriBuilder.path("/funcionarios/{id}").buildAndExpand(funcionario.getId()).toUri();
        return ResponseEntity.created(uri).body(funcionario);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<FuncionarioDto> update(
            @PathVariable UUID id,
            @RequestBody  @Valid FuncionarioDto funcionarioDto,
            UriComponentsBuilder uriBuilder){

        var funcionario = funcionarioService.update(id,funcionarioDto);

        var uri = uriBuilder.path("/funcionarios/{id}").buildAndExpand(funcionario.getId()).toUri();

        return  ResponseEntity.created(uri).body(funcionario);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void delete (
            @PathVariable UUID id){
        funcionarioService.delete(id);
    }

}
