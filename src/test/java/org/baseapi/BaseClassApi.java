package org.baseapi;

import io.restassured.path.json.JsonPath;

public class BaseClassApi {
	
	public static JsonPath rawToJson(String response) {
		JsonPath js= new JsonPath(response);
		return js;
		
	}

}
