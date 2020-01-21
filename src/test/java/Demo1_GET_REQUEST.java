import org.json.simple.parser.JSONParser;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class Demo1_GET_REQUEST {
	
	
	
	public void getWeatherDetails(String city) {
		//specify base uri
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
		//request object
		RequestSpecification httpRequest = RestAssured.given();
		//response object
		Response response = httpRequest.request(Method.GET,"/"+city);
		if(response.getStatusCode() == 200) {
			Assert.assertEquals(200, response.getStatusCode());
			System.out.println("Status code is: " + response.getStatusCode());
		}else {
			System.out.print("Did not return Status 200");
		}
		//print the status code		
		response.getBody().prettyPrint();
	}
	
	public void readJSON() {
		JSONParser parser = new JSONParser();
		
	}
	
	//calling method and passing in parameter
	@Test
	public void getCityWeather() {
		String city = "Atlanta";
		getWeatherDetails(city);
	}
}
