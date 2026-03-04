package praktikum;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class IngredientTypeTests {

    @Test
    public void sauceTest() {
        assertEquals("Тип ингредиента не SAUCE", "SAUCE", IngredientType.SAUCE.toString());
    }

    @Test
    public void fillingTest() {
        assertEquals("Тип ингредиента не FILLING", "FILLING", IngredientType.FILLING.toString());
    }
}

