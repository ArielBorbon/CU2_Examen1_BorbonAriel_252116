
package Datos;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 *
 * @author PC Gamer
 */

public class Constancia {

    private String folio;
    private LocalDateTime fechaEmision;
    private String contenido;

    public Constancia(String folio, String contenido) {
        this.folio = folio;
        this.contenido = contenido;
        this.fechaEmision = LocalDateTime.now();
    }

    public Constancia() {
    }

    
    
    
    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public LocalDateTime getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(LocalDateTime fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + Objects.hashCode(this.folio);
        hash = 73 * hash + Objects.hashCode(this.fechaEmision);
        hash = 73 * hash + Objects.hashCode(this.contenido);
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
        final Constancia other = (Constancia) obj;
        if (!Objects.equals(this.folio, other.folio)) {
            return false;
        }
        if (!Objects.equals(this.contenido, other.contenido)) {
            return false;
        }
        return Objects.equals(this.fechaEmision, other.fechaEmision);
    }

    @Override
    public String toString() {
        return "Constancia{" + "folio=" + folio + ", fechaEmision=" + fechaEmision + ", contenido=" + contenido + '}';
    }
    
    
    
    
}
