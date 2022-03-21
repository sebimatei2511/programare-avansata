import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Catalog implements Serializable {

    private String name;
    private List<Item> items = new ArrayList<>();

    public void add(Item item) {
        items.add(item);
    }

    public Item findById(String id) {
        return items.stream()
                .filter(d -> d.getId().equals(id)).
                findFirst().orElse(null);
    }

    public Catalog(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "name='" + name + '\'' +
                '}';
    }
}
