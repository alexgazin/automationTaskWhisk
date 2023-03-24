package tests;

import entities.response.ShoppingListResponse;
import kong.unirest.HttpResponse;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import transport.ShoppingTransport;

public class ShoppingListApiTests extends BaseTest {

    private String shoppingListId;
    private final ShoppingTransport shoppingTransport = new ShoppingTransport();

    @Before
    public void init() {
        HttpResponse<ShoppingListResponse> shoppingListResponse = shoppingTransport.createShoppingList(SHOPPING_LIST_NAME);
        Assert.assertEquals("The request to create a shopping List returned with the code ", 200, shoppingListResponse.getStatus());
        ShoppingListResponse shoppingList = shoppingListResponse.getBody();
        Assert.assertFalse("Id in shopping list is empty ", shoppingList.getList().getId().isEmpty());
        shoppingListId = shoppingList.getList().getId();
        Assert.assertFalse("Shopping list name is empty ", shoppingList.getList().getName().isEmpty());
        Assert.assertEquals("Shopping list name not equals ", SHOPPING_LIST_NAME, shoppingList.getList().getName());
    }

    @Test
    public void checkGetShoppingList() {
        HttpResponse<ShoppingListResponse> shoppingListResponse = shoppingTransport.getShoppingList(shoppingListId);
        Assert.assertEquals("The request to receive the shopping List returned with the code ", 200, shoppingListResponse.getStatus());
        ShoppingListResponse shoppingList = shoppingListResponse.getBody();
        Assert.assertFalse("Id in shopping list is empty ", shoppingList.getList().getId().isEmpty());
        Assert.assertEquals("Id in shopping list not equals ", shoppingListId, shoppingList.getList().getId());
        Assert.assertFalse("Shopping list name is empty ", shoppingList.getList().getName().isEmpty());
        Assert.assertEquals("Shopping list name not equals ", SHOPPING_LIST_NAME, shoppingList.getList().getName());
        Assert.assertNotNull("Shopping content list is null ",  shoppingList.getContent());
    }

    @Test
    public void checkDeleteShoppingList() {
        HttpResponse deleteShoppingListResponse = shoppingTransport.deleteShoppingList(shoppingListId);
        Assert.assertEquals("The request to delete shopping List returned with the code ", 200, deleteShoppingListResponse.getStatus());

        HttpResponse<ShoppingListResponse> shoppingListResponse = shoppingTransport.getShoppingList(shoppingListId);
        Assert.assertEquals("The request to receive the shopping List returned with the code ", 400, shoppingListResponse.getStatus());
        ShoppingListResponse shoppingList = shoppingListResponse.getBody();
        Assert.assertFalse("Field Code in empty shopping list is empty ", shoppingList.getCode().isEmpty());
        Assert.assertEquals("Field Code in empty shopping list has wrong text ", "shoppingList.notFound", shoppingList.getCode());
        Assert.assertEquals("Field Error Code in empty shopping list has wrong text ", "LIST_ERROR_NOT_FOUND", shoppingList.getError_code());
        Assert.assertEquals("Field message in empty shopping list has wrong text ", "Shopping list not found", shoppingList.getMessage());
    }
}