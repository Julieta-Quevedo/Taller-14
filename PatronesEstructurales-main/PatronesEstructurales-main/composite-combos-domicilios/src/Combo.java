import java.util.ArrayList;
import java.util.List;

public class Combo {
    private String nombre;
    private double descuento; // 0.10 = 10 %
    // PROBLEMA: lista de Object; adentro puede ir un Producto o un Combo
    private List<Object> items = new ArrayList<>();

    public Combo(String nombre, double descuento) {
        this.nombre = nombre;
        this.descuento = descuento;
    }

    public void agregar(Object item) {
        items.add(item);
    }

    // PROBLEMA: cada metodo pregunta "que eres?" con instanceof y hace cast
    public double getPrecio() {
        double suma = 0;
        for (Object item : items) {
            if (item instanceof Producto) {
                suma += ((Producto) item).getPrecio();
            } else if (item instanceof Combo) {
                suma += ((Combo) item).getPrecio();
            }
        }
        return suma * (1 - descuento);
    }

    public int contarProductos() {
        int total = 0;
        for (Object item : items) {
            if (item instanceof Producto) {
                total++;
            } else if (item instanceof Combo) {
                total++; // ERROR: cuenta el combo como 1 producto
            }
        }
        return total;
    }

    public void imprimir(String sangria) {
        String titulo = sangria + nombre + " (-" + Math.round(descuento * 100) + "%)";
        System.out.printf("%-36s %10s%n", titulo, Formato.pesos(getPrecio()));
        for (Object item : items) {
            if (item instanceof Producto) {
                Producto p = (Producto) item;
                System.out.printf("%-36s %10s%n", sangria + "   " + p.getNombre(), Formato.pesos(p.getPrecio()));
            } else if (item instanceof Combo) {
                ((Combo) item).imprimir(sangria + "   ");
            }
        }
    }
}
