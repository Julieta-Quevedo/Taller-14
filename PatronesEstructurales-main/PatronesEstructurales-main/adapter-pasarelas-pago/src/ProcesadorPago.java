// El contrato de la tienda: cobrar un monto en pesos colombianos.
public interface ProcesadorPago {
    String nombre();
    ResultadoPago pagar(String referencia, double montoCOP);
}
