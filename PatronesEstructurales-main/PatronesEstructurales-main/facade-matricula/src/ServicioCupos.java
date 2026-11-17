import java.util.HashMap;
import java.util.Map;

// Subsistema: oferta de materias
public class ServicioCupos {
    private Map<String, Integer> cupos = new HashMap<>();

    public ServicioCupos() {
        cupos.put("Programacion I", 2);
        cupos.put("Bases de Datos", 3);
        cupos.put("Calculo Integral", 0);
    }

    public boolean hayCupo(String materia) {
        return cupos.getOrDefault(materia, 0) > 0;
    }

    public void reservar(String materia) {
        cupos.put(materia, cupos.get(materia) - 1);
    }

    public int disponibles(String materia) {
        return cupos.getOrDefault(materia, 0);
    }
}
