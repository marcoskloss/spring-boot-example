package com.webservice.spring.repository;

import com.webservice.spring.domain.Produto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// CrudRepository<model, id type>
@Repository
public interface ProdutoRepository extends CrudRepository<Produto, String> {
}
