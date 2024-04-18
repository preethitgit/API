package org.place;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import org.body.PayLoad;

public class CreatePlace {
public static void main(String[] args) {
	//Mention the base URI
	RestAssured.baseURI="https://rahulshettyacademy.com";
	
	given().queryParam("key", "qaclick123").header("Content-Type", "application/json").body(PayLoad.addPlace()).
	when().post("/maps/api/place/add/json").then().log().all().assertThat().statusCode(200);
	

}
}
