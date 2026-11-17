public class Computador {
    private boolean encendido = false;

    public void encender() {
        encendido = true;
        System.out.println("  Computador: encendido");
    }

    public void abrirPresentacion(String archivo) {
        if (!encendido) {
            System.out.println("  Computador: ERROR, no se puede abrir " + archivo + " (esta apagado)");
            return;
        }
        System.out.println("  Computador: abriendo " + archivo);
    }

    public void apagar() {
        encendido = false;
        System.out.println("  Computador: apagado");
    }
}
