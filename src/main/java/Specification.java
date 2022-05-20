import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import lombok.Data;

@Data
public class Specification {
    private String login;
    private String pass;

    static String logIn = new LogIn().logIn();

    public static RequestSpecification requestSpec() {
        String url = "http://dsls-dam-develop.ds5-genr03-dsls-d0-dso.apps.ds5-genr03.corp.dev.vtb";
        return new RequestSpecBuilder()
                .setBaseUri(url)
                .setContentType(ContentType.JSON)
                .build();
    }

    public static RequestSpecification List() {
        String url = "http://dsls-dam-develop.ds5-genr03-dsls-d0-dso.apps.ds5-genr03.corp.dev.vtb/lists";
        return new RequestSpecBuilder()
                .setSessionId("JSESSIONID", logIn)
                .setBaseUri(url)
                .setContentType(ContentType.JSON)
                .build();
    }

    public static RequestSpecification Template() {
        String url = "http://dsls-dam-develop.ds5-genr03-dsls-d0-dso.apps.ds5-genr03.corp.dev.vtb/templates";
        return new RequestSpecBuilder()
                .setSessionId("JSESSIONID", logIn)
                .setBaseUri(url)
                .setContentType(ContentType.MULTIPART)
                .build();
    }

    public static ResponseSpecification responseSpec200() {
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();
    }

    public static void installSpec(RequestSpecification request, ResponseSpecification response) {
        RestAssured.requestSpecification = request;
        RestAssured.responseSpecification = response;
    }

    public void LogIn() {
        this.login = "vtb4040204";
        this.pass = "141523Pota!!";
    }
}
