
package Datos;

import Modelo.Alumno;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 *
 * @author Ariel Eduardo Borbon Izaguirre
 *        ID:252116
 * 
 * Esta clase se usa como "Acceso de datos" que estan en el data source
 */
public class AlumnoDAO implements IAlumnoDAO {

    private final DataSource dataSource = DataSource.getInstance();

    @Override
    public List<Alumno> buscarPorIdParcial(String idParcial) {


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
