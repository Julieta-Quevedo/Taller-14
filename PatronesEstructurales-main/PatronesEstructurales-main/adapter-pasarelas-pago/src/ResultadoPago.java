// Respuesta que entiende la tienda, venga de donde venga el pago.
public class ResultadoPago {
    private boolean aprobado;
    private String codigo;
    private String mensaje;

    public ResultadoPago(boolean aprobado, String codigo, String mensaje) {
        this.aprobado = aprobado;
        this.codigo = codigo;
        this.mensaje = mensaje;
    }

    public boolean isAprobado() {
        return aprobado;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public String toString() {
        return (aprobado ? "APROBADO  " : "RECHAZADO ") + codigo + "  " + mensaje;
    }
}
