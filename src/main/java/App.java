import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    // staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
     Map<String, Object> model = new HashMap<String, Object>();
     model.put("hero", request.session().attribute("hero"));
     model.put("template", "templates/index.vtl");
     return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());

   post("/heroes", (request, response) -> {
     Map<String, Object> model = new HashMap<String, Object>();

     String name = request.queryParams("name");
     int age = Integer.parseInt(request.queryParams("age"));
     String power = request.queryParams("power");
     String weakness = request.queryParams("weakness");
     Hero newHero = new Hero(name, age, power, weakness);
     request.session().attribute("hero", newHero);

     model.put("template", "templates/heroList.vtl");
     return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());

  }
}
