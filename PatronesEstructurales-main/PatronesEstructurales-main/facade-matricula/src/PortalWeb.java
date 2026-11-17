// PROBLEMA: el portal conoce los 5 servicios y el orden exacto de las reglas.
public class PortalWeb {
    private ServicioEstudiantes estudiantes;
    private ServicioFinanciero financiero;
    private ServicioCupos cupos;
    private ServicioHorarios horarios;
    private ServicioNotificaciones notificaciones;

    public PortalWeb(ServicioEstudiantes e, ServicioFinanciero f, ServicioCupos c,
                     ServicioHorarios h, ServicioNotificaciones n) {
        estudiantes = e; financiero = f; cupos = c; horarios = h; notificaciones = n;
    }

    public void matricular(String codigo, String materia) {
        String mensaje;
        if (!estudiantes.existe(codigo) || !estudiantes.estaActivo(codigo)) {
            mensaje = "RECHAZADA: estudiante no activo";
        } else if (financiero.tieneDeuda(codigo)) {
            mensaje = "RECHAZADA: tiene deuda pendiente";
        } else if (!cupos.hayCupo(materia)) {
            mensaje = "RECHAZADA: sin cupos";
        } else if (horarios.tieneCruce(codigo, materia)) {
            mensaje = "RECHAZADA: cruce de horario";
        } else {
            cupos.reservar(materia);
            String recibo = financiero.generarRecibo(codigo, materia);
            notificaciones.enviarConfirmacion(codigo, materia, recibo);
            mensaje = "OK, recibo " + recibo;
        }
        System.out.printf("PORTAL %s  %-16s -> %s%n", codigo, materia, mensaje);
    }
}
