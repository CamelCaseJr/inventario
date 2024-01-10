package br.com.inventario.domain.model.departamento;

import br.com.inventario.domain.model.funcionario.Funcionario;
import br.com.inventario.domain.model.sala.Sala;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Departamento
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Departamento {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @OneToMany
    private List<Sala> salas;

    private Integer andar;

    @ElementCollection
    private List<String> patrimonio = new ArrayList<>();

    @OneToMany
    private List<Funcionario> funcionarios;

    
}