package com.felipe.oportunidadeapi.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.felipe.oportunidadeapi.domain.Oportunidade;
import com.felipe.oportunidadeapi.dto.OportunidadeDTO;
import com.felipe.oportunidadeapi.exceptions.BusinessException;
import com.felipe.oportunidadeapi.mapper.OportunidadeMapper;
import com.felipe.oportunidadeapi.repository.OportunidadeRepository;
import com.felipe.oportunidadeapi.util.MessageUtils;

@Service
public class OportunidadeService {
	
	@Autowired
	private OportunidadeRepository repository;
	
	@Autowired
	private OportunidadeMapper mapper;
	
	@Transactional(readOnly = true)
	public List<OportunidadeDTO> listar() {
		List<Oportunidade> oportunidades = repository.findAll();
		
		return oportunidades.stream()
			.map(oportunidade -> mapper.toDTO(oportunidade)).collect(Collectors.toList());
		
//		return oportunidades.stream().map(oportunidade
//				-> new OportunidadeDTO(oportunidade)).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public OportunidadeDTO buscarPorId(Long id) {
		Optional<Oportunidade> optional = repository.findById(id);
		return optional.isPresent() ? mapper.toDTO(optional.get()) : null;		
	}

	@Transactional
	public OportunidadeDTO adicionarOportunidade(OportunidadeDTO dto) {
		Optional<Oportunidade> oportunidadeExistente = repository
				.findByNomeProspectoAndDescricao(dto.getNomeProspecto(), dto.getDescricao());
		if (oportunidadeExistente.isPresent()) {
			throw new BusinessException(MessageUtils.OPORTUNIDADE_ALREADY_EXISTS);
		}
		
		Oportunidade oportunidade = mapper.toEntity(dto);	
		repository.save(oportunidade);
		return mapper.toDTO(oportunidade);
	}

	@Transactional
	public OportunidadeDTO atualizar(Long id, OportunidadeDTO dto) {
		OportunidadeDTO oportunidadeEncontrada = this.buscarPorId(id);
		
		BeanUtils.copyProperties(dto, oportunidadeEncontrada, "id");
		repository.save(mapper.toEntity(oportunidadeEncontrada));
		return oportunidadeEncontrada;		
	}
		
}

