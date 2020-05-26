package com.edu.egg.libreriaWebRicardo.repositorios;

import com.edu.egg.libreriaWebRicardo.entidades.Cliente;
import com.edu.egg.libreriaWebRicardo.entidades.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;


@Repository
public interface PrestamoRepositorio extends JpaRepository<Prestamo,String> {

	 @Query("SELECT a FROM Prestamo a WHERE a.id= :id")
	 public Prestamo buscarPrestamoporId(@Param("id")String id); 		
		 	 
	 @Query("SELECT a FROM Prestamo a WHERE a.cliente= :cliente")
	 public List<Prestamo> buscarPrestamoporCliente(@Param("cliente") Cliente cliente);
	  
}
