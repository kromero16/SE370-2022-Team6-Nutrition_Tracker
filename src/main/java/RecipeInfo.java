import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class RecipeInfo {	
	public void getRecipeInfo() throws UnsupportedEncodingException, UnirestException {
     String host = "https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/recipes/findByNutrients";
     String charset = "UTF-8";
     // Headers for a request
     String x_rapidapi_host = "spoonacular-recipe-food-nutrition-v1.p.rapidapi.com";
     String x_rapidapi_key = "b95b926083msh737c88604e99188p102bf8jsn75f93502f547";
     // Params
     String s = "minProtein=40&minFat=50";
     

   	      HttpResponse<JsonNode> response = Unirest.get(host + "?" + s)
 	    			.header("X-RapidAPI-Key", "b95b926083msh737c88604e99188p102bf8jsn75f93502f547")
 	    			.header("X-RapidAPI-Host", "spoonacular-recipe-food-nutrition-v1.p.rapidapi.com")
 	    			.asJson(); 
   	      
    /* HttpResponse<String> response = Unirest.get("https://edamam-food-and-grocery-database.p.rapidapi.com/parser?ingr=mcdonaldschicken%20sandwich")
   			.header("X-RapidAPI-Key", "b95b926083msh737c88604e99188p102bf8jsn75f93502f547")
   			.header("X-RapidAPI-Host", "edamam-food-and-grocery-database.p.rapidapi.com")
   			.asString();*/
	    	    
	    	    
   	  //Formatting JSON
   	      Gson gson = new GsonBuilder().setPrettyPrinting().create();
   	      JsonParser jp = new JsonParser();
   	      JsonElement je = jp.parse(response.getBody().toString());
   	      String prettyJsonString = gson.toJson(je);
   	      System.out.println(prettyJsonString);
	}
   	    
}
