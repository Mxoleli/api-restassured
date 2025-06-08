package api.helpers;
import api.specifications.RequestSpecProvider;
import common.Endpoints;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

public class UserApiHelper {

    private final RequestSpecification requestSpec;

    // Constructor to initialize with a common request specification
    public UserApiHelper() {
        this.requestSpec = RequestSpecProvider.getAuthenticatedRequestSpec();
    }

    // Constructor to allow different request specifications (e.g., authenticated)
    public UserApiHelper(RequestSpecification customRequestSpec) {
        this.requestSpec = customRequestSpec;
    }

    @Step("Get list of users with page: {0}")
    public Response getListOfUsers(int page) {
        return given()
                .spec(requestSpec)
                .queryParam("page", page)
                .when()
                .get(Endpoints.GET_LIST_USERS);
    }

    @Step("Get single user by ID: {0}")
    public Response getSingleUser(int userId) {
        return given()
                .spec(requestSpec)
                .pathParam("id", userId)
                .when()
                .get(Endpoints.GET_SINGLE_USER);
    }

    @Step("Create a new user with name: {0}, job: {1}")
    public Response createUser(String name, String job) {
        // You could also pass a Pojo (Plain Old Java Object) instead of a String/Map
        String requestBody = String.format("{\"name\": \"%s\", \"job\": \"%s\"}", name, job);
        return given()
                .spec(requestSpec)
                .body(requestBody)
                .when()
                .post(Endpoints.CREATE_USER);
    }

    @Step("Update user ID: {0} with name: {1}, job: {2}")
    public Response updateUser(int userId, String name, String job) {
        String requestBody = String.format("{\"name\": \"%s\", \"job\": \"%s\"}", name, job);
        return given()
                .spec(requestSpec)
                .pathParam("id", userId)
                .body(requestBody)
                .when()
                .put(Endpoints.UPDATE_USER);
    }

    @Step("Delete user ID: {0}")
    public Response deleteUser(int userId) {
        return given()
                .spec(requestSpec)
                .pathParam("id", userId)
                .when()
                .delete(Endpoints.DELETE_USER);
    }
}