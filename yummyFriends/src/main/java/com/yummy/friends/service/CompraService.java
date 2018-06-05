package com.yummy.friends.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yummy.friends.repository.CompraRepository;

@Service
public class CompraService {

	@Autowired
	public CompraRepository compraRepository;
	
	public List<String> obtComentarios(Integer idUsuario){
	
		return this.compraRepository.obtComentarios(idUsuario).subList(0, 2);
	}
}
