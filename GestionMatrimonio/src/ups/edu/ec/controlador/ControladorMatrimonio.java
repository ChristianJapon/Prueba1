/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.controlador;

import ups.edu.ec.modelo.Matrimonio;

/**
 *
 * @author japch
 */
public class ControladorMatrimonio extends AbstracControlador<Matrimonio> {

    @Override
    public boolean validar(Matrimonio objeto) {
       return !objeto.getEsposo().equals(objeto.getEsposa());
    }
    
    
}
