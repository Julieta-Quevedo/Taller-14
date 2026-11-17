public class Main {
    public static void main(String[] args) {
        Proyector proyector = new Proyector();
        Sonido sonido = new Sonido();
        Luces luces = new Luces();
        Computador computador = new Computador();

        // PROBLEMA: el docente tiene que saber 7 pasos y su orden para empezar una clase
        System.out.println("== Clase de las 7:00 (POO)");
        computador.encender();
        proyector.encender();
        proyector.seleccionarEntrada("HDMI");
        sonido.encender();
        sonido.volumen(30);
        luces.intensidad(40);
        computador.abrirPresentacion("patrones-estructurales.pptx");

        System.out.println("== Fin de clase");
        computador.apagar();
        proyector.apagar();
        sonido.apagar();
        luces.intensidad(100);

        // PROBLEMA: los mismos pasos copiados... y esta vez en otro orden
        System.out.println("== Clase de las 9:00 (Bases de Datos)");
        proyector.encender();
        computador.abrirPresentacion("modelo-relacional.pptx");   // antes de encender el PC
        computador.encender();
        sonido.encender();
        sonido.volumen(30);
        luces.intensidad(40);
        // se olvido seleccionarEntrada("HDMI"): el proyector queda sin senal
    }
}
