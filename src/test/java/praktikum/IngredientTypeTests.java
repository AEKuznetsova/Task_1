package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)
public class IngredientTypeTests {

    private final IngredientType ingredientType;
    private final String expectedTypeInReceipt;

    private Burger burger;

    @Mock
    private Bun mockBun;

    @Mock
    private Ingredient mockIngredient;

    public IngredientTypeTests(IngredientType ingredientType, String expectedTypeInReceipt) {
        this.ingredientType = ingredientType;
        this.expectedTypeInReceipt = expectedTypeInReceipt;
    }

    @Parameterized.Parameters(name = "IngredientType[type={0}, receiptValue={1}]")
    public static Object[][] getData() {
        return new Object[][] {
                {IngredientType.SAUCE, "sauce"},
                {IngredientType.FILLING, "filling"}
        };
    }

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        burger = new Burger();

        when(mockBun.getName()).thenReturn("black bun");
        when(mockBun.getPrice()).thenReturn(100f);
        when(mockIngredient.getType()).thenReturn(ingredientType);
        when(mockIngredient.getName()).thenReturn("hot sauce");
        when(mockIngredient.getPrice()).thenReturn(50f);
    }

    @Test
    public void receiptContainsIngredientTypeTest() {
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient);

        String receipt = burger.getReceipt();

        assertTrue("В чеке должен отображаться тип ингредиента " + expectedTypeInReceipt,
                receipt.contains(expectedTypeInReceipt));
    }
}
