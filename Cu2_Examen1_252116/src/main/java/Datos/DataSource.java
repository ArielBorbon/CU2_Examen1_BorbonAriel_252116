
package Datos;

import Modelo.Alumno;
import Modelo.Inscripcion;
import Modelo.Materia;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author PC Gamer
 */
public final class DataSource {

    private static final DataSource instance = new DataSource();
    private final List<Materia> materias;
    private final List<Alumno> alumnos;

    private DataSource() {
        this.materias = new ArrayList<>();
        this.alumnos = new ArrayList<>();
        cargarDatosDePrueba();
    }


    public static DataSource getInstance() {
        return instance;
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    private void cargarDatosDePrueba() {
        cargarMaterias();
        cargarAlumnos();
    }

    private void cargarMaterias() {

        materias.add(new Materia("SDP-101", "Salud y Desarrollo Personal", 5));
        materias.add(new Materia("PRE-101", "Precálculo", 8));
        materias.add(new Materia("IIS-101", "Introducción a la Ingeniería en Software", 6));
        materias.add(new Materia("PRG-101", "Programación I con Laboratorio", 8));
        materias.add(new Materia("ACI-101", "Análisis de la Información y Comunicación", 5));
        materias.add(new Materia("ING-101", "Inglés Introductorio", 4));

        materias.add(new Materia("TEC-201", "Tecnología y Empresa", 6));
        materias.add(new Materia("PRG-201", "Programación II con Laboratorio", 8));
        materias.add(new Materia("CAL-201", "Cálculo", 8));
        materias.add(new Materia("MDI-201", "Matemáticas Discretas", 8));
        materias.add(new Materia("SAQ-201", "Sistemas Operativos y Arquitectura de Computadoras", 8));
        materias.add(new Materia("ING-201", "Inglés Universitario A1", 4));

        materias.add(new Materia("RED-301", "Redes", 8));
        materias.add(new Materia("MCO-301", "Matemáticas Computacionales", 8));
        materias.add(new Materia("ALG-301", "Álgebra Lineal", 8));
        materias.add(new Materia("PRG-301", "Programación III", 8));
        materias.add(new Materia("BDA-301", "Bases de Datos", 8));
        materias.add(new Materia("PES-301", "Probabilidad y Estadística", 8));
        materias.add(new Materia("DGC-301", "Democracia y Gestión Ciudadana", 5));
        materias.add(new Materia("EDA-301", "Estructuras de Datos", 8));
        materias.add(new Materia("ING-301", "Inglés Universitario A2", 4));
        
    }

    private void cargarAlumnos() {

        Alumno alu1 = new Alumno("21040056", "Juan Carlos", "Bodoque", "Sánchez", "Ingeniería en Software");
        Inscripcion insc1_1 = new Inscripcion("Primer Semestre", LocalDate.of(2024, 8, 12));
        getMateriasPorClave("SDP-101", "PRE-101", "IIS-101", "PRG-101", "ACI-101", "ING-101").forEach(insc1_1::agregarMateria);

        Inscripcion insc1_2 = new Inscripcion("Segundo Semestre", LocalDate.of(2025, 1, 20));
        getMateriasPorClave("TEC-201", "PRG-201", "CAL-201", "MDI-201", "SAQ-201", "ING-201").forEach(insc1_2::agregarMateria);

        Inscripcion insc1_3 = new Inscripcion("Tercer Semestre", LocalDate.of(2025, 8, 11));
        getMateriasPorClave("RED-301", "MCO-301", "ALG-301", "PRG-301", "BDA-301", "PES-301", "DGC-301", "EDA-301", "ING-301").forEach(insc1_3::agregarMateria);

        alu1.agregarInscripcion(insc1_1);
        alu1.agregarInscripcion(insc1_2);
        alu1.agregarInscripcion(insc1_3);
        alumnos.add(alu1);


        Alumno alu2 = new Alumno("21040089", "Ana María", "García", "López", "Ingeniería en Software");
        Inscripcion insc2_1 = new Inscripcion("Primer Semestre", LocalDate.of(2025, 8, 11));
        getMateriasPorClave("SDP-101", "PRE-101", "IIS-101", "PRG-101", "ACI-101", "ING-101").forEach(insc2_1::agregarMateria);
        alu2.agregarInscripcion(insc2_1);
        alumnos.add(alu2);


        Alumno alu3 = new Alumno("21040058", "Pedro", "Pascal", "Pérez", "Ingeniería en Software");
        Inscripcion insc3_1 = new Inscripcion("Primer Semestre", LocalDate.of(2024, 8, 12));
        getMateriasPorClave("SDP-101", "PRE-101", "IIS-101", "PRG-101", "ACI-101", "ING-101").forEach(insc3_1::agregarMateria);

        Inscripcion insc3_2 = new Inscripcion("Segundo Semestre", LocalDate.of(2025, 1, 20));
        getMateriasPorClave("TEC-201", "PRG-201", "CAL-201", "MDI-201", "SAQ-201", "ING-201").forEach(insc3_2::agregarMateria);

        alu3.agregarInscripcion(insc3_1);
        alu3.agregarInscripcion(insc3_2);
        alumnos.add(alu3);
    }

    private List<Materia> getMateriasPorClave(String... claves) {
        return Stream.of(claves)
                .flatMap(clave -> materias.stream().filter(materia -> materia.getClave().equals(clave)))
                .collect(Collectors.toList());
    }
}
