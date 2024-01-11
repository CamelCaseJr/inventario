package br.com.inventario.domain.model.departamento;

import br.com.inventario.domain.model.funcionario.Funcionario;
import br.com.inventario.domain.model.sala.Sala;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class DepartamentoDto {
    @NonNull
    @NotBlank
    private UUID id;

    @NotBlank
    @NotNull
    private List<Sala> salas;

    @NotBlank
    private Integer andar;

    @NotBlank
    private List<String> patrimonio = new ArrayList<>();
    @NotBlank
    private List<Funcionario> funcionarios;
}
