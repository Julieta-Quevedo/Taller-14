public class Main {
    public static void main(String[] args) {
        Arepa[] pedido = {
            new Arepa(),
            new ArepaConQueso(),
            new ArepaConQuesoYHuevo(),
            new ArepaConQuesoHuevoYChorizo()
        };
        for (Arepa a : pedido) {
            System.out.printf("%-42s $%.0f%n", a.descripcion(), a.precio());
        }

        // NUEVO REQUISITO: adicion de aguacate y la opcion "doble queso".
        // Con 3 adiciones ya hay 8 combinaciones posibles; con 4 serian 16 clases.
        // Y "doble queso" no se puede: cada clase lleva cada adicion una sola vez.
    }
}
