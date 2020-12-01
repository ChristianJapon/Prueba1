/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.controlador;


import ups.edu.ec.modelo.Persona;

/**
 *
 * @author japch
 */
public class ControladorPersona extends AbstracControlador<Persona>{

     @Override
    public boolean validar(Persona objeto) {
    return !objeto.getNombre().equals(objeto.getApellido());
    }
    
    
}
