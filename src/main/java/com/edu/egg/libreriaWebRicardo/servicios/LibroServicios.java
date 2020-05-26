package com.edu.egg.libreriaWebRicardo.servicios;




import com.edu.egg.errores.ErrorServicio;
import com.edu.egg.libreriaWebRicardo.entidades.Autor;
import com.edu.egg.libreriaWebRicardo.entidades.Editorial;
import com.edu.egg.libreriaWebRicardo.entidades.Libro;
import com.edu.egg.libreriaWebRicardo.repositorios.AutorRepositorio;
import com.edu.egg.libreriaWebRicardo.repositorios.EditorialRepositorio;
import com.edu.egg.libreriaWebRicardo.repositorios.LibroRepositorio;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class LibroServicios {
	  @Autowired
	  private LibroRepositorio librorepositorio;
	  @Autowired
	  private EditorialRepositorio editorialrepositorio;
	  @Autowired
	  private AutorRepositorio autorrepositorio;
	  
	  
	  
@Transactional 
 public void registrarLibro(Long isbn,String titulo,String anio,Long ejemplares,String idautor,String ideditorial)throws ErrorServicio{
	  	
		  Editorial editorial = editorialrepositorio.getOne(ideditorial);
		  Autor autor = autorrepositorio.getOne(idautor);
  		
 validar(isbn,titulo,anio,ejemplares,autor,editorial);

 	Libro libro = new Libro();
 	libro.setIsbn(isbn);
 	libro.setTitulo(titulo);
 	libro.setAnio(anio);
 	libro.setEjemplares(ejemplares);
 	libro.setAutor(autor);
 	libro.setEditorial(editorial);
 	
 	librorepositorio.save(libro);

}
	  
 @Transactional 	  
 public void modificarLibro(String id,Long isbn,String titulo,String anio,Long ejemplares,Long prestados,String idautor,String ideditorial)throws ErrorServicio{
		  	
		  Editorial editorial = editorialrepositorio.getOne(ideditorial);
          Autor autor = autorrepositorio.getOne(idautor);
		
 validar(isbn,titulo,anio,ejemplares,autor,editorial);

 	Optional<Libro> respuesta = librorepositorio.findById(id);
 	
 	if (respuesta.isPresent()){
 		Libro libro = respuesta.get();
 		libro.setIsbn(isbn);
 		libro.setTitulo(titulo);
 		libro.setAnio(anio);
 		libro.setEjemplares(ejemplares);
 		libro.setAutor(autor);
 		libro.setEditorial(editorial);
 		libro.setPrestados(prestados);
 		
 		librorepositorio.save(libro);
 	 }else{
         throw new ErrorServicio("No se encontro el libro solicitado");
     }
}	  
	  
 @Transactional 
 public void eliminarLibro(String id)throws ErrorServicio{
 	    
  Optional <Libro> respuesta = librorepositorio.findById(id);
 	  
 	  if (respuesta.isPresent()){
 		  Libro libro = respuesta.get();      
 		 librorepositorio.delete(libro);
 	   }else{
 	      throw new ErrorServicio("No se encontro el libro solicitado");
 	  }
  }
   
 public void validar(Long isbn,String titulo, String anio, Long ejemplares,Autor autor, Editorial editorial) throws ErrorServicio{  
	 if (isbn==null ){       
         throw new ErrorServicio("El ISBN no puede ser nulo y contiene un total de 13 digitos. Verifica el dato ingresado");            
      }
	 
	 if (titulo==null  || titulo.isEmpty()){       
         throw new ErrorServicio("El titulo del libro no puede ser nulo o vacio");            
      }
	 
	 if (anio==null ){       
         throw new ErrorServicio("El anio del libro no puede ser nulo o vacio");            
      }
	 
	 if (autor==null){       
         throw new ErrorServicio("No se encontro el autor indicado");            
      }
	 
	 if (editorial==null){       
         throw new ErrorServicio("No se encontro la editorial");            
      }
	 
}
 
 
}