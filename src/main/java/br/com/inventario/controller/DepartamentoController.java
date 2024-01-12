package br.com.inventario.controller;


import br.com.inventario.domain.model.departamento.DepartamentoDto;
import br.com.inventario.domain.model.departamento.DepartamentoService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.UUID;

@RestController
@RequestMapping("/departamentos")
public class DepartamentoController {

    final
    DepartamentoService departamentoService;

    public DepartamentoController(DepartamentoService departamentoService) {
        this.departamentoService = departamentoService;
    }

    @GetMapping
    public ResponseEntity<Page<DepartamentoDto>> getDepartamentos(Pageable pageable) {
        var departamentos = departamentoService.findAll(pageable);
        return ResponseEntity.ok(departamentos);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DepartamentoDto> save(
            @RequestBody @Valid DepartamentoDto departamentoDto,
            UriComponentsBuilder uriBuilder) {

        var departamento = departamentoService.save(departamentoDto);
        var uri = uriBuilder.path("/departamentos/{id}").buildAndExpand(departamento.getId()).toUri();
        return ResponseEntity.created(uri).body(departamento);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DepartamentoDto> update(
            @PathVariable UUID id,
            @RequestBody @Valid DepartamentoDto departamentoDto,
            UriComponentsBuilder uriBuilder) {

        var departamento = departamentoService.update(id, departamentoDto);
        var uri = uriBuilder.path("/departamentos/{id}").buildAndExpand(departamento.getId()).toUri();
        return ResponseEntity.created(uri).body(departamento);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void delete(
            @PathVariable UUID id) {
        departamentoService.delete(id);
    }
}
