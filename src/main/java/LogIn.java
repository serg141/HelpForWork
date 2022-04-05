import io.restassured.http.ContentType;
import io.restassured.response.Response;
import lombok.Data;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class LogIn {

    public String logIn() {

        Specification user = new Specification();
        user.LogIn();

        Specification.installSpec(Specification.requestSpec(), Specification.responseSpec200());

        Response response = given()
                .body(user)
                .when()
                .post("/login");

        given()
                .cookie("JSESSIONID", response.getCookie("JSESSIONID"))
                .when()
                .get("/me");

        return response.getSessionId();
    }
}