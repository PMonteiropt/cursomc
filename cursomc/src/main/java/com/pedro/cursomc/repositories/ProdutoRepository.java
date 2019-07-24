package com.pedro.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pedro.cursomc.domain.Produto;

														//classe e chave da classe
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

	


}
