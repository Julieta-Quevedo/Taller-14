public class Main {
    public static void main(String[] args) {
        ServicioEstudiantes estudiantes = new ServicioEstudiantes();
        ServicioFinanciero financiero = new ServicioFinanciero();
        ServicioCupos cupos = new ServicioCupos();
        ServicioHorarios horarios = new ServicioHorarios();
        ServicioNotificaciones notificaciones = new ServicioNotificaciones();

        PortalWeb portal = new PortalWeb(estudiantes, financiero, cupos, horarios, notificaciones);
        AppMovil app = new AppMovil(estudiantes, financiero, cupos, horarios, notificaciones);

        portal.matricular("20261001", "Programacion I");    // Laura
        app.matricular("20261002", "Programacion I");       // Andres, con deuda
        portal.matricular("20261002", "Programacion I");    // Andres otra vez, por el portal
        app.matricular("20261003", "Calculo Integral");     // Camila, inactiva
        portal.matricular("20261001", "Bases de Datos");    // Laura, cruce de horario
        app.matricular("20261004", "Calculo Integral");     // Mateo, sin cupos

        System.out.println("Cupos que quedan en Programacion I: " + cupos.disponibles("Programacion I"));
    }
}
