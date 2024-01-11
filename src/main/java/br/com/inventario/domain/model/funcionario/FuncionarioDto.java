package br.com.inventario.domain.model.funcionario;

import br.com.inventario.domain.model.endereco.Endereco;
import br.com.inventario.domain.model.pessoa.Pessoa;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;

@Data
public class FuncionarioDto {

    @NotBlank
    private String cpf;
    @NotBlank

    private String nome;
    @NotBlank

    private Endereco endereco;
    @NotBlank
    private UUID id;

    @NotNull
    private Boolean isGerente;

}
