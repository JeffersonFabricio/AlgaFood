package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.demo.domain.exception.EmUsoException;
import com.example.demo.domain.exception.NotFoundException;
import com.example.demo.domain.model.Cozinha;
import com.example.demo.domain.repository.CozinhaRepository;
import com.example.demo.service.CozinhaService;

@Service
public class CozinhaServiceImpl implements CozinhaService {
	
	@Autowired
	private CozinhaRepository cozinhaRepository;

	@Override
	public List<Cozinha> findAll() {
		return cozinhaRepository.findAll();
	}
	
	@Override
	public Cozinha save(Cozinha cozinha) {
		return cozinhaRepository.save(cozinha);
	}

	@Override
	public Optional<Cozinha> findById(Long id) {
		return cozinhaRepository.findById(id);
	}

	@Override
	public void deleteById(Long id) {

		Optional<Cozinha> cozinhaOptional = cozinhaRepository.findById(id);
		try {
			if (cozinhaOptional.isEmpty()){
				throw new EmptyResultDataAccessException(1);
			} else {
				cozinhaRepository.deleteById(id);
			}
		} catch (DataIntegrityViolationException e) {
			throw new EmUsoException(String.format("Cozinha de código %d não pode ser removida, pois está em uso", id));
		} catch (EmptyResultDataAccessException e) {
			throw new NotFoundException(String.format("Cozinha de código %d não foi encontrada", id));
		}
		
	}

}
