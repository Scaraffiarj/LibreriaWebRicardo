package com.edu.egg.libreriaWebRicardo.servicios;


import java.util.Optional;

import javax.transaction.Transactional;

import com.edu.egg.libreriaWebRicardo.entidades.Autor;
import com.edu.egg.libreriaWebRicardo.repositorios.AutorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.egg.errores.ErrorServicio;

@Service
public class AutorServicios {


	@Autowired
	private AutorRepositorio autorrepositorio;

	@Transactional
	public void registrarAutor(String nombre)throws ErrorServicio {
		
		validar(nombre);		
		nombre = nombre.toUpperCase();

		Autor autornvo = new Autor();
		autornvo.setNombre(nombre);	
		autorrepositorio.save(autornvo);
		
	}


	@Transactional
	public void modificarAutor(String idAutor, String nombre) throws ErrorServicio {
		validar(nombre);
		nombre = nombre.toUpperCase();
		Optional<Autor> respuesta = autorrepositorio.findById(idAutor);
		
		if(respuesta.isPresent()) {
			Autor autor = respuesta.get();
			autor.setNombre(nombre);
			autorrepositorio.save(autor);			
		} else {
		throw new ErrorServicio("No se encontro el autor solicitado");
		}
		
			
		
	}

	
	@Transactional
	public void eliminarAutor(String idAutor) throws ErrorServicio {
		
		Autor respuesta = autorrepositorio.buscarAutor(idAutor);	
		
		if (respuesta!=null) {		
			autorrepositorio.delete(respuesta);		
		}else {
			throw new ErrorServicio("El autor no puede ser eliminado ya que tiene Libros Asociados");
		}
		
	}
	
	
	public void validar(String nombre) throws ErrorServicio {
		if (nombre == null || nombre.isEmpty()) {
			throw new ErrorServicio("El nombre del autor no puede ser nulo o vacio");
		}
	}


	
}
