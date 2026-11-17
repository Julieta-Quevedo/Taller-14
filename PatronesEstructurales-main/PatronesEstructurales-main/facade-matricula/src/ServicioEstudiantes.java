import java.util.HashMap;
import java.util.Map;

// Subsistema: registro academico
public class ServicioEstudiantes {
    private Map<String, Boolean> activos = new HashMap<>();

    public ServicioEstudiantes() {
        activos.put("20261001", true);   // Laura
        activos.put("20261002", true);   // Andres
        activos.put("20261003", false);  // Camila (retiro temporal)
        activos.put("20261004", true);   // Mateo
    }

    public boolean existe(String codigo) {
        return activos.containsKey(codigo);
    }

    public boolean estaActivo(String codigo) {
        return activos.getOrDefault(codigo, false);
    }
}
