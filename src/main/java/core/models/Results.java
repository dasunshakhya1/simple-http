package core.models;

public class Results<String, Error> {

    private String responseString;
    private Error error;
    private int statusCode;



    public Results(String responseString, int statusCode, Error error) {
        this.error = error;
        this.responseString = responseString;
        this.statusCode = statusCode;
    }

    public String getResponseString() {
        return responseString;
    }

    public void setResponseString(String responseString) {
        this.responseString = responseString;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }


    @Override
    public java.lang.String toString() {
        return "Results{" +
                "responseString=" + responseString +
                ", error=" + error +
                ", statusCode=" + statusCode +
                '}';
    }
}
