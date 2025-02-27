import org.testng.annotations.Test;


/*
 * @author Juan Carlos Perez Couto
 * Positive and Negative Test Cases for validating API https://jsonplaceholder.typicode.com
 * 
 */

public class PositiveNegtiveCasesApiTest extends BaseTest {

    @Test (priority = 1)
    public void T01_StatusCodeGetPostsTest() {
       
    	res = util.RestAssuredUtil.getResponse("/posts");
    	testUtil.checkStatusIs200(res);
       
        System.out.println(res.asString());
        
    
    }

    
    @Test (priority = 2)
    public void T02_StatusCodeGetPostsByIdTest() {
       
    	res = util.RestAssuredUtil.getResponse("/posts/1");
    	testUtil.checkStatusIs200(res);
       
        System.out.println(res.asString());
        
    
    }
    
    @Test (priority = 3)
    public void T03_StatusCodeGetCommentsFromPostIdTest() {
        
    	res = util.RestAssuredUtil.getResponse("/posts/1/comments");
    	testUtil.checkStatusIs200(res);
        
        System.out.println(res.asString());
        
    
    }
    
    
    @Test (priority = 4)
    public void T04_StatusCodeGetCommentsByPostIdTest() {
        
    	res = util.RestAssuredUtil.getResponse("/comments?postId=1");
    	testUtil.checkStatusIs200(res);
       
        System.out.println(res.asString());
        
    
    }
    
    
    @Test (priority = 5)
    public void T05_CreatePost() {
    	String requestBody = "{\n" +
                "\"postId\": \"1\",\n" +
                "\"name\": \"vero eaque aliquid doloribus et culpa\",\n" +
                "\"email\": \"luisinovasiss@gmail.com\",\n" +
                "\"body\": \"SDET\"\n}";
    	 
    	res = util.RestAssuredUtil.getResponsePost(requestBody, "https://jsonplaceholder.typicode.com/posts");
        testUtil.checkStatusIs201(res);
       
      }
    
    @Test (priority = 6)
    public void T06_UpdatePost() {
    	String requestBody = "{\n" +
                "\"postId\": \"1\",\n" +
                "\"name\": \"vero eaque aliquid doloribus et culpa\",\n" +
                "\"email\": \"luisinovasiss@gmail.com\",\n" +
                "\"body\": \"SDET Java RestAssured\"\n}";
    	 
    	 
    	res = util.RestAssuredUtil.getResponsePut(requestBody, "https://jsonplaceholder.typicode.com/posts/5");
        testUtil.checkStatusIs200(res);
       
      }
    
    
    @Test (priority = 7)
    public void T07_PatchPost() {
    	String requestBody = "{\n" +
                "\"postId\": \"1\",\n" +
                "\"name\": \"vero eaque aliquid doloribus et culpa\",\n" +
                "\"body\": \"SDET Java RestAssured\"\n}";
    	 
    	 
    	res = util.RestAssuredUtil.getResponsePatch(requestBody, "https://jsonplaceholder.typicode.com/posts/9");
        testUtil.checkStatusIs200(res);
       
      }
    
    @Test (priority = 8)
    public void T08_DeletePost() {
    	
    	 
    	res = util.RestAssuredUtil.getResponseDelete( "https://jsonplaceholder.typicode.com/posts/4");
        testUtil.checkStatusIs200(res);
       
      }
    
    
    @Test (priority = 9)
    public void T09_StatusCodeGetPostsByNoValidIdTest() {
    	res = util.RestAssuredUtil.getResponse("/posts/lp");
    	testUtil.checkStatusIs404(res);
       
    }
    
    @Test (priority = 10)
    public void T10_StatusCodeGetCommentsFromNotValidPostIdTest() {
        
    	res = util.RestAssuredUtil.getResponse("/posts/lp/comments");
    	testUtil.checkStatusIs200(res);
      
    }
    
   
    @Test (priority = 11)
    public void T11_UpdateNoValidUrlPost() {
    	String requestBody = "{\n" +
                "\"postId\": \"1\",\n" +
                "\"name\": \"vero eaque aliquid doloribus et culpa\",\n" +
                "\"email\": \"luisinovasiss@gmail.com\",\n" +
                "\"body\": \"SDET Java RestAssured\"\n}";
    	 
    	 
    	res = util.RestAssuredUtil.getResponsePut(requestBody, "https://jsonplaceholder.typicode.com/posts/lp");
        testUtil.checkStatusIs500(res);
       
      }
    
   
}
