/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC Gamer
 */


public class Inscripcion {

    private String semestre;
    private LocalDate fecha;
    private List<Materia> materias;

    public Inscripcion(String semestre, LocalDate fecha) {
        this.semestre = semestre;
        this.fecha = fecha;
        this.materias = new ArrayList<>();
    }

    // Método para construir el objeto fácilmente
    public void agregarMateria(Materia materia) {
        this.materias.add(materia);
    }
}
