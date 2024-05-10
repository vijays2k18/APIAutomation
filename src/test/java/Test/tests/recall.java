package Test.tests;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class recall {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		
		String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
				.body("{\r\n"
						+ "	\"location\": {\r\n"
						+ "		\"lat\": -38.383494,\r\n"
						+ "		\"lng\": \"33.427362\"\r\n"
						+ "	},\r\n"
						+ "	\"accuracy\": 50,\r\n"
						+ "	\"name\": \"Marimuthu\",\r\n"
						+ "	\"phone_number\": \"(+91) 983 893 3937\",\r\n"
						+ "	\"address\": \"29, side layout, cohen 09\",\r\n"
						+ "	\"types\": [\r\n"
						+ "		\"shoe park\",\r\n"
						+ "		\"shop\"\r\n"
						+ "	],\r\n"
						+ "	\"website\": \"http://google.com\",\r\n"
						+ "	\"language\": \"French-IN\"\r\n"
						+ "}")
		.when().post("/maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		System.out.println(response);
		
		JsonPath js = new JsonPath(response);
		System.out.println(js.get("status"));
		System.out.println(js.get("place_id"));
		System.out.println(js.get("scope"));
		System.out.println(js.get("reference"));
		System.out.println(js.get("id"));
		

	}

}
