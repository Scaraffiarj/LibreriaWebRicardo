package com.edu.egg.libreriaWebRicardo.controladores;


import java.util.List;

import com.edu.egg.libreriaWebRicardo.entidades.Autor;
import com.edu.egg.libreriaWebRicardo.entidades.Cliente;
import com.edu.egg.libreriaWebRicardo.entidades.Editorial;
import com.edu.egg.libreriaWebRicardo.repositorios.AutorRepositorio;
import com.edu.egg.libreriaWebRicardo.repositorios.ClienteRepositorio;
import com.edu.egg.libreriaWebRicardo.repositorios.EditorialRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;





@Controller
@RequestMapping("/")
public class PortalController {
	@Autowired
	private AutorRepositorio autorrepositorio;
	@Autowired
	private EditorialRepositorio editorialrepositorio;
	@Autowired
	private ClienteRepositorio clienterepositorio;
	
	
	
	@GetMapping("/index")
	public String index() {
		return "index.html";
	}
	
	@GetMapping("/autor")
	public String autores(ModelMap modelo){
	 List<Autor> autores = autorrepositorio.buscarTodos();
	 modelo.put("autores", autores);
	 return "autor.html";
	}
	
	@GetMapping("/editorial")
	public String editoriales(ModelMap modelo){
	 List<Editorial> editoriales = editorialrepositorio.buscarTodos();
	 modelo.put("editoriales", editoriales);
	 return "editorial.html";
	}

	@GetMapping("/libro")
	public String autoresyEditoriales(ModelMap modelo){
		 List<Autor> autores = autorrepositorio.buscarTodos(); 	    	
		 modelo.put("autores", autores);
		  
		 List<Editorial> editoriales = editorialrepositorio.buscarTodos(); 	    	
		 modelo.put("editoriales", editoriales);
		    	  return "libro.html" ;
		  }
	
	@GetMapping("/cliente")
	public String clientes(ModelMap modelo) {
		List<Cliente> clientes = clienterepositorio.buscarTodos();
		modelo.put("clientes", clientes);		
		return "cliente.html";
	}
	
	@GetMapping("/prestamo")
	public String prestamo() {
		return "prestamo.html";
	}



}


	
	


	
	

	




