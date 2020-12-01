/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.modelo;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author japch
 */
public class Matrimonio implements Serializable{
    
    private String id;
    private String fecha;
    private String Lugar;
    private String esposo;
    private String esposa;
    private String sutoridad;
    private List<Persona> listaPersona;

    public Matrimonio(String id, String fecha, String Lugar, String esposo, String esposa, String sutoridad) {
        this.id = id;
        this.fecha = fecha;
        this.Lugar = Lugar;
        this.esposo = esposo;
        this.esposa = esposa;
        this.sutoridad = sutoridad;
        this.listaPersona = listaPersona;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getLugar() {
        return Lugar;
    }

    public void setLugar(String Lugar) {
        this.Lugar = Lugar;
    }

    public String getEsposo() {
        return esposo;
    }

    public void setEsposo(String esposo) {
        this.esposo = esposo;
    }

    public String getEsposa() {
        return esposa;
    }

    public void setEsposa(String esposa) {
        this.esposa = esposa;
    }

    public String getSutoridad() {
        return sutoridad;
    }

    public void setSutoridad(String sutoridad) {
        this.sutoridad = sutoridad;
    }

    public List<Persona> getListaPersona() {
        return listaPersona;
    }

    public void setListaPersona(List<Persona> listaPersona) {
        this.listaPersona = listaPersona;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Matrimonio other = (Matrimonio) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        if (!Objects.equals(this.Lugar, other.Lugar)) {
            return false;
        }
        if (!Objects.equals(this.esposo, other.esposo)) {
            return false;
        }
        if (!Objects.equals(this.esposa, other.esposa)) {
            return false;
        }
        if (!Objects.equals(this.sutoridad, other.sutoridad)) {
            return false;
        }
        if (!Objects.equals(this.listaPersona, other.listaPersona)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Matrimonio{" + "id=" + id + ", fecha=" + fecha + ", Lugar=" + Lugar + ", esposo=" + esposo + ", esposa=" + esposa + ", sutoridad=" + sutoridad + ", listaPersona=" + listaPersona + '}';
    }

  
    
    
}
