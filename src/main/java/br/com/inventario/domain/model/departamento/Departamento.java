package br.com.inventario.domain.model.departamento;

import java.util.UUID;

import br.com.inventario.domain.model.bens.Bens;
import br.com.inventario.domain.model.sala.Sala;
import br.com.inventario.domain.model.funcionario.Funcionario;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    private Sala sala;
    private Integer andar;
    private Bens bens;
    private Funcionario funcionario;

    
}