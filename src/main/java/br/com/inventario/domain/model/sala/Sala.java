package br.com.inventario.domain.model.sala;

import java.util.UUID;

import br.com.inventario.domain.model.bens.Bens;
import br.com.inventario.domain.model.departamento.Departamento;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sala {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String nome;
    private Integer andar;
    private Departamento departamento;
    private Bens bens;
}
