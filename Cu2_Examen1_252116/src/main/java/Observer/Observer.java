/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Observer;

import DTO.AlumnoDTO;
import java.util.List;

/**
 *
 * @author PC Gamer
 */
public interface Observer {
    void update(List<AlumnoDTO> alumnos);
}
