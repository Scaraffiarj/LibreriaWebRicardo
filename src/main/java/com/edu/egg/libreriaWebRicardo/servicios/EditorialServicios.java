package com.edu.egg.libreriaWebRicardo.servicios;

import java.util.Optional;

import javax.transaction.Transactional;

import com.edu.egg.libreriaWebRicardo.entidades.Editorial;
import com.edu.egg.libreriaWebRicardo.repositorios.EditorialRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.edu.egg.errores.ErrorServicio;


@Service
public class EditorialServicios {
	@Autowired
	private EditorialRepositorio editorialrepositorio;
		
		
@Transactional 
public void registrarEditorial(String nombre)throws ErrorServicio{
		  
	  validar(nombre);
	  Editorial editorial = new Editorial();
	  nombre=nombre.toUpperCase();
      editorial.setNombre(nombre);
      editorialrepositorio.save(editorial);       
  }	  
	  

@Transactional 
public void modificarEditorial(String idEditorial, String nombre)throws ErrorServicio{
validar(nombre);
nombre = nombre.toUpperCase();	      
Optional <Editorial> respuesta = editorialrepositorio.findById(idEditorial);
	    
	    if (respuesta.isPresent()){
	    	Editorial editorial = respuesta.get();      
	    	editorial.setNombre(nombre);	    
	    	editorialrepositorio.save(editorial); 
	     }else{
	        throw new ErrorServicio("No se encontro la editorial solicitada");
	    }
	   }
	        

@Transactional 
public void eliminarEditorial(String idEditorial)throws ErrorServicio{
		  
	Editorial respuesta = editorialrepositorio.buscarEditorial(idEditorial);	
		
		if (respuesta!=null) {		
			editorialrepositorio.delete(respuesta);		
		}else {
			throw new ErrorServicio("La editorialno puede ser eliminado ya que tiene Libros Asociados");
		}		
	}
	  
 
	  

public void validar(String nombre) throws ErrorServicio{	    
	      if (nombre==null  || nombre.isEmpty()){       
	         throw new ErrorServicio("El nombre de la editorial no puede ser nulo o vacio");            
	      }
	   }   
		
}
	
	
	
	
	
