package com.edu.egg.libreriaWebRicardo.repositorios;

import com.edu.egg.libreriaWebRicardo.entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente,String>{
	    
	@Query("SELECT c FROM Cliente c WHERE c.id= :id")    
	  public Cliente buscarPorId(@Param("id")String id);    
	   
	 @Query("SELECT c FROM Cliente c ORDER BY c.nombre ASC")
	 public List<Cliente> buscarTodos();
}
