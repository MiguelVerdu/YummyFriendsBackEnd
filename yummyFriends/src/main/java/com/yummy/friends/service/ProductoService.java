package com.yummy.friends.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.yummy.friends.domain.Producto;
import com.yummy.friends.repository.ProductoRepository;

@Service
public class ProductoService {

	@Autowired
	public ProductoRepository productoRepository;

	public void create(Producto producto, MultipartFile file) throws IOException {
		if (file != null) {
			String token = UUID.randomUUID().toString();

			File targetFile = new File("C:/Users/migue/Pictures/" + token);

			java.nio.file.Files.copy(file.getInputStream(), targetFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

			IOUtils.closeQuietly(file.getInputStream());

			producto.setFoto(token);
		}

		this.productoRepository.save(producto);

	}

	public String obtenerFoto(Integer id) {
		return this.productoRepository.obtenerFoto(id);
	}

	public List<Producto> findAll() {
		return this.productoRepository.findAll();
	}

	public Integer getMaxId() {
		return this.productoRepository.getMaxId();
	}

	// public String obtenerFotoVenta(Integer idVenta) {
	// return this.productoRepository.obtenerFotoVenta(idVenta);
	// }

}
