package com.github.charlemaznable.luna.consumer;

import com.github.charlemaznable.core.net.common.Mapping;
import com.github.charlemaznable.core.net.common.Parameter;
import com.github.charlemaznable.core.net.ohclient.OhClient;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.n3r.diamond.client.impl.MockDiamondServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.discovery.DiscoveryClient;

import java.time.Duration;

import static com.github.charlemaznable.core.net.ohclient.OhFactory.getClient;
import static org.awaitility.Awaitility.await;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.DEFINED_PORT;

@SpringBootTest(classes = ConsumerServer.class,
        webEnvironment = DEFINED_PORT)
public class ConsumerServerTest {

    @BeforeAll
    public static void beforeAll() {
        MockDiamondServer.setUpMockServer();
        MockDiamondServer.setConfigInfo("LunaCloud", "consumer", "" +
                "spring.application.name=test.consumer\n" +
                "server.port=61224\n" +
                "eureka.client.serviceUrl.defaultZone=http://localhost:${server.port}/eureka/\n");
    }

    @AfterAll
    public static void afterAll() {
        MockDiamondServer.tearDownMockServer();
    }

    private TestClient testClient = getClient(TestClient.class);
    @Autowired
    private DiscoveryClient discoveryClient;

    @Test
    public void testConsumer() {
        assertEquals("hello Adam，this is a empty world.", testClient.produce("Adam"));
        await().forever().pollInterval(Duration.ofSeconds(5)).until(() ->
                discoveryClient.getServices().contains("test.consumer"));
        assertEquals("hello dear Bob，this is a empty world.", testClient.consume("Bob"));
    }

    @OhClient
    @Mapping("http://localhost:61224")
    public interface TestClient {

        @Mapping("/produce")
        String produce(@Parameter("name") String name);

        @Mapping("/consume")
        String consume(@Parameter("name") String name);
    }
}
