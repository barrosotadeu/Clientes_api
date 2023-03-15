package br.com.tadeu.clientes_api.domain.cliente;

import br.com.tadeu.clientes_api.domain.endereco.Endereco;

public record DadosDetalhamentoCliente(Long id, String nome, String cpf, String telefone, String email, Endereco enderco) {

    public DadosDetalhamentoCliente(Cliente cliente){
        this(cliente.getId(), cliente.getNome(), cliente.getCpf(), cliente.getTelefone(), cliente.getEmail(), cliente.getEndereco());
    }
}
