package com.allantiotonho.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allantiotonho.workshopmongo.domain.User;
import com.allantiotonho.workshopmongo.repositories.UserRepository;
import com.allantiotonho.workshopmongo.services.exceptions.ObjectNotFoundException;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public List<User> findAll() {
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
}