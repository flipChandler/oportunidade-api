package com.felipe.oportunidadeapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.felipe.oportunidadeapi.dto.OportunidadeDTO;
import com.felipe.oportunidadeapi.service.OportunidadeService;


@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping(value = "/oportunidades")
public class OportunidadeController {
	
	@Autowired
	private OportunidadeService service;
	
	@GetMapping
	public ResponseEntity<List<OportunidadeDTO>> listar() {
		return ResponseEntity.ok(service.listar());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<OportunidadeDTO> buscarPorId(@PathVariable Long id) {		
		OportunidadeDTO dto = service.buscarPorId(id);
		return dto == null ? ResponseEntity.notFound().build() : ResponseEntity.ok( dto);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public OportunidadeDTO adicionarOportunidade(@Valid @RequestBody OportunidadeDTO dto) {
		return service.adicionarOportunidade(dto);
	}
	
	@PutMapping("/{id}")	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public OportunidadeDTO atualizar(@PathVariable Long id, @Valid @RequestBody OportunidadeDTO dto) {
        return service.atualizar(id, dto);
    }
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long id) {
		service.deletarById(id);
	}
	
}
