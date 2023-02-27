import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class UpdateUser {

    @Test
    public void updateUserWithNewInformation() throws UnirestException {
        String requestBody = "{\"name\": \"John Doe\", \"job\": \"QA Engineer\"}";

        HttpResponse<JsonNode> jsonResponse = Unirest.patch("https://reqres.in/api/users/4")
                .header("Content-Type", "application/json")
                .body(requestBody)
                .asJson();


        assertEquals(200, jsonResponse.getStatus());


        String responseBody = jsonResponse.getBody().getObject().toString();
        System.out.println(responseBody);
        assertEquals(true, responseBody.contains("John Doe"));
        assertEquals(true, responseBody.contains("QA Engineer"));
    }
}

