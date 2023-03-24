package entities.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateShoppingListRequest {

    public CreateShoppingListRequest(String name, Boolean primary) {
        this.name = name;
        this.primary = primary;
    }

    String name;

    Boolean primary;

}
