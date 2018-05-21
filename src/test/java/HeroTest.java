import org.junit.*;
import static org.junit.Assert.*;

public class HeroTest {

  @Test
  public void Hero_instantiatesCorrectly_true() {
    Hero newHero = new Hero("Spider Man", 30, "Flying Around", "Beautiful Girl");
    assertEquals(true, newHero instanceof Hero);
  }

  @Test
  public void Hero_instantiatesWithName_String() {
    Hero newHero = new Hero("Spider Man", 30, "Flying Around", "Beautiful Girl");
    assertEquals("Spider Man", newHero.getName());
  }

}
