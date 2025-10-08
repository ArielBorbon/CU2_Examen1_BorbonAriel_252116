
package Datos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author PC Gamer
 */


public class Inscripcion {

    private String semestre;
    private LocalDate fecha;
    private List<Materia> materias;

    public Inscripcion(String semestre, LocalDate fecha) {
        this.semestre = semestre;
        this.fecha = fecha;
        this.materias = new ArrayList<>();
    }

    public Inscripcion() {
    }
    
    
    

    public void agregarMateria(Materia materia) {
        this.materias.add(materia);
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public List<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(List<Materia> materias) {
        this.materias = materias;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.semestre);
        hash = 59 * hash + Objects.hashCode(this.fecha);
        hash = 59 * hash + Objects.hashCode(this.materias);
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
        final Inscripcion other = (Inscripcion) obj;
        if (!Objects.equals(this.semestre, other.semestre)) {
            return false;
        }
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        return Objects.equals(this.materias, other.materias);
    }

    @Override
    public String toString() {
        return "Inscripcion{" + "semestre=" + semestre + ", fecha=" + fecha + ", materias=" + materias + '}';
    }

    
    
    
    
    
    
}
