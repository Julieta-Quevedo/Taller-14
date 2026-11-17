// LIBRERIA EXTERNA (billetera digital): NO SE PUEDE MODIFICAR.
// Cobra en CENTAVOS, identifica al cliente por celular y responde con codigos numericos:
//   200 = aprobado, 402 = saldo insuficiente, 404 = celular no registrado
public class BilleteraYaApi {
    private int transacciones = 0;

    public int enviarCobro(String celular, long centavos) {
        if (celular.length() != 10 || !celular.startsWith("3")) {
            return 404;
        }
        if (centavos > 50000000L) { // saldo de prueba: 500.000 pesos
            return 402;
        }
        transacciones++;
        return 200;
    }

    public String ultimoIdTransaccion() {
        return "BY-" + (7000 + transacciones);
    }
}
