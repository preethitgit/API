package org.body;

public class PayLoad {

	public static String addPlace() {
		
		String s = "{\r\n" + 
				"				  \"location\": {\r\n" + 
				"		    \"lat\": -38.383494,\r\n" + 
				"		    \"lng\": 33.427362\r\n" + 
				"		  },\r\n" + 
				"		  \"accuracy\": 50,\r\n" + 
				"		  \"name\": \"Infosys Technologies\",\r\n" + 
				"		  \"phone_number\": \"(+91) 123 456 7890\",\r\n" + 
				"		  \"address\": \"29, side mumbai, cohen 09\",\r\n" + 
				"		  \"types\": [\r\n" + 
				"		    \"herbal park\",\r\n" + 
				"		    \"shop\"\r\n" + 
				"		  ],\r\n" + 
				"		  \"website\": \"http://google.com\",\r\n" + 
				"		  \"language\": \"French-IN\"\r\n" + 
				"		}";
		return s;
	}
	
	public static String updatePlace(String place, String newAdd) {
	String update = "{\r\n" + 
			"\"place_id\":\""+place+"\",\r\n" + 
			"\"address\":\""+newAdd+"\",\r\n" + 
			"\"key\":\"qaclick123\"\r\n" + 
			"}\r\n" + 
			"" ;
return update;
	}
}
