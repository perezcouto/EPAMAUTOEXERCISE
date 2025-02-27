package util;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class RestAssuredUtil {
    //Sets Base URI
    public static void setBaseURI() {
        
    	 RestAssured.baseURI = "https://jsonplaceholder.typicode.com/";
        
    }

    //Sets base path
    public static void setBasePath(String basePathTerm) {
        RestAssured.basePath = basePathTerm;
    }

    //Reset Base URI (after test)
    public static void resetBaseURI() {
        RestAssured.baseURI = null;
    }

    //Reset base path
    public static void resetBasePath() {
        RestAssured.basePath = null;
    }

    //Sets ContentTyp 
    public static void setContentType(ContentType Type) {
        given().contentType(Type);
    }

    //Returns response by given path
    public static Response getResponse(String path) {
        return given().get(path);
    }

    
  //Returns response by given path
    public static Response getResponsePost(String requestBody,String path) {
        
    	return given()
        .header("Content-type", "application/json")
        .and()
        .body(requestBody)
        .when()
        .post(path)
        .then()
        .extract().response();
    	
    	
    }
  //Returns response by given path
    public static Response getResponsePut(String requestBody,String path) {
        
    	return given()
        .header("Content-type", "application/json")
        .and()
        .body(requestBody)
        .when()
        .put(path)
        .then()
        .extract().response();
	    	
    }
  
  //Returns response by given path
    public static Response getResponsePatch(String requestBody,String path) {
        
    	return given()
        .header("Content-type", "application/json")
        .and()
        .body(requestBody)
        .when()
        .patch(path)
        .then()
        .extract().response();
	    	
    }
  
    
    
  //Returns response by given path
    public static Response getResponseDelete(String path) {
        
    	return given()
        .header("Content-type", "application/json")
        .and()
        .when()
        .delete(path)
        .then()
        .extract().response();
	    	
    }
    
    //Returns response
    public static Response getResponse() {
        return given().get();
    }

    //Returns JsonPath object
    public static JsonPath getJsonPath(Response res) {
        String json = res.asString();
        return new JsonPath(json);
    }
}