import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.ArrayList;

public class App {
  public static void main(String[] args) {
    // staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
     Map<String, Object> model = new HashMap<String, Object>();
     model.put("heroes", request.session().attribute("heroes"));
     model.put("template", "templates/index.vtl");
     return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());

   get("heroes/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/hero-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/heroes", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("heroes", Hero.all());
      model.put("template", "templates/heroes.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

   post("/heroes", (request, response) -> {
     Map<String, Object> model = new HashMap<String, Object>();

     ArrayList<Hero> heroes = request.session().attribute("heroes");
     if (heroes == null) {
        heroes = new ArrayList<Hero>();
        request.session().attribute("heroes", heroes);
     }

     String name = request.queryParams("name");
     int age = Integer.parseInt(request.queryParams("age"));
     String power = request.queryParams("power");
     String weakness = request.queryParams("weakness");
     Hero newHero = new Hero(name, age, power, weakness);
     heroes.add(newHero);
     request.session().attribute("heroes", heroes);

     model.put("template", "templates/heroList.vtl");
     return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());

  }
}
