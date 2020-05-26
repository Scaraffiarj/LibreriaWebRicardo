package com.edu.egg.libreriaWebRicardo.controladores;



import com.edu.egg.libreriaWebRicardo.servicios.LibroServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.edu.egg.errores.ErrorServicio;


@Controller
@RequestMapping(value="/libro")
public class LibroControlador {
	

	@Autowired
	private LibroServicios libroservicio;
	
	
		
	@PostMapping("/agregarLibro")
		public String agregarLibro(ModelMap modelo,@RequestParam Long isbn,@RequestParam String titulo,
			@RequestParam String anio,@RequestParam Long ejemplares,@RequestParam String idAutor,
			@RequestParam String idEditorial){
			try {				
				libroservicio.registrarLibro(isbn, titulo, anio, ejemplares, idAutor, idEditorial);	
				modelo.put("titulo", "LIBRO");
				modelo.put("descripcion", "Creado de Forma Correcta!");
				return "aviso.html";
			} catch (ErrorServicio ex) {	
				modelo.put("error", ex.getMessage());		
				return "libro.html";
			}
				
		}
	
	
}
