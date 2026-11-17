// PROBLEMA: el checkout conoce los detalles internos de TODAS las pasarelas.
public class Checkout {
    private static final double TASA_COP_POR_USD = 4000;

    private PagoTarjetaLocal tarjeta = new PagoTarjetaLocal();
    private BilleteraYaApi billetera = new BilleteraYaApi();
    private GlobalPayClient globalPay = new GlobalPayClient();

    public void procesar(String referencia, double montoCOP, String metodo, String datoCliente) {
        ResultadoPago resultado;

        if (metodo.equals("TARJETA")) {
            resultado = tarjeta.pagar(referencia, montoCOP);

        } else if (metodo.equals("BILLETERA")) {
            long centavos = Math.round(montoCOP * 100);
            int codigo = billetera.enviarCobro(datoCliente, centavos);
            if (codigo == 200) {
                resultado = new ResultadoPago(true, billetera.ultimoIdTransaccion(), "Aprobado");
            } else if (codigo == 402) {
                resultado = new ResultadoPago(false, "BY-402", "Saldo insuficiente");
            } else {
                resultado = new ResultadoPago(false, "BY-" + codigo, "Celular no registrado");
            }

        } else if (metodo.equals("GLOBALPAY")) {
            double dolares = montoCOP / TASA_COP_POR_USD;
            try {
                String id = globalPay.charge(datoCliente, dolares);
                resultado = new ResultadoPago(true, id, "Aprobado");
            } catch (GlobalPayException e) {
                resultado = new ResultadoPago(false, e.getErrorCode(), "Rechazado por la pasarela");
            }

        } else {
            resultado = new ResultadoPago(false, "N/A", "Metodo de pago desconocido");
        }

        System.out.printf("%-8s %10s  %-13s %s%n",
                referencia, Formato.pesos(montoCOP), metodo, resultado);
    }
}
