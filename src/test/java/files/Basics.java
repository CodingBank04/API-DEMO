package files;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import static  io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;   //for equalTo methods

public class Basics {
   public static void main(String[] args) {
       // validate if add place api is working as expected
       //given- all input details
       //when-submit the api- resourse  should go under given method, http method

       //then-validate the response

       RestAssured.baseURI="https://rahulshettyacademy.com";
       String response =given().log().all().queryParam("key","qaclick123").header("Content-type","application/json")
               .body(payload.addPlace()).when().post("maps/api/place/add/json")
               //.then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP"))
               .then().assertThat().statusCode(200).body("scope", equalTo("APP"))

               .header("Server","Apache/2.4.18 (Ubuntu)").extract().response().asString();


      System.out.println(response);

       JsonPath js = new JsonPath(response); //for parsing json , this converts into actual json
       String placeId=js.getString("place_id"); // extracts place id

       System.out.println(placeId);


       // UPDATE place ->update place with new address -->get place to validate if new address present in response
       String newAddress="70 Summer walk, USA";


       given().log().all().queryParam("key", "qaclick123").header("Content-type","application/json")
               .body("{\n" +
                       "\"place_id\":\""+placeId+"\",\n" +
                       "\"address\":\""+newAddress+"\",\n" +
                       "\"key\":\"qaclick123\"\n" +
                       "}\n")
               .when().put("maps/api/place/update/json")
               .then().assertThat().log().all().statusCode(200).body("msg",equalTo("Address successfully updated"));

        //GET place
       String getPlaceResopnse=given().log().all().queryParam("key","qaclick123")
               .queryParam("place_id",placeId)
               .when().get("maps/api/place/get/json")
               .then().log().all().statusCode(200).extract().response().asString();
       //JsonPath js1=new JsonPath(getPlaceResopnse);
     JsonPath js1=  ReUsableMethods.rawToJson(getPlaceResopnse);
       String actualAddress= js1.getString("address");
       System.out.println(actualAddress);
       Assert.assertEquals(actualAddress,newAddress);
       //junit,Testng, Cucumber




    }

}
