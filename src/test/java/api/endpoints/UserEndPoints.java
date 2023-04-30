package api.endpoints;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;


public class UserEndPoints {

    public static Response createUser(User payload) {
        Response response=given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
        .when()
                .post(Routes.post_url);
        return response;
    }
    public static Response readUser() {
        Response response =given()
        .when()
                .get(Routes.get_url);
        return response;
    }
    public static Response updateUser(User payload) {
        Response response =given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
        .when()
                .put(Routes.update_url);
        return response;
    }
    public static Response deleteUser() {
        Response response =given()
        .when()

                .delete(Routes.delete_url);
        return response;
    }
}
