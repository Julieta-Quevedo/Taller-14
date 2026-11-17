// PROBLEMA: copia y pega de CanalCorreo con las mismas banderas...
// ...y alguien olvido copiar el bloque de registro.
public class CanalSMS {
    private static final String FIRMA = " | Facultad de Ingenieria U. Libre";

    private boolean firmar;
    private boolean cifrar;
    private boolean registrar;
    private int limite;

    public void setFirmar(boolean firmar) { this.firmar = firmar; }
    public void setCifrar(boolean cifrar) { this.cifrar = cifrar; }
    public void setRegistrar(boolean registrar) { this.registrar = registrar; }
    public void setLimite(int limite) { this.limite = limite; }

    public void enviar(String celular, String mensaje) {
        if (limite > 0 && mensaje.length() > limite) {
            mensaje = mensaje.substring(0, limite - 3) + "...";
        }
        if (cifrar) {
            mensaje = cifrarCesar(mensaje);
        }
        if (firmar) {
            mensaje = mensaje + FIRMA;
        }
        System.out.println("[SMS] " + celular + ": " + mensaje);
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
