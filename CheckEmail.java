import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CheckEmail {

    @Test
    public void validateEmailOfUser5() throws UnirestException {
        HttpResponse<JsonNode> jsonResponse = Unirest.get("https://reqres.in/api/users/5").asJson();

        String email = jsonResponse.getBody().getObject()
                .getJSONObject("data")
                .getString("email");

        assertEquals("charles.morris@reqres.in", email);
    }
}

