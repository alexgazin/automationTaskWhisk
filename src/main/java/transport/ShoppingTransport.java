package transport;

import config.Configuration;
import entities.request.CreateShoppingListRequest;
import entities.response.ShoppingListResponse;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import org.aeonbits.owner.ConfigFactory;

public class ShoppingTransport {

    Configuration configuration = ConfigFactory.create(Configuration.class, System.getProperties());

    public HttpResponse<ShoppingListResponse> createShoppingList(String shoppingListName) {
        return Unirest.post(configuration.api_host() + "list/v2")
                .header("Content-type", "application/json")
                .header("Authorization", configuration.token())
                .body(new CreateShoppingListRequest(shoppingListName, false))
                .asObject(ShoppingListResponse.class);
    }

    public HttpResponse<ShoppingListResponse> getShoppingList(String shoppingListId) {
        return Unirest.get(configuration.api_host() + "list/v2/" + shoppingListId)
                .header("Content-type", "application/json")
                .header("Authorization", configuration.token())
                .asObject(ShoppingListResponse.class);
    }

    public HttpResponse deleteShoppingList(String shoppingListId) {
        return Unirest.delete(configuration.api_host() + "list/v2/" + shoppingListId)
                .header("Content-type", "application/json")
                .header("Authorization", configuration.token())
                .asEmpty();
    }
}