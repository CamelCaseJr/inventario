package br.com.inventario.domain.model.sala;

import br.com.inventario.domain.model.departamento.Departamento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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

    @OneToMany
    private List<Departamento> departamento;

    @ElementCollection
    private List<String> patrimonio = new ArrayList<>();
}
