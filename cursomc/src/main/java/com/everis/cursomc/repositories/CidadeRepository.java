package com.everis.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.everis.cursomc.domain.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

}
