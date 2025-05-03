package core;

public enum StatusCode {

    SUCCESS(200,"The Request is Succeeded"),

    CREATED(201,"A new resource has been created"),

    BAD_REQUEST(400,"Missing required field name"),

    UNAUTHORIZED(401,"Invalid access token"),

    NOT_FOUND(404 , "Connot Find required resourse"),

    NO_Content(204,"No content to send in the response body");

    public final int code;
    public final String message;

    StatusCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
