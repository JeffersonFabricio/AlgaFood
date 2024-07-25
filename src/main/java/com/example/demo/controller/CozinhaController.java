package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.exception.EmUsoException;
import com.example.demo.domain.exception.NotFoundException;
import com.example.demo.domain.model.Cozinha;
import com.example.demo.service.CozinhaService;

@RestController
@RequestMapping(value = "/cozinhas")
public class CozinhaController {

	@Autowired
	private CozinhaService cozinhaService;
	
	public ResponseEntity<Cozinha> findById(Long id){
		Optional<Cozinha> cozinhaOptional = cozinhaService.findById(id);
		return cozinhaOptional.map(rest -> ResponseEntity.status(HttpStatus.OK).body(rest))
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

	@GetMapping
	public List<Cozinha> findAll() {
		return cozinhaService.findAll();
	}
	
	@PostMapping
	public Cozinha save(@RequestBody String nome) {
		Cozinha cozinha = new Cozinha();
		cozinha.setNome(nome);
		return cozinhaService.save(cozinha);
	}
	
	@DeleteMapping(value = "/{cozinhaId}")
	public ResponseEntity<Cozinha> delete(@PathVariable Long cozinhaId){
		
		try {
			cozinhaService.deleteById(cozinhaId);
			return ResponseEntity.noContent().build();
			
		} catch (EmUsoException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
			
		} catch (NotFoundException e) {
			return ResponseEntity.notFound().build();
		}

	}

}
