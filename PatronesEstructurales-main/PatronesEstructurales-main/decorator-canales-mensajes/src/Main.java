public class Main {
    public static void main(String[] args) {
        // 1. Aviso de notas: correo firmado y registrado
        CanalCorreo correoNotas = new CanalCorreo();
        correoNotas.setFirmar(true);
        correoNotas.setRegistrar(true);
        correoNotas.enviar("laura@unilibre.edu.co", "Su nota final de POO ya esta publicada");

        // 2. Alerta urgente: SMS de maximo 40 caracteres y registrado
        CanalSMS smsUrgente = new CanalSMS();
        smsUrgente.setLimite(40);
        smsUrgente.setRegistrar(true);   // no hace nada: el SMS ignora la bandera
        smsUrgente.enviar("3104567890", "Clase de manana cancelada por jornada de vacunacion en el campus");

        // 3. Clave temporal: correo cifrado y firmado
        CanalCorreo correoSeguro = new CanalCorreo();
        correoSeguro.setCifrar(true);
        correoSeguro.setFirmar(true);
        correoSeguro.enviar("andres@unilibre.edu.co", "Clave temporal: Bosque2026");
        // Seguridad pide que la FIRMA tambien vaya cifrada: imposible sin editar la clase.
    }
}
