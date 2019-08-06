package hello.world.server.services;

import javax.inject.Singleton;
import java.util.Collections;
import java.util.List;

@Singleton
public class TaskService {

    public List<String> getTaskList() {
        return Collections.singletonList("test");
    }

    public String createTask(String task) {
        return null;
    }
}
