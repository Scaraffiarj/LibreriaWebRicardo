package com.edu.egg.libreriaWebRicardo.entidades;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Editorial {
	
	@Id
	@GeneratedValue (generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;	
	
    private String nombre;
    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}

	
	
	

