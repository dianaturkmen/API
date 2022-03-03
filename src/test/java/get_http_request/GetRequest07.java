package get_http_request;

import base_url.ReqresinBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class GetRequest07 extends ReqresinBaseUrl {

    /*
https://reqres.in/api/users URL request olustur.
body icerisindeki idsi 5 olan datayi
1) Matcher CLASS ile
2) JsonPath ile dogrulayin.
*/
    @Test
    public void test07(){
        spec01.pathParams("par1","api", "par2","users");
        Response response =given().spec(spec01).when().get("/{par1}/{par2}");
       // response.prettyPrint();
        response.then().assertThat().body("data[4].email", equalTo("charles.morris@reqres.in"),
                                                 "data[4].first_name", equalTo("Charles") ,
                                                    "data[4].last_name",equalTo("Morris"),
                                                    "data[4].avatar", equalTo("https://reqres.in/img/faces/5-image.jpg")) ;
        JsonPath json=response.jsonPath();
      //  System.out.println(json.getList("data.email"));
        //System.out.println(json.getString("data.first_name"));
        //System.out.println(json.getString("data.last_name"));
        Assert.assertEquals("charles.morris@reqres.in",json.getString("data[4].email"));
        Assert.assertEquals("Charles", json.getString("data[4].first_name"));
    }

}
