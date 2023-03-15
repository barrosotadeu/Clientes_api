package br.com.tadeu.clientes_api.domain.cliente;

import br.com.tadeu.clientes_api.domain.endereco.Endereco;

public record DadosListagemCliente(Long id, String nome, String cpf, String telefone, String email, Endereco endereco) {

    public DadosListagemCliente(Cliente cliente){
        this(cliente.getId(), cliente.getNome(), cliente.getCpf(), cliente.getTelefone(), cliente.getEmail(), cliente.getEndereco());
    }
}
