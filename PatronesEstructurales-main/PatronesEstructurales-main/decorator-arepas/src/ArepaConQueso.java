// PROBLEMA: una subclase por cada combinacion de adiciones
public class ArepaConQueso extends Arepa {
    public String descripcion() {
        return "Arepa de maiz + queso";
    }

    public double precio() {
        return 3500 + 2500;
    }
}
