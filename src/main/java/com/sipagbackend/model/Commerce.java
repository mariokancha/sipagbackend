package com.sipagbackend.model;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "COMMERCE")
public class Commerce implements Serializable {

	private static final long serialVersionUID = 1L;

	@Embedded
	@NotNull
	@Valid
	@AttributeOverrides(value = { @AttributeOverride(name = "cep", column = @Column(name = "CEP")), 
			@AttributeOverride(name = "logradouro", column = @Column(name = "LOGRADOURO" )),
			@AttributeOverride(name = "bairro", column = @Column(name = "BAIRRO")),
			@AttributeOverride(name = "cidade", column = @Column(name = "CIDADE" )),
			@AttributeOverride(name = "uf", column = @Column(name = "UF" ))
	})
	private CommerceEndereco endereco;

	@Embedded
	@NotNull
	@Valid
	@AttributeOverrides(value = {
			@AttributeOverride(name = "foneCelular", column = @Column(name = "FONE_CELULAR")),
			@AttributeOverride(name = "foneComercial", column = @Column(name = "FONE_COMERCIAL")),
			@AttributeOverride(name = "foneResidencial", column = @Column(name = "FONE_RESIDENCIAL")),
			@AttributeOverride(name = "email", column = @Column(name = "EMAIL")) })
	private CommerceContato contato;

	@Id
	@Column(name = "IDCOMMERCE")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long idCommerce;

	@Column(name = "NOME")
	@NotNull
	@Size(min = 20, max = 100)
	private String nome;

	@Column(name = "CNPJ")
	@Size(min = 14, max = 14)
	@NotNull
	private String cnpj;

	public Commerce() {

	}

	public long getIdCommerce() {
		return idCommerce;
	}

	public void setIdCommerce(long idCommerce) {
		this.idCommerce = idCommerce;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public CommerceEndereco getEndereco() {
		return endereco;
	}

	public void setEndereco(CommerceEndereco endereco) {
		this.endereco = endereco;
	}

	public CommerceContato getContato() {
		return contato;
	}

	public void setContato(CommerceContato contato) {
		this.contato = contato;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idCommerce ^ (idCommerce >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Commerce other = (Commerce) obj;
		if (idCommerce != other.idCommerce)
			return false;
		return true;
	}

}
