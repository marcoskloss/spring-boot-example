package com.webservice.spring.service;

import com.webservice.spring.domain.Produto;
import com.webservice.spring.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {


    @Autowired // faz a injeção da dependencia
    private ProdutoRepository repository;

    public List<Produto> listarProdutos() {
        return (List<Produto>) repository.findAll();
    }

    public Produto salvar(Produto produto) {
        return repository.save(produto);
    }

    public Optional<Produto> getById(String sku) {
        return repository.findById(sku);
    }

    public void delete(String sku) {
        repository.deleteById(sku);
    }
}
