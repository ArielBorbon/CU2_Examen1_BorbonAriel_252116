
package Datos;

import Modelo.Alumno;
import java.util.List;
import java.util.Optional;


/**
 *
 * @author Ariel Eduardo Borbon Izaguirre
 *        ID:252116
 * 
 * Interfaz de alumnoDAO para colocarla en parametros como buena practica
 */
public interface IAlumnoDAO {


    List<Alumno> buscarPorIdParcial(String idParcial);

    Optional<Alumno> buscarPorIdCompleto(String idCompleto);
}
