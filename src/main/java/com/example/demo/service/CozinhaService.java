package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.domain.model.Cozinha;

public interface CozinhaService {
	
	public List<Cozinha> findAll();
			
	public Cozinha save(Cozinha cozinha);
	
	public Optional<Cozinha> findById(Long id);
	
	public void deleteById(Long id);

}
