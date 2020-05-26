package com.edu.egg.libreriaWebRicardo.servicios;

import java.util.Optional;

import javax.transaction.Transactional;

import com.edu.egg.libreriaWebRicardo.entidades.Cliente;
import com.edu.egg.libreriaWebRicardo.repositorios.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.edu.egg.errores.ErrorServicio;


@Service
public class ClienteServicios {
	int contador;
	
	 @Autowired
	 private ClienteRepositorio clienterepositorio;
	 
	 
 @Transactional 
public void registrarCliente(Long documento,String nombre,String apellido,String domicilio,String telefono)throws ErrorServicio{
	 		  
validar(documento,nombre,apellido,domicilio,telefono);
	 Cliente cliente = new Cliente();
	
	 cliente.setDocumento(documento);
	 nombre=nombre.toUpperCase();
	 cliente.setNombre(nombre);
	 apellido=apellido.toUpperCase();
	 cliente.setApellido(apellido);
	 domicilio=domicilio.toUpperCase();
	 cliente.setDomicilio(domicilio);	 
	 cliente.setTelefono(telefono);

	 clienterepositorio.save(cliente); 	  
 }         
 
 
 @Transactional 
public void modificarCliente(String id,Long documento,String nombre,String apellido,String domicilio,String telefono)throws ErrorServicio{

Optional <Cliente> respuesta = clienterepositorio.findById(id);

if (respuesta.isPresent()){
	 Cliente cliente = respuesta.get();
	 if (documento==null) {
		 cliente.setDocumento(cliente.getDocumento());		 
	 }else {
		 cliente.setDocumento(documento); 
	 }
	 
	 if (nombre==null|| nombre.isEmpty()) {
		 cliente.setNombre(cliente.getNombre());		
	 }else {
		 cliente.setNombre(nombre);
	 }
	 
	 if (apellido==null || apellido.isEmpty()) {
		cliente.setApellido(cliente.getApellido());
	 }else {
		 cliente.setApellido(apellido);
	 }
	 
	 if (domicilio==null || domicilio.isEmpty()) {
		 cliente.setDomicilio(cliente.getDomicilio());
	 }else {
		 cliente.setDomicilio(domicilio);
	 }
	 
	 
	 if (telefono==null || telefono.isEmpty()) {
		 cliente.setTelefono(cliente.getTelefono());
	 }else {
		 cliente.setTelefono(telefono);
	 }	 
	 clienterepositorio.save(cliente); 

 }else{
       throw new ErrorServicio("No se encontro el cliente solicitado");
   }
 }     
 
 @Transactional 
 public void eliminarCliente(String idCliente)throws ErrorServicio{
 	    
  Optional <Cliente> respuesta = clienterepositorio.findById(idCliente);
 	  
 	  if (respuesta.isPresent()){
 		  Cliente cliente = respuesta.get();      
 		  clienterepositorio.delete(cliente);
 	  }
  }
  
 

 public void validar(Long documento,String nombre, String apellido, String domicilio, String telefono)throws ErrorServicio{
	 if (documento==null  || documento==0){       
	        throw new ErrorServicio("El documento del cliente no puede ser nulo o vacio");	
	 }       
	 if (nombre==null  || nombre.isEmpty()){       
        throw new ErrorServicio("El nombre del cliente no puede ser nulo o vacio");            
     }	 
     if (apellido==null  || apellido.isEmpty()){       
        throw new ErrorServicio("El apellido del cliente no puede ser nulo o vacio");            
     }
     if (domicilio==null  || domicilio.isEmpty()){       
        throw new ErrorServicio("El domicilio del cliente no puede ser nulo o vacio"); 
     }     
      if (telefono==null  || telefono.isEmpty()){       
        throw new ErrorServicio("El telefono del cliente no puede ser nulo o vacio");            
     }    
  }

 }
   
 

