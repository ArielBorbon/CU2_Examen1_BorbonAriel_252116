
package Mappers;

import DTO.AlumnoDTO;
import Modelo.Alumno;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author PC Gamer
 */
public class AlumnoMapper {

    public static AlumnoDTO toDTO(Alumno alumno) {
        if (alumno == null) {
            return null;
        }

        AlumnoDTO dto = new AlumnoDTO();
        dto.setId(alumno.getId());
        dto.setNombre(alumno.getNombre());
        dto.setApellidoPaterno(alumno.getApellidoPaterno());
        dto.setApellidoMaterno(alumno.getApellidoMaterno());
        dto.setCarrera(alumno.getCarrera());

        return dto;
    }

    public static Alumno toEntity(AlumnoDTO dto) {
        if (dto == null) {
            return null;
        }

        Alumno alumno = new Alumno();
        alumno.setId(dto.getId());
        alumno.setNombre(dto.getNombre());
        alumno.setApellidoPaterno(dto.getApellidoPaterno());
        alumno.setApellidoMaterno(dto.getApellidoMaterno());
        alumno.setCarrera(dto.getCarrera());

        return alumno;
    }

    public static List<AlumnoDTO> toDTOList(List<Alumno> alumnos) {
        if (alumnos == null) {
            return null;
        }
        return alumnos.stream()
                .map(AlumnoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public static List<Alumno> toEntityList(List<AlumnoDTO> dtos) {
        if (dtos == null) {
            return null;
        }
        return dtos.stream()
                .map(AlumnoMapper::toEntity)
                .collect(Collectors.toList());
    }
}
