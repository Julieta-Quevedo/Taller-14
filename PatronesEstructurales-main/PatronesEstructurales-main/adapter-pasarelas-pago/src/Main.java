public class Main {
    public static void main(String[] args) {
        Checkout checkout = new Checkout();

        checkout.procesar("PED-001", 180000, "TARJETA", "");
        checkout.procesar("PED-002", 95000, "BILLETERA", "3104567890");
        checkout.procesar("PED-003", 650000, "BILLETERA", "3104567890");
        checkout.procesar("PED-004", 320000, "GLOBALPAY", "ana@correo.com");
        checkout.procesar("PED-005", 520000, "GLOBALPAY", "ana@correo.com");
        checkout.procesar("PED-006", 70000, "GLOBAL_PAY", "ana@correo.com"); // error de digitacion
    }
}
