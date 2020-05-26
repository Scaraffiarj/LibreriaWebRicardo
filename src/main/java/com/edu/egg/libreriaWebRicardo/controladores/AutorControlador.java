package com.edu.egg.libreriaWebRicardo.controladores;



import com.edu.egg.libreriaWebRicardo.servicios.AutorServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.edu.egg.errores.ErrorServicio;



@Controller
@RequestMapping(value="/autor")

public class AutorControlador {
	@Autowired
	private AutorServicios autorservicio;
		
@PostMapping("/agregarAutor")
public String agregarAutor(ModelMap modelo, @RequestParam String nombre){
	try {
	autorservicio.registrarAutor(nombre);
	modelo.put("titulo", "AUTOR");
	modelo.put("descripcion", "Creado de Forma Correcta!");
	return "aviso.html";	
				
	} catch (ErrorServicio ex) {
	modelo.put("error", ex.getMessage());		
	return "autor.html";	
		}				
}
			
@PostMapping("/eliminarAutor")
public String eliminarAutor(ModelMap modelo, @RequestParam String idAutor){
    try {
	autorservicio.eliminarAutor(idAutor);	
	  modelo.put("titulo", "AUTOR");
	  modelo.put("descripcion", "Eliminado de Forma Correcta!");
	  return "aviso.html";
	} catch (ErrorServicio ex) {	
	  modelo.put("error", ex.getMessage());		
	  return "autor.html";	
}
}    
    
 @PostMapping("/modificarAutor")
 public String modificarAutor(ModelMap modelo, @RequestParam String idAutor,
		 @RequestParam String nombre){
        try {
    	autorservicio.modificarAutor(idAutor, nombre);
    	modelo.put("titulo", "AUTOR");
    	modelo.put("descripcion", "Modificado de Forma Correcta!");
    	return "aviso.html";
    	} catch (ErrorServicio ex) {	
    	  modelo.put("error", ex.getMessage());		
    	  return "autor.html";	
    	}       
     
 }   
    
    

 
}
