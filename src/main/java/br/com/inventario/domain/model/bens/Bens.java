package br.com.inventario.domain.model.bens;

import java.util.UUID;

import br.com.inventario.domain.model.enus.Situacao;
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
public class Bens {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String tombamento;
    private String nome;
    private String descricao;
    private Situacao situacao;
}
