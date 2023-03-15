package br.com.tadeu.clientes_api.controller;

import br.com.tadeu.clientes_api.domain.cliente.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("/clientes")
public class Controller {

    @Autowired
    private ClienteRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@Valid @RequestBody DadosCadastroCliente dados, UriComponentsBuilder uriBuilder){


        var cliente = new Cliente(dados);
        this.repository.save(cliente);

        var uri = uriBuilder.path("/clientes/{id}").buildAndExpand(cliente.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoCliente(cliente));


    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id){
        var cliente = repository.findById(id).get();

        System.out.println(cliente);

        return ResponseEntity.ok(new DadosDetalhamentoCliente(cliente));
    }


    @GetMapping
    public ResponseEntity<Page<DadosListagemCliente>> listar(@PageableDefault Pageable paginacao){
        var page = this.repository.findAll(paginacao).map(DadosListagemCliente::new);

        return ResponseEntity.ok(page);
    }
}
