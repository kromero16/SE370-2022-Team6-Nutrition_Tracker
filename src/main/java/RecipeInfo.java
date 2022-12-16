import java.io.FileNotFoundException;
import java.io.PrintWriter;
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
import java.io.PrintWriter;

public class RecipeInfo {	
	public void getRecipeInfo() throws UnsupportedEncodingException, UnirestException, FileNotFoundException {
   /*  String host = "https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/recipes/findByNutrients";
     String charset = "UTF-8";
     // Headers for a request
     String x_rapidapi_host = "spoonacular-recipe-food-nutrition-v1.p.rapidapi.com";
     String x_rapidapi_key = "b95b926083msh737c88604e99188p102bf8jsn75f93502f547";
     // Params
     String s = "mCalories=2000";     
     
   	      HttpResponse<JsonNode> response = Unirest.get(host + "?" + s)
 	    			.header("X-RapidAPI-Key", "b95b926083msh737c88604e99188p102bf8jsn75f93502f547")
 	    			.header("X-RapidAPI-Host", "spoonacular-recipe-food-nutrition-v1.p.rapidapi.com")
 	    			.asJson(); */
   	      
    /* HttpResponse<String> response = Unirest.get("https://edamam-food-and-grocery-database.p.rapidapi.com/parser?ingr=mcdonaldschicken%20sandwich")
   			.header("X-RapidAPI-Key", "b95b926083msh737c88604e99188p102bf8jsn75f93502f547")
   			.header("X-RapidAPI-Host", "edamam-food-and-grocery-database.p.rapidapi.com")
   			.asString();*/
		
		/*HttpResponse<String> response = Unirest.get("https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com")
				.header("X-RapidAPI-Key", "b95b926083msh737c88604e99188p102bf8jsn75f93502f547")
				.header("X-RapidAPI-Host", "spoonacular-recipe-food-nutrition-v1.p.rapidapi.com")
				.asString();*/
		HttpResponse<String> response = Unirest.get("https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/recipes/random?number=1")
				.header("X-RapidAPI-Key", "b95b926083msh737c88604e99188p102bf8jsn75f93502f547")
				.header("X-RapidAPI-Host", "spoonacular-recipe-food-nutrition-v1.p.rapidapi.com")
				.asString();
	    	    
	    	    
   	  //Formatting JSON
   	      Gson gson = new GsonBuilder().setPrettyPrinting().create();
   	      JsonParser jp = new JsonParser();
   	      JsonElement je = jp.parse(response.getBody().toString());
   	      String prettyJsonString = gson.toJson(je);
   	      System.out.println(prettyJsonString);
   	      
   	   //save JSON query to file 	      
    	     PrintWriter out = new PrintWriter("saved_recipe.txt");
    	     out.println(prettyJsonString);
    	     out.close();
	}
   	    
}
