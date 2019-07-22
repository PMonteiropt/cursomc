package com.everis.cursomc.domain.enums;

public enum EstadoPagamento {

	PEDENTE(1, "Pendente"),
	QUITADO(2,"Cancelado"),
	CANCELADO(3,"Cancelado");

	private int cod;
	private String descricao;
	
	private EstadoPagamento(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	//Método devolve um Tipo de Cliente a partir de um código
	public static EstadoPagamento toEnum(Integer cod) {
		
		if(cod==null) {
			return null;
			
		}
		//Percorre todos os valores possiveis do enum e compara com o valor introduzido
		for(EstadoPagamento x : EstadoPagamento.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		//Os valores introduzidos nao correspondem a nenhum valor do enumerados; dispara excepçao padrao do Java
		throw new IllegalArgumentException("Id inválido" +cod);
	}

}
