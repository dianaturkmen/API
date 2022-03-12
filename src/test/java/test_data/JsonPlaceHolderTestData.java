package test_data;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class JsonPlaceHolderTestData {

    public Map<String, Object> setUpTestData(){

        HashMap<String, Object> expectedData = new HashMap<>();
        expectedData.put("statusCode", 200);
        expectedData.put("completed", false);
        expectedData.put("userId", 1);
        expectedData.put("via", "1.1 vegur");
        expectedData.put("title","quis ut nam facilis et officia qui");
        expectedData.put("Server", "cloudflare");
        return expectedData;
    }

    /*
    "userId": 55,
    "title": "Tidy your room",
    "completed": false
  }
  {
    "userId": 55,
    "title": "Tidy your room",
    "completed": false,
    "id": …
   }
*/
public JSONObject setUpPostData() {
    JSONObject expectedRequested = new JSONObject();
    expectedRequested.put("userId",55);
    expectedRequested.put("title","Tidy your room");
    expectedRequested.put( "completed",false);
    expectedRequested.put("statusCode", 201);
    expectedRequested.put("id", 201);
    return expectedRequested;

}
}
