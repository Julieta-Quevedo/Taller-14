// Subsistema: correo institucional
public class ServicioNotificaciones {
    public void enviarConfirmacion(String codigo, String materia, String recibo) {
        System.out.println("        correo a " + codigo + ": matricula en " + materia + " confirmada (" + recibo + ")");
    }
}
