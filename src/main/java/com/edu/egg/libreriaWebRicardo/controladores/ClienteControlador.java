package com.edu.egg.libreriaWebRicardo.controladores;

import com.edu.egg.libreriaWebRicardo.servicios.ClienteServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.edu.egg.errores.ErrorServicio;


@Controller
@RequestMapping(value="/cliente")
public class ClienteControlador {
	
	@Autowired
	private ClienteServicios clienteservicio;
	
	@PostMapping("/agregarCliente")	
	public String agregarCliente(ModelMap modelo,@RequestParam Long documento, @RequestParam String nombre,
		@RequestParam String apellido, @RequestParam String domicilio,
		@RequestParam String telefono){
		try {
		 clienteservicio.registrarCliente(documento,nombre,apellido,domicilio,telefono);
		 modelo.put("titulo", "CLIENTE");
		 modelo.put("descripcion", "Creado de Forma Correcta!");
		return "aviso.html";	
		} catch (ErrorServicio ex) {	
		modelo.put("error", ex.getMessage());		
		return "cliente.html";	
		}
	  
		}
			
	@PostMapping("/modificarCliente")	
	public String modificarCliente(ModelMap modelo,@RequestParam String idCliente,
		Long documento, String nombre,String apellido, String domicilio,
		String telefono){
		try {
		 clienteservicio.modificarCliente(idCliente,documento,nombre,apellido,domicilio,telefono);
		 modelo.put("titulo", "CLIENTE");
		 modelo.put("descripcion", "Modificado de Forma Correcta!");
		return "aviso.html";	
		} catch (ErrorServicio ex) {	
		modelo.put("error", ex.getMessage());		
		return "cliente.html";	
		}
	  
		}		

@PostMapping("/eliminarCliente")
public String eliminarAutor(ModelMap modelo, @RequestParam String idCliente){
	try {
	clienteservicio.eliminarCliente(idCliente);	
		  modelo.put("titulo", "CLIENTE");
		  modelo.put("descripcion", "Eliminado de Forma Correcta!");
		  return "aviso.html";
		} catch (ErrorServicio ex) {	
		  modelo.put("error", ex.getMessage());		
		  return "cliente.html";	
	}
}


}
