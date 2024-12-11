package core.models;

public class Response<T, Error> {

    private T entity;
    private Error error;

    private int statusCode;

    public Response(T entity, int statusCode,Error error) {
        this.entity = entity;
        this.error = error;
        this.statusCode = statusCode;
    }


    public T getEntity() {
        return entity;
    }

    public Error getError() {
        return error;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
