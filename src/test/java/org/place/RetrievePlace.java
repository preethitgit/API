package org.place;

import static io.restassured.RestAssured.given;

import org.body.PayLoad;
import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static org.hamcrest.Matchers.*;

import org.baseapi.BaseClassApi;

public class RetrievePlace {
	public static void main(String[] args) {
		
		String newAddress= "50 Guindy , Chennai";
		//Mention the base URI
		RestAssured.baseURI="https://rahulshettyacademy.com";
		
		String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json").body(PayLoad.addPlace()).
		when().post("/maps/api/place/add/json").
		then().assertThat().statusCode(200).body("scope", equalTo("APP")).header("Server", equalTo("Apache/2.4.52 (Ubuntu)")).
		extract().response().asString();
		
		System.out.println(response);

		JsonPath js = new JsonPath(response);
		String placeid = js.getString("place_id");
		System.out.println(placeid);
		
		//update the place
		System.out.println("Update Place");
		given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json").body("{\r\n" + 
				"\"place_id\":\""+placeid+"\",\r\n" + 
				"\"address\":\"50 Guindy , Chennai\",\r\n" + 
				"\"key\":\"qaclick123\"\r\n" + 
				"}\r\n" + 
				"").when().put("/maps/api/place/update/json").
		then().log().all().assertThat().statusCode(200).body("msg", equalTo("Address successfully updated"));
		
		//Get the place
		System.out.println("Get Place");
		
		String getPlaceReponse = given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeid).
		when().get("/maps/api/place/get/json").
		then().assertThat().statusCode(200).extract().response().asString();
		
		System.out.println(getPlaceReponse);
		
		JsonPath js1= BaseClassApi.rawToJson(getPlaceReponse);
		String actualAddress = js1.getString("address");
		System.out.println(actualAddress);
		
		//TestNG Validation Using Assert
		Assert.assertEquals(actualAddress, newAddress);
		System.out.println("PASS");
		
		
		
		//Delete the place
		System.out.println("Delete Place");
		 given().log().all().queryParam("key", "qaclick123").body("{\r\n" + 
				"    \"place_id\":\""+placeid+"\"\r\n" + 
				"}\r\n" + 
				"").
		when().delete("/maps/api/place/delete/json").
		then().log().all().assertThat().statusCode(200).body("status", equalTo("OK"));
		 

		//Get the deleted place
		 System.out.println(" Get Deleted place");
		 
		 given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeid).
			when().get("/maps/api/place/get/json").
			then().log().all().assertThat().statusCode(404).body("msg", equalTo("Get operation failed, looks like place_id  doesn't exists"));
		
	}
}
