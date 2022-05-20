import io.restassured.http.ContentType;
import org.json.JSONException;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class GetOffer {

    public static void main(String[] args) throws JSONException {
        JSONObject body = new JSONObject();

        body.put("risId", "1424");
        body.put("appId", "DAM");
        body.put("mdmId", "1022021778");
        body.put("channelId", "DAM");
        body.put("timestamp", "1653041338113");

        String url = "http://wiremock.ds5-genr03-dsls-d0-dso.apps.ds5-genr03.corp.dev.vtb/bsc-wire-mock/getOffer";

        given().contentType(ContentType.JSON).body(body.toString()).when().post(url)
                .then().log().all();
    }
}
