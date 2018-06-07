package com.yummy.friends.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yummy.friends.domain.Venta;
import com.yummy.friends.repository.VentaRepository;

@Service
public class VentaService {

	@Autowired
	public VentaRepository ventaRepository;

	public List<Venta> findAll() {
		return this.ventaRepository.ventasHome();
	}

	public void crearVenta(Venta v) {
		this.ventaRepository.save(v);
	}

	public Venta detalleVenta(Integer id) {
		return this.ventaRepository.findVentaById(id);
	}
	
	
}
