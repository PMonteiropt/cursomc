package com.everis.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.everis.cursomc.domain.Categoria;
import com.everis.cursomc.repositories.CategoriaRepository;
import com.everis.cursomc.services.exceptions.DataIntegrityNotFoundException;
import com.everis.cursomc.services.exceptions.ObjectNotFoundEception;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;

	public Categoria find(Integer id) {

		Optional<Categoria> obj = repo.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundEception(
				"Objecto não encontrado! Id: " + id + ",Tipo:" + Categoria.class.getName()));

	}

	public Categoria insert(Categoria obj) {

		obj.setId(null);
		return repo.save(obj);
	}

	public Categoria update(Categoria obj) { // Igual ao da criacao. Quando recebe nulo insere, quando recebe valor
												// actualiza

		find(obj.getId());
		return repo.save(obj);
	}

	public void delete(Integer id) {

		find(id);

		try {

			repo.deleteById(id);

		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityNotFoundException("Não é possivel excluir uma categoria que contém produtos");
		}

	}
}
