
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
 * 
 * Controlador entre la vista y modelo del proyecto
 */
public class ConstanciaController {

    private final VistaGeneradorConstancia vista;
    private final GeneradorConstancia modelo;

    public ConstanciaController(VistaGeneradorConstancia vista, GeneradorConstancia modelo) {
        this.vista = vista;
        this.modelo = modelo;

        asignarListeners();
    }


    public void iniciar() {
        vista.setVisible(true);
        actualizarTablaDeAlumnos();
    }

    /*
    Metodo para colocarle listeners a la vista para poder controlarla desde el controlador
    */
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

    
    /*
    Metodo para actualizar la tabla de alumnos de la vista
    */
    private void actualizarTablaDeAlumnos() {
        String idParcial = vista.getIdBuscado();
        List<Alumno> alumnosEncontrados = modelo.buscarAlumnos(idParcial);
        vista.mostrarAlumnosEnTabla(alumnosEncontrados);
    }

    /*
    Metodo para seleccionar alumno de la tabla de la vista
    */
    private void seleccionarAlumno() {
        String[] datosFila = vista.getDatosFilaSeleccionada();
        if (datosFila != null) {
            vista.mostrarAlumnoSeleccionado(datosFila[0], datosFila[1], datosFila[2]);
        }
    }

    
    /*
    Metodo para mostrar la constancia creada usando el modelo y la vista para colocarla ahi
    */
    private void generarConstancia() {
        String idCompleto = vista.getIdAlumnoSeleccionado();
        if (idCompleto.isEmpty()) {
            vista.mostrarError("Por favor, seleccione un alumno de la tabla con doble clic.");
            return;
        }

        try {
            Constancia constancia = modelo.generarConstancia(idCompleto);
            vista.mostrarConstancia(constancia.getContenido());
        } catch (Exception ex) {
            vista.mostrarError("Error al generar la constancia:\n" + ex.getMessage());
        }
    }
}
