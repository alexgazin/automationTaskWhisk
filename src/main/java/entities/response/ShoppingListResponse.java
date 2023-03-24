package entities.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ShoppingListResponse {


    String code;
    String error_code;
    String message;
    ShoppingListParameters list;
    ShoppingListContent content;

    public String getCode() {
        return code;
    }

    public String getError_code() {
        return error_code;
    }

    public String getMessage() {
        return message;
    }

    public ShoppingListParameters getList() {
        return list;
    }

    public ShoppingListContent getContent() {
        return content;
    }
}
