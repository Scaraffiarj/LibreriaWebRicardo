package com.edu.egg.libreriaWebRicardo.controladores;


import com.edu.egg.libreriaWebRicardo.servicios.EditorialServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.edu.egg.errores.ErrorServicio;


@Controller
@RequestMapping(value="/editorial")
public class EditorialControlador {
	@Autowired
	private EditorialServicios editorialservicio;

	@PostMapping("/agregarEditorial")
	public String agregarEditorial(ModelMap modelo, @RequestParam String nombre){
		try {
		 editorialservicio.registrarEditorial(nombre);
		  modelo.put("titulo", "EDITORIAL");
		  modelo.put("descripcion", "Creada de Forma Correcta!");
		return "aviso.html";	
		
		} catch (ErrorServicio ex) {	
		modelo.put("error", ex.getMessage());		
		return "editorial.html";	
		}
	 
	}
		

	
	@PostMapping("/eliminarEditorial")
	public String eliminarAutor(ModelMap modelo, @RequestParam String idEditorial){
	    try {
		editorialservicio.eliminarEditorial(idEditorial);
		 modelo.put("titulo", "EDITORIAL");
		modelo.put("descripcion", "Eliminado de Forma Correcta!");
		return "aviso.html";
		
		} catch (ErrorServicio ex) {	
		modelo.put("error", ex.getMessage());		
		return "editorial.html";	
			} 				
}
	
 @PostMapping("/modificarEditorial")
	 public String modificarEditorial(ModelMap modelo, @RequestParam String idEditorial,
			 @RequestParam String nombre){
	        try {
	    	editorialservicio.modificarEditorial(idEditorial, nombre);
	    	modelo.put("titulo", "EDITORIAL");
	    	modelo.put("descripcion", "Modificada de Forma Correcta!");
	    	return "aviso.html";
	    	} catch (ErrorServicio ex) {	
	    	  modelo.put("error", ex.getMessage());		
	    	  return "editorial.html";	
	    	}   	
 }
	
	
	
}
