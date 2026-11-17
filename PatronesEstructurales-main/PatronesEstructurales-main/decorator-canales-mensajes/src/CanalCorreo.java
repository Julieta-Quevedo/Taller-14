// PROBLEMA: todas las opciones metidas en la misma clase con banderas booleanas.
public class CanalCorreo {
    private static final String FIRMA = " | Facultad de Ingenieria U. Libre";

    private boolean firmar;
    private boolean cifrar;
    private boolean registrar;
    private int limite; // 0 = sin limite
    private int enviados = 0;

    public void setFirmar(boolean firmar) { this.firmar = firmar; }
    public void setCifrar(boolean cifrar) { this.cifrar = cifrar; }
    public void setRegistrar(boolean registrar) { this.registrar = registrar; }
    public void setLimite(int limite) { this.limite = limite; }

    public void enviar(String destinatario, String mensaje) {
        if (registrar) {
            enviados++;
            System.out.println("[LOG #" + enviados + "] a " + destinatario + " (" + mensaje.length() + " caracteres)");
        }
        if (limite > 0 && mensaje.length() > limite) {
            mensaje = mensaje.substring(0, limite - 3) + "...";
        }
        // PROBLEMA: el orden esta fijo: siempre se cifra ANTES de firmar
        if (cifrar) {
            mensaje = cifrarCesar(mensaje);
        }
        if (firmar) {
            mensaje = mensaje + FIRMA;
        }
        System.out.println("[CORREO] para " + destinatario + ": " + mensaje);
    }

    private String cifrarCesar(String texto) {
        StringBuilder sb = new StringBuilder();
        for (char c : texto.toCharArray()) {
            if (c >= 'a' && c <= 'z') sb.append((char) ('a' + (c - 'a' + 3) % 26));
            else if (c >= 'A' && c <= 'Z') sb.append((char) ('A' + (c - 'A' + 3) % 26));
            else sb.append(c);
        }
        return sb.toString();
    }
}
