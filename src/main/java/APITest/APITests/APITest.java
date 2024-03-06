package APITest.APITests;

import APITest.APIStrings.APIStrings;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.annotations.BeforeClass;

import static org.testng.AssertJUnit.assertEquals;

public class APITest {
    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = APIStrings.baseURI ;
    }

    @Test
    public void testCountingPostsForUser() {
        Object[][] testData = {{5, 10}, {7, 10}, {9, 10}};
        for (Object[] data : testData) {
            int userId = (int) data[0];
            int expectedNumPosts = (int) data[1];
            Response response = RestAssured.get(APIStrings.postsUserIdEndPoint + userId);
            int actualNumPosts = response.jsonPath().getList("$").size();
            assertEquals("Number of posts for user " + userId + " is incorrect", expectedNumPosts, actualNumPosts);
        }
    }

    @Test
    public void testUniqueIDPerPost() {
        Response response = RestAssured.get(APIStrings.postsEndPoint);
        int numPosts = response.jsonPath().getList("$").size();
        for (int i = 0; i < numPosts; i++) {
            int postId = response.jsonPath().get("[" + i + "].id");
            for (int j = i + 1; j < numPosts; j++) {
                int nextPostId = response.jsonPath().get("[" + j + "].id");
                assert postId != nextPostId;
            }
        }
    }


}

