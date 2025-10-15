package Modelo;

import DTO.AlumnoDTO;
import Datos.IAlumnoDAO;
import Mappers.AlumnoMapper;
import Observer.Observer;
import Observer.Subject;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 *
 * @author Ariel Eduardo Borbon Izaguirre ID:252116
 */
public class GeneradorConstancia implements Subject {

    private final IAlumnoDAO alumnoDAO;
    private String folio;
    private final List<Observer> observers; 
    private List<AlumnoDTO> ultimosResultados;

    public GeneradorConstancia(IAlumnoDAO alumnoDAO) {
        this.alumnoDAO = alumnoDAO;
        this.observers = new ArrayList<>();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(ultimosResultados);
        }
    }

    public void buscarAlumnos(String idParcial) { 
        List<Alumno> alumnosEncontrados = alumnoDAO.buscarPorIdParcial(idParcial);
        
        this.ultimosResultados = AlumnoMapper.toDTOList(alumnosEncontrados);
        
        notifyObservers();
    }

    public Constancia generarConstancia(String idCompleto) {
        Optional<Alumno> alumnoOpt = alumnoDAO.buscarPorIdCompleto(idCompleto);

        if (alumnoOpt.isEmpty()) {
            throw new IllegalArgumentException("No se encontró ningun alumno con el ID: " + idCompleto);
        }

        Alumno alumno = alumnoOpt.get();

        Optional<Inscripcion> inscripcionOpt = alumno.getInscripcionActual();

        if (inscripcionOpt.isEmpty()) {
            throw new IllegalStateException("El alumno " + alumno.getNombreCompleto() + " no tiene una inscripción activa.");
        }

        String contenido = formatearContenido(alumno, inscripcionOpt.get());
        String folioC = folio;

        return new Constancia(folioC, contenido);
    }

    private String formatearContenido(Alumno alumno, Inscripcion inscripcion) {
        StringBuilder sb = new StringBuilder();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd 'de' MMMM 'de' yyyy");
        String fechaActual = LocalDate.now().format(formatter);

        folio = "CERT-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();

        sb.append("--- CONSTANCIA DE ESTUDIOS ---");
        sb.append("\n");
        sb.append(folio);
        sb.append("\n\n");
        sb.append("Ciudad Obregón, Sonora a ");
        sb.append(fechaActual);
        sb.append("\n\n\n");
        sb.append("A QUIEN CORRESPONDA:");
        sb.append("\n\n");
        sb.append("Por medio de la presente se hace constar que el/la C. ");
        sb.append(alumno.getNombreCompleto().toUpperCase());
        sb.append(",");
        sb.append("\n");
        sb.append("con número de matrícula ");
        sb.append(alumno.getId());
        sb.append(", ");
        sb.append("es alumno(a) regular de esta institución en el programa de ");
        sb.append("\n");
        sb.append(alumno.getCarrera());
        sb.append("\n\n");
        sb.append("Actualmente se encuentra inscrito(a) en el ");
        sb.append(inscripcion.getSemestre());
        sb.append(", ");
        sb.append("cursando las siguientes asignaturas:");
        sb.append("\n\n");

        for (Materia materia : inscripcion.getMaterias()) {
            sb.append("\t- ").append(materia.getClave()).append(": ").append(materia.getNombre()).append("\n");
        }

        sb.append("\n\n");
        sb.append("Se extiende la presente para los fines que al interesado(a) convengan.");
        sb.append("\n\n");
        sb.append("ATENTAMENTE");
        sb.append("\n");
        sb.append("_____________________________");
        sb.append("\n");
        sb.append("Registro Escolar");
        sb.append("\n");
        sb.append("Instituto Tecnologico De Sonora");
        sb.append("\n");

        return sb.toString();
    }
}
