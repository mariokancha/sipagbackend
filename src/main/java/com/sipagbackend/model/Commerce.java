package com.sipagbackend.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "COMMERCE")
public class Commerce implements Serializable{

	private static final long serialVersionUID = 1L;

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
	
	@Column(name = "CEP")
	@NotNull
	private String cep;
	
	@Column(name = "LOGRADOURO")
	@NotNull
	private String logradouro;
	
	@Column(name = "BAIRRO")
	@NotNull
	private String bairro;

	@Column(name = "CIDADE")
	@NotNull
	private String cidade;
	
	@Column(name = "UF")
	@NotNull
	private String uf;
	
	@Column(name = "COMPLEMENTO")
	private String complemento;
	
	@Column(name = "FONE_RESIDENCIAL")
	private String foneResidencial;
	
	@Column(name = "FONE_COMERCIAL")
	private String foneComercial;
	
	@Column(name = "FONE_CELULAR")
	@NotNull
	private String foneCelular;
	
	@Column(name = "EMAIL")
	private String email;

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

	public String getFoneResidencial() {
		return foneResidencial;
	}

	public void setFoneResidencial(String foneResidencial) {
		this.foneResidencial = foneResidencial;
	}

	public String getFoneComercial() {
		return foneComercial;
	}

	public void setFoneComercial(String foneComercial) {
		this.foneComercial = foneComercial;
	}

	public String getFoneCelular() {
		return foneCelular;
	}

	public void setFoneCelular(String foneCelular) {
		this.foneCelular = foneCelular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
