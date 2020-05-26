
package com.edu.egg.libreriaWebRicardo.repositorios;

import java.util.List;

import com.edu.egg.libreriaWebRicardo.entidades.Editorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface EditorialRepositorio extends JpaRepository<Editorial,String> {

	 @Query("SELECT a FROM Editorial a WHERE a.id= :id")
	 public Editorial buscarEditorial(@Param("id")String id); 		
	 
	 @Query("SELECT a FROM Editorial a ORDER BY a.nombre ASC")
	 public  List<Editorial> buscarTodos();
		 	 
	 @Query("SELECT a FROM Editorial a WHERE a.nombre LIKE :nombre")
	 public Editorial buscarEditorialporNombre(@Param("nombre")String editorial); 
}
