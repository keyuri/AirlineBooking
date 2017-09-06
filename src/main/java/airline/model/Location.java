package airline.model;

/**
 * Created by Keyuri on 30-08-2017.
 */
public class Location {
    public static final Location DEFAULT = new Location("DEFAULT","DEFAULT");
    private String id;
    private String name;

    public Location(String inputId, String inputName) {
        id = inputId;
        name = inputName;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
