package com.felipe.oportunidadeapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.felipe.oportunidadeapi.domain.Oportunidade;

public interface OportunidadeRepository extends JpaRepository<Oportunidade, Long>{
	
	Optional<Oportunidade> findByNomeProspectoAndDescricao(String nomeProspecto, String descricao);
}
