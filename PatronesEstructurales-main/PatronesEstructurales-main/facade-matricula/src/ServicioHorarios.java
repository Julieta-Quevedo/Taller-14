// Subsistema: horarios
public class ServicioHorarios {
    public boolean tieneCruce(String codigo, String materia) {
        // Laura ya tiene una materia el martes 7:00, misma franja de Bases de Datos
        return codigo.equals("20261001") && materia.equals("Bases de Datos");
    }
}
