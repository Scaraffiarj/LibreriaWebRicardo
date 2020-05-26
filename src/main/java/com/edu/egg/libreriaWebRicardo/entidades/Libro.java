package com.edu.egg.libreriaWebRicardo.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


import org.hibernate.annotations.GenericGenerator;

@Entity
public class Libro {
 
    @Id    
	@GeneratedValue (generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;  
    
    private Long isbn;
    private String titulo;
    private String anio; 
    private Long prestados;
    private Long ejemplares;
    
    @ManyToOne
    private Autor autor;
    
    @ManyToOne
    private Editorial editorial;
       
    public Libro() {
    	this.prestados = (long) 0;
    }
    
    
    public Long getIsbn() {
        return isbn;
    }

   
    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public Long getEjemplares() {
        return ejemplares;
    }

    public void setEjemplares(Long ejemplares) {        
        this.ejemplares =  ejemplares;  
    }

    public Long getPrestados() {
        return prestados;
    }

    public void setPrestados(Long prestados) {
        this.prestados = prestados ;
        }
  
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAnio() {
        return anio;
    }

   
    public void setAnio(String anio) {
        this.anio = anio;
    }

  
    public Autor getAutor() {
        return autor;
    }

   
    public void setAutor(Autor autor) {
        this.autor = autor;
    }

   
    public Editorial getEditorial() {
        return editorial;
    }

  
    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	
	
}
