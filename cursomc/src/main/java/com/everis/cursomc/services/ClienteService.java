package com.everis.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.cursomc.domain.Cliente;
import com.everis.cursomc.repositories.ClienteRepository;
import com.everis.cursomc.services.exceptions.ObjectNotFoundEception;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;

	public Cliente buscar(Integer id) {

		Optional<Cliente> obj = repo.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundEception(
				"Objecto não encontrado! Id: " + id + ",Tipo:" + Cliente.class.getName()));

	}

}
