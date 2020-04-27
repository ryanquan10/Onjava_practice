package testenum;

public enum Status {
    NOT_FOUNT(404,"NOT_FOUNT"),
    SUCCESS(200,"success"),
    NOT_MODIFIED(304,"not_modified"),
    FORBIDDEN(403,"Forbiden"),
    ERROR(505,"server_occurrent_error");


    private int status;
    private String statusText;

    Status(int status, String statusText) {
        this.status = status;
        this.statusText = statusText;
    }
}
