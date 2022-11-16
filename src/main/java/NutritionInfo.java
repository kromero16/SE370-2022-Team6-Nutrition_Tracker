import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class NutritionInfo {	
	public void getNutrInfo(String n) throws UnsupportedEncodingException, UnirestException, FileNotFoundException {
     String host = "https://calorieninjas.p.rapidapi.com/v1/nutrition";
     String charset = "UTF-8";
     // Headers for a request
     String x_rapidapi_host = "calorieninjas.p.rapidapi.com";
     String x_rapidapi_key = "b95b926083msh737c88604e99188p102bf8jsn75f93502f547";
     // Params
     String s = "query="+ URLEncoder.encode(n, StandardCharsets.UTF_8);
     

     /*HttpResponse<String> response = Unirest.get("https://calorieninjas.p.rapidapi.com/v1/nutrition?query=chicken")
    			.header("X-RapidAPI-Key", "b95b926083msh737c88604e99188p102bf8jsn75f93502f547")
    			.header("X-RapidAPI-Host", "calorieninjas.p.rapidapi.com")
    			.asString();*/
     
     HttpResponse<JsonNode> response = Unirest.get(host + "?" + s)
  			.header("X-RapidAPI-Key", "b95b926083msh737c88604e99188p102bf8jsn75f93502f547")
  			.header("X-RapidAPI-Host", "calorieninjas.p.rapidapi.com")
  			.asJson(); 
	    	    
	    	    
   	  //Formatting JSON
   	      Gson gson = new GsonBuilder().setPrettyPrinting().create();
   	      JsonParser jp = new JsonParser();
   	      JsonElement je = jp.parse(response.getBody().toString());
   	      String prettyJsonString = gson.toJson(je);
   	      System.out.println(prettyJsonString);
   	      
   	      //save JSON query to file 	      
   	     PrintWriter out = new PrintWriter("saved.txt");
   	     out.println(prettyJsonString);
   	     out.close();

		
	}
   	    
}
