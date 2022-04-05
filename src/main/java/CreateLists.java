import Lists.*;
import org.json.JSONException;
import static io.restassured.RestAssured.given;

public class CreateLists {
    static String body;

    public static void main(String[] args)  throws JSONException {
        Specification.installSpec(Specification.List(), Specification.responseSpec200());

        body = new CreateBulletedList().getBulletedList();
        given().body(body).when().post();

        body = new CreateIconList().getIconList();
        given().body(body).when().post();

        body = new CreateLabelList().getLabelList();
        given().body(body).when().post();

        body = new CreateLinkList().getLinkList();
        given().body(body).when().post();

        body = new CreateNumberList().getNumberedList();
        given().body(body).when().post();
    }
}
