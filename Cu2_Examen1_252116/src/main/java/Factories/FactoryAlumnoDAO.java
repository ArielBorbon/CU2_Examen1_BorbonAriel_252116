
package Factories;

import Datos.AlumnoDAO;

/**
 *
 * @author Ariel Eduardo Borbon Izaguirre
 *        ID:252116
 */
public class FactoryAlumnoDAO {
    
    
    public static AlumnoDAO crearAlumnoDAO(){
        AlumnoDAO alumnoDAO = new AlumnoDAO();
        return alumnoDAO;
    }
}
