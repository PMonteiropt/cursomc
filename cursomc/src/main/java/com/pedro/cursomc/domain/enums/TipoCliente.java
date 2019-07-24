package com.pedro.cursomc.domain.enums;

public enum TipoCliente {

	PESSOASFISICA(1, "Pessoa Física"), PESSOAJURIDICA(2, "Pessoa Juridica");

	private int cod;
	private String descricao;

	private TipoCliente(int cod, String descricao) {
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
	public static TipoCliente toEnum(Integer cod) {
		
		if(cod==null) {
			return null;
			
		}
		//Percorre todos os valores possiveis do enum e compara com o valor introduzido
		for(TipoCliente x : TipoCliente.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		//Os valores introduzidos nao correspondem a nenhum valor do enumerados; dispara excepçao padrao do Java
		throw new IllegalArgumentException("Id inválido" +cod);
	}

}
