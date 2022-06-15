package Imports;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class SumValidation {
	@Test
	public void Sumvalidation() {
		
		JsonPath js =new JsonPath(payload.CoursePath());
		
		//6. Verify if Sum of all Course prices matches with Purchase Amount		
		int count = js.getInt("courses.size()");
		int Actual_Sum = 0;
		for(int i=0;i<count;i++)
		{
			int price = js.getInt("courses["+i+"].price");
			int copies = js.getInt("courses["+i+"].copies");
			int cost = price * copies;
			Actual_Sum = Actual_Sum + cost;				
		}
		System.out.println(Actual_Sum); //Sum of all cost
		
		int Expected_Sum = js.getInt("dashboard.purchaseAmount");
		
		Assert.assertEquals(Actual_Sum, Expected_Sum); //Comparison
	}

}
