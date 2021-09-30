package com.teste.wendel.api.bean;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@NamedQuery(name = "selecionaTodos", query = "Select c from Carro c")
@Entity
@Table(name = "carrp")
public class Carro{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	int id;
	
	@Column(name = "modelo", length = 50, nullable = false)
	String modelo;

	@Column(name = "marca", length = 50, nullable = false)
	String marca;

	@Column(name = "descricao", length = 150, nullable = false)
	String descricao;
	
	@Column(name = "ano", nullable = false)
	int ano;

	@Column(name = "vendido", nullable = false)
	boolean vendido;
	
	@Column(name = "criado", nullable = false)
	LocalDate criado;

	@Column(name = "alterado", nullable = false)
	LocalDate alterado;
	
	public Carro(int id, String modelo, String marca, int ano, String descricao, boolean vendido, LocalDate criado,
			LocalDate alterado) {
		super();
		this.id = id;
		this.modelo = modelo;
		this.marca = marca;
		this.ano = ano;
		this.descricao = descricao;
		this.vendido = vendido;
		this.criado = criado;
		this.alterado = alterado;
	}

	public Carro() {
		super();
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isVendido() {
		return vendido;
	}

	public void setVendido(boolean vendido) {
		this.vendido = vendido;
	}

	public LocalDate getCriado() {
		return criado;
	}

	public void setCriado(LocalDate localDate) {
		this.criado = localDate;
	}

	public LocalDate getAlterado() {
		return alterado;
	}

	public void setAlterado(LocalDate alterado) {
		this.alterado = alterado;
	}

	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}
	
	
}