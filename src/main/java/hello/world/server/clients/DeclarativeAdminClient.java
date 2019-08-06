package hello.world.server.clients;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;

import java.util.List;

@Client("/admin")
public interface DeclarativeAdminClient {

    @Get("/tasks")
    List<String> getListOfTasks();
}
