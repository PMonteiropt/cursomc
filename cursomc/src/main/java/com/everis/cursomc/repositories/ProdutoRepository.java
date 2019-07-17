package com.everis.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.everis.cursomc.domain.Produto;

														//classe e chave da classe
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

	


}
