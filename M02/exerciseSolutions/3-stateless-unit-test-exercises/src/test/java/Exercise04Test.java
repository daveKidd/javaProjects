import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Exercise04Test {

    @Test
    void calculateTotalCost() {
        Exercise04 instance = new Exercise04();

        // doubles are notoriously hard to test because they use floating-point rounding.
        // The third argument in `assertEquals` is a delta. It represents the margin of error for equality.
        // As long as the expected and actual differ by less than the delta, the test passes.
        assertEquals(1.25, instance.calculateTotalCost(0.25, 5), 0.001);
        assertEquals(3.75, instance.calculateTotalCost(0.25, 15), 0.001);
        assertEquals(3.8, instance.calculateTotalCost(0.25, 16), 0.001);
        assertEquals(5.9375, instance.calculateTotalCost(0.25, 25), 0.001);
        assertEquals(23.4, instance.calculateTotalCost(1, 26), 0.001);
        assertEquals(45, instance.calculateTotalCost(1, 50), 0.001);
        assertEquals(43.35, instance.calculateTotalCost(1, 51), 0.001);
        assertEquals(63.75, instance.calculateTotalCost(1, 75), 0.001);
        assertEquals(99.06, instance.calculateTotalCost(1.27, 100), 0.001);
        assertEquals(0.0, instance.calculateTotalCost(-1.27, 100), 0.001);
        assertEquals(0.0, instance.calculateTotalCost(1.27, -100), 0.001);

        /**
         * Calculates the cost to the customer give an item price and the quantity purchased.
         * Negative price or quantity results in 0.0 cost.
         * Volume discounts apply.
         * 1 - 15 items: no discount
         * 16 - 25 items: 5% discount
         * 26 - 50 items: 10% discount
         * 51 - 75 items: 15% discount
         * Greater than 75 items: 22% discount
         *
         * @param price    the price of a single item
         * @param quantity the number of items to purchase
         * @return the total cost with volume discounts applied
         */

    }
}