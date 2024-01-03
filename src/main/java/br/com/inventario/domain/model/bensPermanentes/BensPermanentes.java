package br.com.inventario.domain.model.bensPermanentes;

import java.util.UUID;

import br.com.inventario.domain.model.enus.Situacao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(schema = "TB-bens-permanentes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BensPermanentes {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String tombamento;
    private String nome;
    private String descricao;
    private Situacao situacao;
}
