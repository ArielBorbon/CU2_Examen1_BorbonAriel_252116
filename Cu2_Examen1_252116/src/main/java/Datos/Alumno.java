
package Datos;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author PC Gamer
 */

public class Alumno {

    private String id;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String carrera;
    private List<Inscripcion> inscripciones;

    public Alumno(String id, String nombre, String apellidoPaterno, String apellidoMaterno, String carrera) {
        this.id = id;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.carrera = carrera;
        this.inscripciones = new ArrayList<>();
    }

    public void agregarInscripcion(Inscripcion inscripcion) {
        this.inscripciones.add(inscripcion);
    }

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

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public List<Inscripcion> getInscripciones() {
        return inscripciones;
    }

    public void setInscripciones(List<Inscripcion> inscripciones) {
        this.inscripciones = inscripciones;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.id);
        hash = 71 * hash + Objects.hashCode(this.nombre);
        hash = 71 * hash + Objects.hashCode(this.apellidoPaterno);
        hash = 71 * hash + Objects.hashCode(this.apellidoMaterno);
        hash = 71 * hash + Objects.hashCode(this.carrera);
        hash = 71 * hash + Objects.hashCode(this.inscripciones);
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
        final Alumno other = (Alumno) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.apellidoPaterno, other.apellidoPaterno)) {
            return false;
        }
        if (!Objects.equals(this.apellidoMaterno, other.apellidoMaterno)) {
            return false;
        }
        if (!Objects.equals(this.carrera, other.carrera)) {
            return false;
        }
        return Objects.equals(this.inscripciones, other.inscripciones);
    }

    @Override
    public String toString() {
        return "Alumno{" + "id=" + id + ", nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", carrera=" + carrera + ", inscripciones=" + inscripciones + '}';
    }
    
    
    
    
    
}
