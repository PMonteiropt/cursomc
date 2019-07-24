package com.pedro.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.pedro.cursomc.domain.Categoria;
import com.pedro.cursomc.repositories.CategoriaRepository;
import com.pedro.cursomc.services.exceptions.DataIntegrityNotFoundException;
import com.pedro.cursomc.services.exceptions.ObjectNotFoundEception;

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
	
	public List<Categoria> findAll() {
		return repo.findAll();
	}

	
	//Método responsável pela paginação dos registos de forma a não sobrecarregar o sistema
	public Page<Categoria> findPage(Integer page, Integer linesPerPage,String orderBy,String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage,Direction.valueOf(direction), orderBy);
		
		return repo.findAll(pageRequest);
	
	}
}
