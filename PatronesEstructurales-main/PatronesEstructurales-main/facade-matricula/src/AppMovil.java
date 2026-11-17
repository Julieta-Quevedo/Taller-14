// PROBLEMA: la app copio la logica del portal... y se le olvido revisar la deuda.
public class AppMovil {
    private ServicioEstudiantes estudiantes;
    private ServicioFinanciero financiero;
    private ServicioCupos cupos;
    private ServicioHorarios horarios;
    private ServicioNotificaciones notificaciones;

    public AppMovil(ServicioEstudiantes e, ServicioFinanciero f, ServicioCupos c,
                    ServicioHorarios h, ServicioNotificaciones n) {
        estudiantes = e; financiero = f; cupos = c; horarios = h; notificaciones = n;
    }

    public void matricular(String codigo, String materia) {
        String mensaje;
        if (!estudiantes.existe(codigo) || !estudiantes.estaActivo(codigo)) {
            mensaje = "RECHAZADA: estudiante no activo";
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
        System.out.printf("APP    %s  %-16s -> %s%n", codigo, materia, mensaje);
    }
}
