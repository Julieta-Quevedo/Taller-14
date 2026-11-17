// Pasarela propia de la tienda: ya cumple el contrato.
public class PagoTarjetaLocal implements ProcesadorPago {
    private int consecutivo = 0;

    public String nombre() {
        return "TarjetaLocal";
    }

    public ResultadoPago pagar(String referencia, double montoCOP) {
        if (montoCOP > 5000000) {
            return new ResultadoPago(false, "TL-LIM", "Supera el cupo de la tarjeta");
        }
        consecutivo++;
        return new ResultadoPago(true, "TL-" + consecutivo, "Aprobado");
    }
}
