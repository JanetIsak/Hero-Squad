import org.junit.*;
import static org.junit.Assert.*;

public class SquadTest {

    @Test
    public void squad_instantiatesCorrectly_true() {
      Squad testSquad = new Squad("Strongest");
      assertEquals(true, testSquad instanceof Squad);
   }

    @Test
    public void getName_squadInstantiatesWithName_Strongest() {
      Squad testSquad = new Squad("Strongest");
      assertEquals("Strongest", testSquad.getName());
   }

    @Test
    public void all_returnsAllInstancesOfSquad_true() {
      Squad firstSquad = new Squad("Strongest");
      Squad secondSquad = new Squad("Modern");
      assertEquals(true, Squad.all().contains(firstSquad));
      assertEquals(true, Squad.all().contains(secondSquad));
   }

   @Test
   public void clear_emptiesAllSquadFromList_0() {
     Squad testSquad = new Squad("Strongest");
     Squad.clear();
     assertEquals(0, Squad.all().size());
   }

   @Test
   public void getId_squadInstantiatesWithId_1() {
     Squad.clear();
     Squad testSquad = new Squad("Strongest");
     assertEquals(1, testSquad.getId());
  }

   @Test
   public void find_returnsSquadWihSameId_secondSquad() {
     Squad.clear();
     Squad firstSquad = new Squad("Strongest");
     Squad secondSquad = new Squad("Modern");
     assertEquals(secondSquad, Squad.find(secondSquad.getId()));
   }
}
