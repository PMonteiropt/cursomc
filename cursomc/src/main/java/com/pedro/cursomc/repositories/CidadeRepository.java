package com.pedro.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pedro.cursomc.domain.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

}
