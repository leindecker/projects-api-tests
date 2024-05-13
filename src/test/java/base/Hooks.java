package base;

import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import org.junit.jupiter.api.BeforeAll;

import java.util.Optional;
import java.util.function.Predicate;

public class Hooks {
    private static final String PROFILE_ENV = "profile";
    private static final String DEFAULT_PROFILE = "local";

    @BeforeAll
    public static void setUp() {
        final var profile = Optional.ofNullable(System.getenv().get(PROFILE_ENV))
                .filter(Predicate.not(String::isEmpty))
                .orElse(DEFAULT_PROFILE);

        RequestManager.shared().setProfile(profile);

        RestAssuredConfig config = RestAssured.config()
                .httpClient(HttpClientConfig.httpClientConfig()
                        .setParam("http.connection.timeout", 600)
                        .setParam("http.socket.timeout", 2400));
        RestAssured.config = config;
    }

    public void teardown() {
        RequestManager.shared().teardownRequest();
        RequestManager.shared().teardownRequestResponse();
    }

}
