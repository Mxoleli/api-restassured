package api.specifications;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import utils.ConfigReader;

public class RequestSpecProvider {

    // Common request specification for most API calls
    public static RequestSpecification getCommonRequestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(ConfigReader.get("api.base.url"))
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .build();
    }

    // Example for a request that might need specific authentication (e.g., Bearer token)
    public static RequestSpecification getAuthenticatedRequestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(ConfigReader.get("api.base.url"))
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .addHeader("x-api-key", (ConfigReader.get("api.key")))
                .build();
    }

    // Example for a request with form parameters
    public static RequestSpecification getFormUrlEncodedRequestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(ConfigReader.get("api.base.url"))
                .setContentType(ContentType.URLENC)
                .build();
    }
}