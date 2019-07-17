package com.everis.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.cursomc.domain.Categoria;
import com.everis.cursomc.repositories.CategoriaRepository;
import com.everis.cursomc.services.exceptions.ObjectNotFoundEception;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;

	public Categoria buscar(Integer id) {

		Optional<Categoria> obj = repo.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundEception(
				"Objecto não encontrado! Id: " + id + ",Tipo:" + Categoria.class.getName()));

	}

}
