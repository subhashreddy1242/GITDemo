import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import Imports.payload;

public class Basics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Validate Add place API is working as expected
		//Add place-> Update Place -> Get Place to Validate
		
		//given - all input details
		//When - Submit API
		//Then - validate response				
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String res = given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(payload.Addplace()).when().post("/maps/api/place/add/json")
		.then().assertThat().statusCode(200).body("scope", equalTo("APP"))
		.header("Server", equalTo("Apache/2.4.41 (Ubuntu)")).extract().response().asString();
		
		System.out.println(res);
		
		JsonPath js = new JsonPath(res); //for parsing
		String placeid = js.getString("place_id");
		
		 System.out.println(placeid);
		 
		 String newaddress = "1420 MK Gold Coast, Vizag";
		 //Update Place
		 given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
		 .body("{\r\n"
		 		+ "\"place_id\":\""+placeid+"\",\r\n"
		 		+ "\"address\":\""+ newaddress +"\",\r\n"
		 		+ "\"key\":\"qaclick123\"\r\n"
		 		+ "}\r\n"
		 		+ "")
		 .when().put("maps/api/place/update/json")
		 .then().assertThat().log().all().statusCode(200).body("msg",equalTo("Address successfully updated"));
		
		 
		 //Get Place to check the address updated correctly
			String addressvar = given().log().all().queryParam("key", "qaclick123")
					.queryParam("place_id", placeid)
					.when().get("/maps/api/place/get/json")
					.then().assertThat().log().all().statusCode(200).extract().response().asString();
		
			System.out.println(addressvar);
			
			JsonPath js1 = new JsonPath(addressvar); //for parsing
			String actualaddress = js1.getString("address");
			
			System.out.println(actualaddress);
			
			Assert.assertEquals(actualaddress, newaddress);
	}

}
