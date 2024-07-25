package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.domain.model.Restaurante;

public interface RestauranteService {
	
	public List<Restaurante> findAll();
	
	public Optional<Restaurante> findById(Long id);
	
	public void save(Restaurante restaurante);
	
}
