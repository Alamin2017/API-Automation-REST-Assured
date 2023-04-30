package api.test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class UserTests {
    Faker faker;
    User userPayload;
    @BeforeSuite
    public void setupData()
    {
        faker=new Faker();
        userPayload=new User();
        userPayload.setName(faker.name().toString());
        userPayload.setJob(faker.name().toString());
    }
    @Test(priority = 1)
    public void testPostUser()
    {
        Response response =UserEndPoints.createUser(userPayload);
        response.then().log().all();
        System.out.println("Test POST USER");

    }
    @Test(priority = 2)
    public void testGetUser()
    {
        Response response =UserEndPoints.readUser();
        response.then().log().all();
        System.out.println("Test Get USER");
    }
    @Test(priority = 3)
    public void testUpdateUser()
    {
        Response response =UserEndPoints.updateUser(userPayload);
        response.then().log().all();
        System.out.println("Test Update USER");
    }
    @Test(priority = 3)
    public void testDeleteUser()
    {
        Response response =UserEndPoints.deleteUser();
        response.then().log().all();
        System.out.println("Test Delete USER");
    }
}
