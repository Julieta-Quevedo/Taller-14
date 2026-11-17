// Subsistema: cartera y recibos
public class ServicioFinanciero {
    private int recibos = 0;

    public boolean tieneDeuda(String codigo) {
        return codigo.equals("20261002");   // Andres debe el semestre anterior
    }

    public String generarRecibo(String codigo, String materia) {
        recibos++;
        return "REC-" + (100 + recibos);
    }
}
