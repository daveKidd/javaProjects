package learn.commerce;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    Order order = new Order(25);

    @Test
    void shouldHaveOrderId() {
        assertEquals(25, order.getOrderId());
    }

    @Test
    void shouldAddValidItems() {
        LineItem grassSeed = new LineItem("Grass Seed", 19.99, 2);
        boolean result = order.add(grassSeed);
        assertTrue(result);
        assertEquals(1, order.getLineItems().length);
        assertEquals(grassSeed, order.getLineItems()[0]);

        LineItem gardenRake = new LineItem("Garden Rake", 44.99, 1);
        result = order.add(gardenRake);
        assertTrue(result);
        assertEquals(2, order.getLineItems().length);
        assertEquals(gardenRake, order.getLineItems()[1]);

        LineItem hose = new LineItem("Garden Hose - 50ft", 38.49, 1);
        result = order.add(hose);
        assertTrue(result);
        assertEquals(3, order.getLineItems().length);
        assertEquals(hose, order.getLineItems()[2]);
    }

    // 1. Add test shouldNotAddInvalidItems: confirm that it's not possible to add items with <= 0 quantity or < 0 price.
    @Test
    void shouldNotAddInvalidItems() {
        LineItem grassSeed = new LineItem("Grass Seed", -1, 2);
        boolean result = order.add(grassSeed);
        assertFalse(result);
        assertEquals(0, order.getLineItems().length);

        LineItem grassSeed2 = new LineItem("Grass Seed", 10.0, 0);
        boolean result2 = order.add(grassSeed2);
        assertFalse(result2);
        assertEquals(0, order.getLineItems().length);
    }
    // 2. Test the order.getTotal() in various scenarios and confirm it's correct.
    @Test
    void shouldGetTotal() {
        LineItem grassSeed = new LineItem("Grass Seed", 20.00, 2);
        order.add(grassSeed);

        LineItem somethingCool = new LineItem("Something Cool", 10.0, 4);
        order.add(somethingCool);

        assertEquals(order.getTotal(),80.0);
    }

    // 3. If you tackle `order.remove`, test the method thoroughly.
    @Test
    void shouldRemoveItem() {
        LineItem grassSeed = new LineItem("Grass Seed", 20.00, 2);
        order.add(grassSeed);

        LineItem somethingCool = new LineItem("Something Cool", 10.0, 4);
        order.add(somethingCool);

        LineItem somethingReallyCool = new LineItem("Something Really Cool", 10.0, 4);
        order.add(somethingCool);

        assertEquals(3, order.getLineItems().length);

        order.removeItem(1);

        assertEquals(2, order.getLineItems().length);
    }
}