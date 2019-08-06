package hello.world.server.clients;

import io.micronaut.context.ApplicationContext;
import io.micronaut.runtime.server.EmbeddedServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class KafkaDeclarativeAdminClientTest {

    private EmbeddedServer server;
    private DeclarativeAdminClient client;

    @Before
    public void setup() {
        server = ApplicationContext.run(EmbeddedServer.class);
        client = server.getApplicationContext().getBean(DeclarativeAdminClient.class);
    }

    @After
    public void cleanup() {
        server.stop();
    }

    @Test
    public void getTasksTest() {
        assertEquals(client.getListOfTasks(), Collections.singletonList("test"));
    }
}
