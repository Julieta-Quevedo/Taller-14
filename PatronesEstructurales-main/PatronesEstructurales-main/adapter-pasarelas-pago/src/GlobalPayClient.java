// LIBRERIA EXTERNA (pasarela internacional): NO SE PUEDE MODIFICAR.
// Cobra en DOLARES, identifica al cliente por correo y, si algo falla, LANZA una excepcion.
public class GlobalPayClient {
    private int charges = 0;

    public String charge(String accountEmail, double amountUSD) throws GlobalPayException {
        if (!accountEmail.contains("@")) {
            throw new GlobalPayException("INVALID_ACCOUNT", "Account not found");
        }
        if (amountUSD > 100) {
            throw new GlobalPayException("LIMIT_EXCEEDED", "Amount over daily limit");
        }
        charges++;
        return "GP-" + (500 + charges);
    }
}
