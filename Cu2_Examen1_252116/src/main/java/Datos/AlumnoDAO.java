
package Datos;

import Modelo.Alumno;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 *
 * @author PC Gamer
 */
public class AlumnoDAO implements IAlumnoDAO {

    private final DataSource dataSource = DataSource.getInstance();

    @Override
    public List<Alumno> buscarPorIdParcial(String idParcial) {

        if (idParcial == null || idParcial.trim().isEmpty()) {
            return List.of(); 
        }

        return dataSource.getAlumnos().stream()
                .filter(alumno -> alumno.getId().startsWith(idParcial))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Alumno> buscarPorIdCompleto(String idCompleto) {
        return dataSource.getAlumnos().stream()
                .filter(alumno -> alumno.getId().equals(idCompleto))
                .findFirst();
    }
}
