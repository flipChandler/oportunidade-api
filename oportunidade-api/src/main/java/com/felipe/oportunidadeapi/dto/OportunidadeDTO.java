package com.felipe.oportunidadeapi.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.felipe.oportunidadeapi.domain.Oportunidade;

public class OportunidadeDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	@NotNull
	@Size(max = 80)
	private String nomeProspecto;
	
	@NotNull
	@Size(max = 200)
	private String descricao;
	
	@Min(0)
	private BigDecimal valor;
	
	public OportunidadeDTO() {
		
	}
	
	public OportunidadeDTO(Oportunidade entity) {
		setId(entity.getId());
		setNomeProspecto(entity.getNomeProspecto());
		setDescricao(entity.getDescricao());
		setValor(entity.getValor());
	}	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomeProspecto() {
		return nomeProspecto;
	}
	public void setNomeProspecto(String nomeProspecto) {
		this.nomeProspecto = nomeProspecto;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}	
}
