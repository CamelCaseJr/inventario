package br.com.inventario.domain.model.endereco;

import java.util.UUID;

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
public class Endereco {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String rua;
    private String cep;
    private String numero;

}
