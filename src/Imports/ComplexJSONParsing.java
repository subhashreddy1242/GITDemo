package Imports;
import io.restassured.path.json.JsonPath;

public class ComplexJSONParsing {
	public static void main(String args[])
	{
		JsonPath js =new JsonPath(payload.CoursePath());
		
		//1. Print No of courses returned by API
		System.out.println("1) No of courses returned by API");
		System.out.println(js.getInt("courses.size()"));
		
		//2.Print Total Purchase Amount
		System.out.println("2) Total Purchase Amount");
		System.out.println(js.getInt("dashboard.purchaseAmount"));
		int count = js.getInt("courses.size()");
		
		for(int i=0;i<count;i++)
		{
			//3.Print Title of the first course
			
			if(i==0)
			{
			System.out.println("3) Title of the first course");
			System.out.println(js.getString("courses["+i+"].title"));
			}
					
			//5.Print no of copies sold by RPA Course
			if(i==0)
			{
			System.out.println("5) No of copies sold by RPA Course");
			}
			if(js.getString("courses["+i+"].title").equalsIgnoreCase("RPA")){
				System.out.println(js.getString("courses["+i+"].copies"));
				break;
			}
			
			//4.Print All course titles and their respective Prices
			/*if(i==0)
			{
			System.out.println("4) Print All course titles and their respective Prices");
			}
			System.out.println(js.getString("courses["+i+"].title"));
			System.out.println(js.getString("courses["+i+"].price"));*/
		}
	}
}
