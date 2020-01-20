import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Demo1_GET_REQUEST {
	
	String city = "Atlanta";
	
	public void getWeatherDetails(String city) {
		//specify base uri
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";

		//request object
		RequestSpecification httpRequest = RestAssured.given();
		
		//response object
		Response response = httpRequest.request(Method.GET,"/"+city);
		String responseBody = response.getBody().asString();
		//print the response
		System.out.println(responseBody);
		
	}
	
	//calling method and passing in parameter
	@Test
	public void getCityWeather() {
		getWeatherDetails(city);
	}
}
