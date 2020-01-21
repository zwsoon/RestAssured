import java.io.FileReader;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
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
		 
        try {
 
            Object obj = parser.parse(new FileReader(
                    "C:\\Users\\zwsoo\\eclipse-workspace\\Testing\\src\\test\\java\\resource"));
 
            JSONObject jsonObject = (JSONObject) obj;
 
            String name = (String) jsonObject.get("Name");
            String author = (String) jsonObject.get("Author");
            JSONArray companyList = (JSONArray) jsonObject.get("Company List");
 
            System.out.println("Name: " + name);
            System.out.println("Author: " + author);
            System.out.println("\nCompany List:");
            Iterator<String> iterator = companyList.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
 
        } catch (Exception e) {
            e.printStackTrace();
        }
		
	}
	
	//calling method and passing in parameter
	@Test
	public void getCityWeather() {
		String city = "Atlanta";
		getWeatherDetails(city);
	}
}
