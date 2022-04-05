import java.io.File;
import static io.restassured.RestAssured.given;

public class CreateSlider {

    public static void main(String[] args) {
        Specification.installSpec(Specification.Template(), Specification.responseSpec200());
        given()
                .multiPart("thumbnail", new File("C:\\Users\\skamy\\Desktop\\Picture\\33.png"),
                        "image/png")
                .multiPart("template", new File("C:\\Users\\skamy\\Desktop\\yaml\\json\\template\\" +
                                "Slider_JSON.json"),
                        "application/json")
                .when().post();
    }
}
