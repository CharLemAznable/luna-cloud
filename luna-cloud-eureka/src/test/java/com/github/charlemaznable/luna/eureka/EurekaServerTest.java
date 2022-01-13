package com.github.charlemaznable.luna.eureka;

import com.github.charlemaznable.core.net.common.Mapping;
import com.github.charlemaznable.core.net.ohclient.OhClient;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.n3r.diamond.client.impl.MockDiamondServer;
import org.springframework.boot.test.context.SpringBootTest;

import static com.github.charlemaznable.core.net.ohclient.OhFactory.getClient;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.DEFINED_PORT;

@SpringBootTest(classes = EurekaServer.class,
        webEnvironment = DEFINED_PORT)
public class EurekaServerTest {

    @BeforeAll
    public static void beforeAll() {
        MockDiamondServer.setUpMockServer();
        MockDiamondServer.setConfigInfo("LunaCloud", "eureka", "" +
                "spring.application.name=test.eureka\n" +
                "server.servlet.context-path=/test-eureka\n" +
                "server.port=61222\n" +
                "eureka.client.register-with-eureka=false\n" +
                "eureka.client.fetch-registry=false\n" +
                "eureka.client.serviceUrl.defaultZone=http://localhost:${server.port}/test-eureka/eureka/\n");
    }

    @AfterAll
    public static void afterAll() {
        MockDiamondServer.tearDownMockServer();
    }

    private TestClient testClient = getClient(TestClient.class);

    @Test
    public void testEureka() {
        assertEquals(200, testClient.index());
    }

    @OhClient
    @Mapping("http://localhost:61222/test-eureka")
    public interface TestClient {

        @Mapping("/")
        int index();
    }
}
