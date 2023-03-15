package br.com.tadeu.clientes_api.domain.cliente;

import br.com.tadeu.clientes_api.domain.endereco.DadosEndereco;
import br.com.tadeu.clientes_api.domain.endereco.Endereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroCliente(
        @NotBlank
        String nome,
        @NotBlank
        @Pattern(regexp = "\\d{11}")
        String cpf,
        @NotBlank
        String telefone,
        @NotBlank
        @Email
        String email,

        @Valid
        @NotNull
        DadosEndereco endereco) {
}
