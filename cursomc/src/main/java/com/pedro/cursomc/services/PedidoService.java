package com.pedro.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedro.cursomc.domain.Pedido;
import com.pedro.cursomc.repositories.PedidoRepository;
import com.pedro.cursomc.services.exceptions.ObjectNotFoundEception;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;

	public Pedido find(Integer id) {

		Optional<Pedido> obj = repo.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundEception(
				"Objecto não encontrado! Id: " + id + ",Tipo:" + Pedido.class.getName()));

	}


}
