package hello.world.server.clients;

import io.micronaut.context.ApplicationContext;
import io.micronaut.runtime.server.EmbeddedServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ProgrammaticAdminClientTest {

    private EmbeddedServer server;
    private ProgrammaticAdminClient client;

    @Before
    public void setup() {
        server = ApplicationContext.run(EmbeddedServer.class);
        client = server.getApplicationContext().getBean(ProgrammaticAdminClient.class);
    }

    @After
    public void cleanup() {
        server.stop();
    }

    @Test
    public void testListOfTaks() {
        List<String> topicList = new ArrayList<>();
        topicList.add("test");
        assertEquals( topicList,client.getListOfTasks());
    }

    @Test
    public void testListOfTasksAsync() {
        assertEquals( Collections.singletonList("test"),
                client.getListOfTasksAsync().blockingGet());

    }
}
