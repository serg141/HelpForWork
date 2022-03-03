import Lists.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONException;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class CreateLists {
    static String body;

    public static void main(String[] args)  throws JSONException {
        String login = "vtb4040204";
        String pass = "141523Pota#";
        String url = "http://dsls-dam-develop.ds5-genr03-dsls-d0-dso.apps.ds5-genr03.corp.dev.vtb";

        JSONObject user = new JSONObject();
        user.put("login", login);
        user.put("pass", pass);

        Response response = given()
                .contentType(ContentType.JSON)
                .body(user.toString())
                .when()
                .post(url + "/login")
                .then().statusCode(200)
                .extract().response();

        given()
                .cookie("JSESSIONID", response.getCookie("JSESSIONID"))
                .contentType(ContentType.JSON)
                .when()
                .get(url + "/me")
                .then().statusCode(200);

        body = new CreateBulletedList().getBulletedList();
        given()
                .cookie("JSESSIONID", response.getCookie("JSESSIONID"))
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post(url + "/lists")
                .then().statusCode(200)
                .extract().response();

        body = new CreateIconList().getIconList();
        given()
                .cookie("JSESSIONID", response.getCookie("JSESSIONID"))
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post(url + "/lists")
                .then().statusCode(200);

        body = new CreateLabelList().getLabelList();
        given()
                .cookie("JSESSIONID", response.getCookie("JSESSIONID"))
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post(url + "/lists")
                .then().statusCode(200);

        body = new CreateLinkList().getLinkList();
        given()
                .cookie("JSESSIONID", response.getCookie("JSESSIONID"))
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post(url + "/lists")
                .then().statusCode(200);

        body = new CreateNumberList().getNumberedList();
        given()
                .cookie("JSESSIONID", response.getCookie("JSESSIONID"))
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post(url + "/lists")
                .then().statusCode(200);
    }
}
