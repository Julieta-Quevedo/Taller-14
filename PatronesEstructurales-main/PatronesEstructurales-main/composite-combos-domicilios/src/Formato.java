import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class Formato {
    public static String pesos(double valor) {
        DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
        simbolos.setGroupingSeparator('.');
        return "$" + new DecimalFormat("#,##0", simbolos).format(valor);
    }
}
