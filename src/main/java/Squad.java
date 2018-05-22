import java.util.List;
import java.util.ArrayList;


public class Squad {
  private String mName;
  private static List<Squad> instances = new ArrayList<Squad>();
  private int mId;

  public Squad(String name) {
    mName = name;
    instances.add(this);
    mId = instances.size();
  }

  public String getName() {
    return mName;
  }

  public static List<Squad> all() {
    return instances;
  }

  public static void clear() {
    instances.clear();
  }

  public int getId() {
    return mId;
  }

  public static Squad find(int id) {
    return instances.get(id - 1);
  }
}
