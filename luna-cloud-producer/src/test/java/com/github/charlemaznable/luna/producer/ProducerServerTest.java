package com.github.charlemaznable.luna.producer;

import com.github.charlemaznable.core.net.common.Mapping;
import com.github.charlemaznable.core.net.common.Parameter;
import com.github.charlemaznable.core.net.ohclient.OhClient;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.n3r.diamond.client.impl.MockDiamondServer;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;

import static com.github.charlemaznable.core.net.ohclient.OhFactory.getClient;
import static org.awaitility.Awaitility.await;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.DEFINED_PORT;

@SpringBootTest(classes = ProducerServer.class,
        webEnvironment = DEFINED_PORT)
public class ProducerServerTest {

    @BeforeAll
    public static void beforeAll() {
        MockDiamondServer.setUpMockServer();
        MockDiamondServer.setConfigInfo("LunaCloud", "producer", "" +
                "spring.application.name=test.producer\n" +
                "server.port=61223\n" +
                "eureka.client.serviceUrl.defaultZone=http://localhost:${server.port}/eureka/\n");
    }

    @AfterAll
    public static void afterAll() {
        MockDiamondServer.tearDownMockServer();
    }

    private TestClient testClient = getClient(TestClient.class);

    @Test
    public void testEureka() {
        assertEquals("hello Adam，this is a empty world.", testClient.produce("Adam"));
        await().forever().pollInterval(Duration.ofSeconds(5)).untilAsserted(() ->
                assertEquals("hello dear Bob，this is a empty world.", testClient.consume("Bob")));
    }

    @OhClient
    @Mapping("http://localhost:61223")
    public interface TestClient {

        @Mapping("/produce")
        String produce(@Parameter("name") String name);

        @Mapping("/consume")
        String consume(@Parameter("name") String name);
    }
}
