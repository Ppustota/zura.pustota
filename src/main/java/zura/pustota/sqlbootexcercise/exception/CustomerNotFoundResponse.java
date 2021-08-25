package zura.pustota.sqlbootexcercise.exception;

import java.time.LocalDate;

public class CustomerNotFoundResponse {
    private int method;
    private String message;

    public int getMethod() {
        return method;
    }

    public void setMethod(int method) {
        this.method = method;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
