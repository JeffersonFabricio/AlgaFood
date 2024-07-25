package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.model.Restaurante;
import com.example.demo.service.RestauranteService;

@RestController
@RequestMapping(value = "/restaurantes")
public class RestauranteController {

	@Autowired
	private RestauranteService restauranteService;

	@GetMapping
	public List<Restaurante> findAll() {
		return restauranteService.findAll();
	}

	@GetMapping(value = "/{restauranteId}")
	public ResponseEntity<Restaurante> findById(@PathVariable("restauranteId") Long id) {
		Optional<Restaurante> restaurante = restauranteService.findById(id);
		return restaurante.map(rest -> ResponseEntity.status(HttpStatus.OK).body(rest))
				.orElseGet(() -> ResponseEntity.notFound().build());
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void save(@RequestBody Restaurante restaurante) {
		restauranteService.save(restaurante);
	}
	
	@PutMapping("/{restauranteId}")
	public ResponseEntity<Restaurante> update(@PathVariable Long restauranteId, @RequestBody Restaurante restaurante) {
		Optional<Restaurante> restauranteOptional = restauranteService.findById(restauranteId);
		if (restauranteOptional.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			Restaurante restauranteBase = restauranteOptional.get();
			BeanUtils.copyProperties(restaurante, restauranteBase, "id");
			restauranteService.save(restauranteBase);
			return ResponseEntity.status(HttpStatus.OK).body(restauranteBase);
		}
		
	}
}
