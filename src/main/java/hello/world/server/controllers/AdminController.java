package hello.world.server.controllers;

import hello.world.server.services.TaskService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;

import javax.inject.Inject;
import java.util.List;

@Controller("/admin")
public class AdminController {

    @Inject
    private TaskService taskService;

    @Get("/tasks")
    public List<String> getListOfTodos() {
        return taskService.getTaskList();
    }

    @Post(value = "/tasks", consumes = MediaType.TEXT_PLAIN)
    public String createTodo(@Body String name) {
        return taskService.createTask(name);
    }

}
