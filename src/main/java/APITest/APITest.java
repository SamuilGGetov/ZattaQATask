package APITest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.annotations.BeforeClass;

import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class APITest {
    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    @Test
    public void testUserPostsCount() {

        int userId = 5;
        int expectedPosts = 10;

//        RestAssured.given().
//                queryParam("userId", userId).
//                when().
//                get("/posts").
//                then().
//                assertThat().
//                body("size()", is(expectedPosts));
    }

    @Test
    public void testUniqueIdsForPosts() {
        Response response =
                        RestAssured.given().
                        when().
                        get("/posts").
                        then().
                        extract().response();

           List<Integer> ids = response.jsonPath().getList("id", Integer.class);

           long uniqueCount = ids.stream().distinct().count();

          assertEquals("IDs should be unique for each post", ids.size(), uniqueCount);
    }

}

