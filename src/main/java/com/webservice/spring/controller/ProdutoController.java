package com.webservice.spring.controller;

import com.webservice.spring.domain.Produto;
import com.webservice.spring.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @GetMapping
    public ResponseEntity<List<Produto>> listar() {
        return ResponseEntity.ok(service.listarProdutos());
    }

    @GetMapping("/{sku}")
    public ResponseEntity<Produto> produtoPorId(@PathVariable  String sku) {
        Optional<Produto> optProduto = service.getById(sku);

        if (optProduto.isPresent()) {
            return ResponseEntity.ok(optProduto.get());
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Produto> salvar(@RequestBody  Produto produto) {
        Produto produtoSalvo = service.salvar(produto);
        return new ResponseEntity<>(produtoSalvo, HttpStatus.CREATED);
    }

    @DeleteMapping("/{sku}")
    public ResponseEntity deletar(@PathVariable  String sku) {
        service.delete(sku);
        return ResponseEntity.noContent().build();
    }

    @PutMapping()
    public ResponseEntity<Produto> update(@RequestBody Produto produto) {
        return ResponseEntity.ok(service.salvar(produto));
    }
}
