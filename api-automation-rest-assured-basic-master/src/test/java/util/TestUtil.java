package util;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.testng.Assert;

public class TestUtil {
    //Verify the http response status returned. Check Status Code is 200?
    public void checkStatusIs200(Response res) {
        Assert.assertEquals(res.getStatusCode(), 200, "Status Check Failed!");
    }

  //Verify the http response status returned. Check Status Code is 201?
    public void checkStatusIs201(Response res) {
        Assert.assertEquals(res.getStatusCode(), 201, "Status Check Failed!");
    }
    
  //Verify the http response status returned. Check Status Code is 204?
    public void checkStatusIs204(Response res) {
        Assert.assertEquals(res.getStatusCode(), 204, "Status Check Failed!");
    }
    
  //Verify the http response status returned. Check Status Code is 404?
    public void checkStatusIs404(Response res) {
        Assert.assertEquals(res.getStatusCode(), 404, "Status Check Failed!");
    }
    
  //Verify the http response status returned. Check Status Code is 500?
    public void checkStatusIs500(Response res) {
        Assert.assertEquals(res.getStatusCode(), 500, "Status Check Failed!");
    }
    
}
