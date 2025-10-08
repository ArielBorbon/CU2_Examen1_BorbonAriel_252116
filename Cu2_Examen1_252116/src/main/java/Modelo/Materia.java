
package Modelo;

import java.util.Objects;

/**
 *
 * @author PC Gamer
 */
public class Materia {

    private String clave;
    private String nombre;
    private int creditos;

    public Materia(String clave, String nombre, int creditos) {
        this.clave = clave;
        this.nombre = nombre;
        this.creditos = creditos;
    }

    public Materia() {
    }
    
    
    

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    @Override
    public String toString() {
        return "Materia{" + "clave=" + clave + ", nombre=" + nombre + ", creditos=" + creditos + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.clave);
        hash = 59 * hash + Objects.hashCode(this.nombre);
        hash = 59 * hash + this.creditos;
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
        final Materia other = (Materia) obj;
        if (this.creditos != other.creditos) {
            return false;
        }
        if (!Objects.equals(this.clave, other.clave)) {
            return false;
        }
        return Objects.equals(this.nombre, other.nombre);
    }
    
    
    
    
    
    
    
    
    
    
    
}
