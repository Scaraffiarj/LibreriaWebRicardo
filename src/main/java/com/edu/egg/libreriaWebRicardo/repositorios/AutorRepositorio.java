package com.edu.egg.libreriaWebRicardo.repositorios;


import com.edu.egg.libreriaWebRicardo.entidades.Autor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface AutorRepositorio extends JpaRepository<Autor,String>{
	
	 @Query("SELECT a FROM Autor a WHERE a.id= :id")
	 public Autor buscarAutor(@Param("id")String id);
 	 
	 @Query("SELECT a FROM Autor a WHERE a.nombre LIKE :nombre")
	 public Autor buscarAutorporNombre(@Param("nombre")String nombre);
	 
	 @Query("SELECT a FROM Autor a ORDER BY a.nombre ASC")
	 public  List<Autor> buscarTodos();
	 

	 
	 
}
