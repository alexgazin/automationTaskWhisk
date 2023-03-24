package entities.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ShoppingListParameters {

    String id;
    String name;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
