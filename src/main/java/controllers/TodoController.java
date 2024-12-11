package controllers;

import core.HttpClientImpl;
import core.JsonParser;
import core.models.Error;
import core.models.Response;
import core.models.Results;
import models.Todo;

public class TodoController {


    public static Response<Todo, Error> getTodoById(int id) {
        String url = "https://jsonplaceholder.typicode.com/todos/" + id;
        Results<String, Error> results = HttpClientImpl.sendGETRequest(url);
        Todo todo = JsonParser.convertJsonStringToObject(Todo.class, results.getResponseString());
        Error error = results.getError();
        return new Response<>(todo, results.getStatusCode(), error);
    }
}
