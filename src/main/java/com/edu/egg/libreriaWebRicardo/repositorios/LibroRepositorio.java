package com.edu.egg.libreriaWebRicardo.repositorios;

import com.edu.egg.libreriaWebRicardo.entidades.Autor;
import com.edu.egg.libreriaWebRicardo.entidades.Editorial;
import com.edu.egg.libreriaWebRicardo.entidades.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;




import java.util.List;


@Repository
public interface LibroRepositorio extends JpaRepository<Libro,String> {

	 @Query("SELECT a FROM Libro a WHERE a.id= :id")
	 public Libro buscarLibroporId(@Param("id")String id);
	 
	 @Query("SELECT a FROM Libro a WHERE a.isbn= :isbn")
	 public Libro buscarporIsbn(@Param("isbn")Long isbn);
	 
//	 @Query("SELECT a FROM Libro a WHERE a.nombre LIKE :nombre")
//	 public List<Libro> buscarLibrosporNombre(@Param("nombre")Libro libro);	 
	 
	 @Query("SELECT a FROM Libro a WHERE a.autor= :autor")
	 public List<Libro> buscarLibroporAutor(@Param("autor") Autor autor);

	 @Query("SELECT a FROM Libro a WHERE a.editorial= :editorial")
	 public List<Libro> buscarLibroporEditorial(@Param("editorial") Editorial editorial);
}
