
package Main;

import Controlador.ConstanciaController;
import Factories.FactoryAlumnoDAO;
import Datos.IAlumnoDAO;
import Modelo.GeneradorConstancia;
import Vista.VistaGeneradorConstancia;

/**
 *
 * @author Ariel Eduardo Borbon Izaguirre
 *        ID:252116
 */
public class Main {

    public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(() -> {
            IAlumnoDAO alumnoDAO = FactoryAlumnoDAO.crearAlumnoDAO();
            GeneradorConstancia servicio = new GeneradorConstancia(alumnoDAO);

            VistaGeneradorConstancia vista = new VistaGeneradorConstancia();

            ConstanciaController controlador = new ConstanciaController(vista, servicio);

            controlador.iniciar();
        });
    }
}
