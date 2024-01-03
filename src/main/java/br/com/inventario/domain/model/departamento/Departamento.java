package br.com.inventario.domain.model.departamento;

import java.util.List;
import java.util.UUID;


import br.com.inventario.domain.model.bensPermanentes.BensPermanentes;
import br.com.inventario.domain.model.funcionario.Funcionario;
import br.com.inventario.domain.model.sala.Sala;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    @OneToMany
    private List<BensPermanentes> bens;
    @OneToMany
    private List<Funcionario> funcionario;

    
}