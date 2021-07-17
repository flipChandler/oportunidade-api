package com.felipe.oportunidadeapi.mapper;

import org.springframework.stereotype.Component;

import com.felipe.oportunidadeapi.domain.Oportunidade;
import com.felipe.oportunidadeapi.dto.OportunidadeDTO;

@Component
public class OportunidadeMapper {
	
	public Oportunidade toEntity(OportunidadeDTO dto) {
		Oportunidade entity = new Oportunidade();
		entity.setId(dto.getId());
		entity.setNomeProspecto(dto.getNomeProspecto());
		entity.setDescricao(dto.getDescricao());
		entity.setValor(dto.getValor());
		return entity;		
	}
	
	public OportunidadeDTO toDTO(Oportunidade entity) {
		OportunidadeDTO dto = new OportunidadeDTO();
		dto.setId(entity.getId());
		dto.setNomeProspecto(entity.getNomeProspecto());
		dto.setDescricao(entity.getDescricao());
		dto.setValor(entity.getValor());
		return dto;
	}
	
	
	
}
