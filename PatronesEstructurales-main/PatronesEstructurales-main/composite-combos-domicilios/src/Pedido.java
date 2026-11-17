import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private String cliente;
    // PROBLEMA: otra vez List<Object> y otra vez instanceof
    private List<Object> items = new ArrayList<>();

    public Pedido(String cliente) {
        this.cliente = cliente;
    }

    public void agregar(Object item) {
        items.add(item);
    }

    public void imprimirRecibo() {
        System.out.println("Pedido de " + cliente);
        System.out.println("----------------------------------------------");
        double total = 0;
        int productos = 0;
        for (Object item : items) {
            if (item instanceof Producto) {
                Producto p = (Producto) item;
                System.out.printf("%-36s %10s%n", p.getNombre(), Formato.pesos(p.getPrecio()));
                total += p.getPrecio();
                productos++;
            } else if (item instanceof Combo) {
                Combo c = (Combo) item;
                c.imprimir("");
                total += c.getPrecio();
                productos += c.contarProductos();
            }
        }
        System.out.println("----------------------------------------------");
        System.out.printf("%-36s %10s%n", "TOTAL (" + productos + " productos)", Formato.pesos(total));
    }
}
