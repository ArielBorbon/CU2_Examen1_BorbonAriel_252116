
package Controlador;

import Modelo.Alumno;
import Modelo.Constancia;
import Modelo.GeneradorConstancia;
import Vista.VistaGeneradorConstancia;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Ariel Eduardo Borbon Izaguirre
 *        ID:252116
 */
public class ConstanciaController {

    private final VistaGeneradorConstancia vista;
    private final GeneradorConstancia servicio;

    public ConstanciaController(VistaGeneradorConstancia vista, GeneradorConstancia servicio) {
        this.vista = vista;
        this.servicio = servicio;

        asignarListeners();
    }


    public void iniciar() {
        vista.setVisible(true);
        actualizarTablaDeAlumnos();
    }

    private void asignarListeners() {
        vista.addBuscarListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                actualizarTablaDeAlumnos();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                actualizarTablaDeAlumnos();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                 }
        });

        vista.addSeleccionarAlumnoListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    seleccionarAlumno();
                }
            }
        });

        vista.addGenerarConstanciaListener(e -> generarConstancia());
        vista.addSalirListener(e -> System.exit(0));
    }

    private void actualizarTablaDeAlumnos() {
        String idParcial = vista.getIdBuscado();
        List<Alumno> alumnosEncontrados = servicio.buscarAlumnos(idParcial);
        vista.mostrarAlumnosEnTabla(alumnosEncontrados);
    }

    private void seleccionarAlumno() {
        String[] datosFila = vista.getDatosFilaSeleccionada();
        if (datosFila != null) {
            vista.mostrarAlumnoSeleccionado(datosFila[0], datosFila[1], datosFila[2]);
        }
    }

    private void generarConstancia() {
        String idCompleto = vista.getIdAlumnoSeleccionado();
        if (idCompleto.isEmpty()) {
            vista.mostrarError("Por favor, seleccione un alumno de la tabla con doble clic.");
            return;
        }

        try {
            Constancia constancia = servicio.generarConstancia(idCompleto);
            vista.mostrarConstancia(constancia.getContenido());
        } catch (Exception ex) {
            vista.mostrarError("Error al generar la constancia:\n" + ex.getMessage());
        }
    }
}
