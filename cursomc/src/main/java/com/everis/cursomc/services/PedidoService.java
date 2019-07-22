package com.everis.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.cursomc.domain.Pedido;
import com.everis.cursomc.repositories.PedidoRepository;
import com.everis.cursomc.services.exceptions.ObjectNotFoundEception;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;

	public Pedido buscar(Integer id) {

		Optional<Pedido> obj = repo.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundEception(
				"Objecto não encontrado! Id: " + id + ",Tipo:" + Pedido.class.getName()));

	}

}
