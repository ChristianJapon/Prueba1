/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.controlador;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import ups.edu.ec.modelo.Persona;

/**
 *
 * @author japch
 */
public abstract class AbstracControlador<E> {
    public List<E> lista;
    public AbstracControlador(){
    lista = new ArrayList();
    }
     
public void cargarDatos(String ruta) throws FileNotFoundException, IOException, ClassNotFoundException {
    FileInputStream archivo = new FileInputStream(ruta);
     ObjectInputStream datos = new ObjectInputStream(archivo);
     lista = (List<E>) (List<Persona>) datos.readObject();
    }
    public void guardarDatos(String ruta) throws FileNotFoundException, IOException {
        FileOutputStream archivo = new FileOutputStream(ruta);
        ObjectOutputStream datos = new ObjectOutputStream(archivo);
        datos.writeObject(lista);
    }
    
    public boolean crear(E objeto){
        if (validar(objeto) )
            return lista.add(objeto);
        return false;
    }
    
    public E buscar(E comparacion){
        return lista.stream().filter(objeto -> objeto.equals(comparacion)).findFirst().get();
    }
    
    public boolean eliminar (E objeto){
        E objetoEliminar = buscar(objeto);
        return (objetoEliminar != null)? lista.remove(objetoEliminar): false;
    }
    
    public int buscarPosicion(E comparacion){
        for(int i=0; i<lista.size(); i++){
            E objeto = lista.get(i);
            if(objeto.equals(comparacion))
                return i;
        }
        return -1;
    }
    
    public boolean actualizar(E objeto){
       int index = buscarPosicion(objeto);
       if(index >0 && validar(objeto) == true){
            lista.set(index, objeto);
            return true;
       }
            return false;
    }

    public List<E> getLista() {
        return lista;
    }

    public void setLista(List<E> lista) {
        this.lista = lista;
    }
    
    
    public abstract boolean validar(E objeto);
}
