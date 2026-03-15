package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class BurgerTests {

    private Burger burger;

    @Mock private Bun mockBun;
    @Mock private Ingredient mockIngredient1;
    @Mock private Ingredient mockIngredient2;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        burger = new Burger();
    }

    @Test
    public void addBunTest() {
        burger.setBuns(mockBun);
        assertEquals("Булочка не добавлена", mockBun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(mockIngredient1);
        assertEquals("Количество ингредиентов должно быть равно 1", 1, burger.ingredients.size());
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(mockIngredient1);
        burger.removeIngredient(0);
        assertEquals("Количество ингредиентов должно быть равно 0", 0, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);
        burger.moveIngredient(0, 1);
        assertEquals("Ингредиент не перемещен",
                mockIngredient1, burger.ingredients.get(1));
    }

    @Test
    public void getTotalPriceTest() {
        when(mockBun.getPrice()).thenReturn(100f);
        when(mockIngredient1.getPrice()).thenReturn(50f);

        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);

        float totalPrice = 100f * 2 + 50f;
        assertEquals("Сумма должна равняться сумме булочек и ингредиентов",
                totalPrice, burger.getPrice(), 0.001f);
    }

    @Test
    public void receiptContainsBunNameTest() {
        when(mockBun.getName()).thenReturn("black bun");

        burger.setBuns(mockBun);
        String receipt = burger.getReceipt();
        assertTrue("В чеке нет информации о булочке", receipt.contains("black bun"));
    }

    @Test
    public void receiptContainsIngredientNameTest() {
        when(mockBun.getName()).thenReturn("black bun");
        when(mockIngredient1.getName()).thenReturn("hot sauce");
        when(mockIngredient1.getType()).thenReturn(IngredientType.SAUCE);

        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        String receipt = burger.getReceipt();
        assertTrue("В чеке нет названия ингредиента", receipt.contains("hot sauce"));
    }

    @Test
    public void receiptContainsSauceNameTest() {
        when(mockBun.getName()).thenReturn("black bun");
        when(mockIngredient1.getType()).thenReturn(IngredientType.SAUCE);

        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        String receipt = burger.getReceipt();
        assertTrue("В чеке нет названия соуса", receipt.contains("sauce"));
    }

    @Test
    public void receiptContainsPriceTest() {
        when(mockBun.getName()).thenReturn("black bun");
        when(mockBun.getPrice()).thenReturn(100f);
        when(mockIngredient1.getPrice()).thenReturn(50f);
        when(mockIngredient1.getName()).thenReturn("hot sauce");
        when(mockIngredient1.getType()).thenReturn(IngredientType.SAUCE);

        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        String receipt = burger.getReceipt();
        assertTrue("В чеке нет цены бургера", receipt.contains("Price:"));
    }
}