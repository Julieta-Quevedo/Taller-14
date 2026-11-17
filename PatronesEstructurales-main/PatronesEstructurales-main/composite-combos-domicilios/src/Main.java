public class Main {
    public static void main(String[] args) {
        Combo hamburguesa = new Combo("Combo Hamburguesa", 0.05);
        hamburguesa.agregar(new Producto("Hamburguesa", 18000));
        hamburguesa.agregar(new Producto("Papas", 6000));
        hamburguesa.agregar(new Producto("Gaseosa", 4500));

        Combo perro = new Combo("Combo Perro", 0.05);
        perro.agregar(new Producto("Perro caliente", 12000));
        perro.agregar(new Producto("Papas", 6000));
        perro.agregar(new Producto("Gaseosa", 4500));

        Combo familiar = new Combo("Combo Familiar", 0.10);
        familiar.agregar(hamburguesa);
        familiar.agregar(perro);
        familiar.agregar(new Producto("Malteada", 9000));

        Pedido pedido = new Pedido("Laura - Cra 70 # 64-20");
        pedido.agregar(familiar);
        pedido.agregar(new Producto("Arepa de choclo", 7000));
        pedido.agregar("Gaseosa"); // compila... y se pierde sin aviso

        pedido.imprimirRecibo();
    }
}
