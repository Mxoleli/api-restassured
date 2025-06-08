package api.tests;

import api.helpers.UserApiHelper;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*; // Import Matchers for assertions

@Epic("API Testing")
@Feature("User Management")
public class ApiTests {

    private UserApiHelper userApi;

    @BeforeClass
    public void setup() {
        userApi = new UserApiHelper();
    }

    @Test(description = "Verify fetching a single user by ID")
    @Story("Retrieve User Data")
    @Description("Tests the GET /users/{id} endpoint to ensure correct user data is returned for a valid ID.")
    public void testGetSingleUser() {
        int userId = 2;
        Response response = userApi.getSingleUser(userId);

        response.then()
                .statusCode(200)
                .body("data.id", equalTo(userId))
                .body("data.email", equalTo("janet.weaver@reqres.in"))
                .body("data.first_name", equalTo("Janet"))
                .body("data.last_name", equalTo("Weaver"))
                .body("support.url", notNullValue())
                .body("support.text", notNullValue());

        response.prettyPrint();
    }

    @Test(description = "Verify creating a new user")
    @Story("Create User Data")
    @Description("Tests the POST /users endpoint to create a new user and validate response.")
    public void testCreateUser() {
        String name = "morpheus";
        String job = "leader";

        Response response = userApi.createUser(name, job);

        response.then()
                .statusCode(201)
                .body("name", equalTo(name))
                .body("job", equalTo(job))
                .body("id", notNullValue())
                .body("createdAt", notNullValue());

        response.prettyPrint();
    }

    @Test(description = "Verify updating an existing user")
    @Story("Update User Data")
    @Description("Tests the PUT /users/{id} endpoint to update an existing user's job and validate response.")
    public void testUpdateUser() {
        int userId = 2;
        String newJob = "zion resident";

        Response response = userApi.updateUser(userId, "Janet", newJob); // Re-using existing user's name

        response.then()
                .statusCode(200)
                .body("name", equalTo("Janet"))
                .body("job", equalTo(newJob))
                .body("updatedAt", notNullValue());

        response.prettyPrint();
    }

    @Test(description = "Verify deleting a user")
    @Story("Delete User Data")
    @Description("Tests the DELETE /users/{id} endpoint to ensure successful deletion.")
    public void testDeleteUser() {
        int userId = 2;

        Response response = userApi.deleteUser(userId);

        response.then()
                .statusCode(204);

        Allure.addAttachment("Delete User Response Status", String.valueOf(response.getStatusCode()));
    }

    @Test(description = "Verify fetching a list of users on a specific page")
    @Story("Retrieve User Data")
    @Description("Tests the GET /users endpoint to ensure a list of users is returned for a given page number.")
    public void testGetListOfUsers() {
        int pageNumber = 2;
        Response response = userApi.getListOfUsers(pageNumber);

        response.then()
                .statusCode(200)
                .body("page", equalTo(pageNumber))
                .body("per_page", notNullValue())
                .body("total", notNullValue())
                .body("total_pages", notNullValue())
                .body("data", hasSize(6)) // Assuming 6 users per page based on reqres.in default
                .body("data[0].id", notNullValue())
                .body("data[0].email", notNullValue())
                .body("data[0].first_name", notNullValue())
                .body("data[0].last_name", notNullValue());

        response.prettyPrint();
    }
}