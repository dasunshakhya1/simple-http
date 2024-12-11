package e2e;

import controllers.TodoController;
import core.models.Error;
import core.models.Response;
import models.Todo;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestTodoController {


    @Test
    public void testGetTodoById() {
        Response<Todo, Error> response = TodoController.getTodoById(1);
        Todo todo = response.getEntity();
        Error error = response.getError();


        Assert.assertNull(error);
        Assert.assertNotNull(todo);
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(todo.getTitle(), "delectus aut autem");

    }
}
