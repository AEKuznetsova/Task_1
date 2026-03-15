package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTests {

    private final IngredientType type;
    private final String name;
    private final float price;
    private Ingredient ingredient;

    public IngredientTests(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Before
    public void setUp() {
        ingredient = new Ingredient(type, name, price);
    }

    @Parameterized.Parameters(name = "Ingredient[type={0}, name={1}, price={2}]")
    public static Object[][] testData() {
        return new Object[][] {
                {IngredientType.SAUCE, "tartar sauce", 100.0f},
                {IngredientType.FILLING, "ham", 200.0f}
        };
    }

    @Test
    public void getIngredientNameTest() {
        assertEquals("Неправильное название ингредиента", name, ingredient.getName());
    }

    @Test
    public void getIngredientPriceTest() {
        assertEquals("Неправильная цена ингредиента", price, ingredient.getPrice(), 0);
    }

    @Test
    public void getIngredientTypeTest() {
        assertEquals("Неправильный тип ингредиента", type, ingredient.getType());
    }
}