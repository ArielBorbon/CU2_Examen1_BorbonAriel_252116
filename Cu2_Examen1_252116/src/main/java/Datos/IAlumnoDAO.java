
package Datos;

import Modelo.Alumno;
import java.util.List;
import java.util.Optional;


/**
 * 
 * @author PC Gamer
 */
public interface IAlumnoDAO {


    List<Alumno> buscarPorIdParcial(String idParcial);

    Optional<Alumno> buscarPorIdCompleto(String idCompleto);
}
