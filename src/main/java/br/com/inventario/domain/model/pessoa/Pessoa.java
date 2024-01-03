package br.com.inventario.domain.model.pessoa;

import br.com.inventario.domain.model.endereco.Endereco;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa {
    private String cpf;
    private String nome;
    private Endereco endereco;
}
