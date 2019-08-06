package hello.world.server.clients;

import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.reactivex.Flowable;
import io.reactivex.Single;

import javax.inject.Singleton;
import java.util.Collections;
import java.util.List;

@Singleton
public class ProgrammaticAdminClient {

    private RxHttpClient httpClient;

    public ProgrammaticAdminClient(@Client("/admin") RxHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public List getListOfTasks() {
        HttpRequest<String> req = HttpRequest.GET("/tasks");
        Flowable<List> retrieve = httpClient.retrieve(req, Argument.of(List.class, String.class));
        return retrieve.blockingFirst();
    }

    public Single<List> getListOfTasksAsync() {
        HttpRequest<String> req = HttpRequest.GET("/tasks");
        return httpClient.retrieve(req, Argument.of(List.class, String.class)).first(Collections.singletonList("An error as occurred"));
    }

}
