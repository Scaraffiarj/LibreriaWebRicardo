package com.edu.egg.libreriaWebRicardo.servicios;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.edu.egg.libreriaWebRicardo.repositorios.ClienteRepositorio;
import com.edu.egg.libreriaWebRicardo.repositorios.LibroRepositorio;
import com.edu.egg.libreriaWebRicardo.repositorios.PrestamoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.edu.egg.errores.ErrorServicio;





@Service
public class PrestamoServicios {

	@Autowired
	private PrestamoRepositorio prestamorepositorio;
	@Autowired
	private ClienteRepositorio clienterepositorio;
	@Autowired
	private LibroRepositorio librorepositorio;
	
//	@Transactional 
//	public void archivarPrestamo(Long documento,List<Long>isbnLibros) {
//		
//		String idcliente = clienterepositorio.buscarPorDocumento(documento).getId();		
//		Cliente cliente = clienterepositorio.getOne(idcliente);		
//		
//		Prestamo prestamo = new Prestamo();
//		
//		prestamo.setCliente(cliente);
//		prestamo.setFecha(new Date());
//		prestamo.setDevolucion(null);
//		prestamo.setMulta(0);
//		
//		 for (Long isbn : isbnLibros) {
//			 	librorepositorio.buscarporIsbn(isbn);
//			 	String idlibro = librorepositorio.buscarporIsbn(isbn).getId();
//	            Libro libro = librorepositorio.getOne(idlibro);
//	            libro.setPrestados(1);	            
//	            prestamo.addLibros(libro);
//	      }		
//		
//	prestamorepositorio.save(prestamo);	 
//	}
//	
//	
//	@Transactional 
//	public void devolucionLibroPrestamo(String idcliente) {				
//		
//	}
//	
//	
//	
//public void modificarPrestamo(Date fecha, Date devolucion, String idPrestamo, long multa, long idCliente, long idLibro)
//				throws ErrorServicio {
//
//	Optional<Prestamo> respuesta = prestamorepositorio.findById(idPrestamo);
//
//			if (respuesta.isPresent()) {
//				Prestamo prestamo = respuesta.get();
//				Optional<Libro> respuesta1 = librorepositorio.findById(idLibro);
//				if (respuesta1.isPresent()) {
//					Libro libro = respuesta1.get();
//					prestamo.set(libro);
//				} else {
//					throw new ErrorServicio("el libro no existe");
//
//				}
//
//				Optional<Cliente> respuesta2 = clienteRepositorio.findById(idCliente);
//				if (respuesta2.isPresent()) {
//					Cliente cliente = respuesta2.get();
//					prestamo.setCliente(cliente);
//				} else {
//					throw new ErrorServicio("el cliente no existe");
//				}
//
//				// validar(){}
//
//				prestamo.setDevolucion(devolucion);
//				prestamo.setMulta(multa);
//
//				prestamorepositorio.save(prestamo);
//
//			} else {
//				throw new ErrorServicio("El prestamo no ha sido encontrado");
//			}
//
//		}
//	
//		
//
//	public void devolucion(Date devolucion, String idPrestamo) throws ErrorServicio {
//		Optional<Prestamo> respuesta = prestamorepositorio.findById(idPrestamo);
//		if (respuesta.isPresent()) {
//			Prestamo prestamo = respuesta.get();
//			if (prestamo.getDevolucion() == null) {
//				prestamo.setDevolucion(new Date());
//				prestamorepositorio.save(prestamo);
//			} else {
//				throw new ErrorServicio("el libro ya ha sido devuelto");
//			}
//
//		} else {
//			throw new ErrorServicio("el prestamo no existe");
//		}
//
//	}
//
//			
//
//
//	public Prestamo consultar (String id) {
//		return prestamorepositorio.buscarPrestamoporId(id);
//	}
//	
//	
//	public void eliminar(String idPrestamo) throws ErrorServicio {
//
//		Optional<Prestamo> respuesta = prestamorepositorio.findById(idPrestamo);
//		if (respuesta.isPresent()) {
//			prestamorepositorio.deleteById(idPrestamo);
//
//		} else {
//			throw new ErrorServicio("el prestamo no existe");
//		}
//
//	}
//
//	
///*	public long multar(long multa, String idPrestamo){
//		Optional<Prestamo> respuesta = prestamoRepositorio.findById(idPrestamo);
//		if (respuesta.isPresent()) {
//			Prestamo prestamo = respuesta.get();
//		prestamo.setMulta(multa);	
//		}return multa;	
//	} */
//
//	
//	
//	public void validar(Date fecha, Date devolucion, double multa)
//			throws ErrorServicio {
//
//		if (fecha == null) {
//			throw new ErrorServicio("La fecha no puede estar vacio ni nulo");
//		}
//
}
