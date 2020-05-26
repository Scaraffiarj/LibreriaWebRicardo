package com.edu.egg.libreriaWebRicardo.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.edu.egg.libreriaWebRicardo.entidades.Libro;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Prestamo {
	
	@Id
	@GeneratedValue (generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;
	
	@Temporal(TemporalType.DATE)
    private Date fecha;
    
	@Temporal(TemporalType.DATE)
    private Date devolucion;
	
	private double multa;
  	
    @ManyToMany
    private List<Libro> libros;
   
    @ManyToOne
    private Cliente cliente;

    
    
    
    public List<Libro> getLibros() {
        return libros;
    }

    public void addLibros(Libro libro) {
        this.libros.add(libro);
        
    }
    public void removeLibros(Libro libro) {
        this.libros.remove(libro);
    }
       
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getDevolucion() {
        return devolucion;
    }

    public void setDevolucion(Date devolucion) {
        this.devolucion = devolucion;
    }

	public double getMulta() {
		return multa;
	}

	public void setMulta(double multa) {
		this.multa = multa;
	}
	
	
}
