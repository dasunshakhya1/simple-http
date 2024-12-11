package core;

import core.models.Error;
import core.models.Results;
import okhttp3.*;

import java.io.IOException;

public class HttpClientImpl {
    private static final OkHttpClient CLIENT = new OkHttpClient();


    private static Results<String, Error> executeRequest(Request request) {
        Results<String, Error> results;
        String responseBody = "";
        try (Response response = CLIENT.newCall(request).execute()) {
            int code = response.code();

            if (response.body() != null) {
                responseBody = response.body().string();
            }
            if (code >= 200 && code < 300) {
                results = new Results<>(responseBody, code, null);
            } else {
                results = new Results<>(null, code, new Error(responseBody));
            }
        } catch (IOException e) {
            results = new Results<>(e.getMessage(), -1, new Error(e.getMessage()));
        }

        return results;
    }


    public static Results<String, Error> sendGETRequest(String url) {
        Request request = new Request.Builder()
                .url(url)
                .build();

        return executeRequest(request);
    }


    public static Results<String, Error> sendPOSTRequest(String url, String payload) {
        RequestBody requestBody = RequestBody.create(payload, MediaType.get("application/json"));
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        return executeRequest(request);
    }
}
