/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import java.time.LocalDateTime;

/**
 *
 * @author PC Gamer
 */

public class Constancia {

    private String folio;
    private LocalDateTime fechaEmision;
    private String contenido;

    public Constancia(String folio, String contenido) {
        this.folio = folio;
        this.contenido = contenido;
        this.fechaEmision = LocalDateTime.now();
    }
}
