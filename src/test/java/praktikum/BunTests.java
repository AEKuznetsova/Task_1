package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTests {

    private final String name;
    private final float price;
    private Bun bun;

    public BunTests(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Before
    public void setUp() {
        bun = new Bun(name, price);
    }

    @Parameterized.Parameters(name = "Bun[name={0}, price={1}]")
    public static Object[][] getData() {
        return new Object[][] {
                {"black bun", 100.0f},
                {"red bun", 200.0f},
                {"white bun", 300.0f}
        };
    }

    @Test
    public void bunNameTest() {
        assertEquals("Неправильное название булочки", name, bun.getName());
    }

    @Test
    public void bunPriceTest() {
        assertEquals("Неправильная цена булочки", price, bun.getPrice(), 0);
    }
}