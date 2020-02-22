package com.sipagbackend.model;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class CommerceEndereco{

	@NotNull
	private String cep;
	@NotNull
	private String logradouro;
	@NotNull
	private String bairro;
	@NotNull
	private String cidade;
	@NotNull
	private String uf;
	private String complemento;

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	
	
}
