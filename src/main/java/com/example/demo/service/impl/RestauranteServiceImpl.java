package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.model.Restaurante;
import com.example.demo.domain.repository.RestauranteRepository;
import com.example.demo.service.RestauranteService;

@Service
public class RestauranteServiceImpl implements RestauranteService {
	
	@Autowired
	private RestauranteRepository restauranteRepository;

	@Override
	public List<Restaurante> findAll() {
		return restauranteRepository.findAll();
	}
	
	@Override
	public Optional<Restaurante> findById(Long id) {
		return restauranteRepository.findById(id);
	}
	
	@Override
	public void save(Restaurante restaurante) {
		restauranteRepository.save(restaurante);
	}
	
}
