// LIBRERIA EXTERNA (pasarela internacional): NO SE PUEDE MODIFICAR.
public class GlobalPayException extends Exception {
    private String errorCode;

    public GlobalPayException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
