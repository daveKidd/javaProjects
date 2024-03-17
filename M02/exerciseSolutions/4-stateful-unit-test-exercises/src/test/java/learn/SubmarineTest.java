package learn;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubmarineTest {

    Submarine submarine = new Submarine(100.0);
    Submarine submarine2 = new Submarine(50.0);

    @Test
    void shouldHaveCorrectDepthAfter3Dives() {
        submarine.dive();
        submarine.dive();
        submarine.dive();
        assertEquals(9.0, submarine.getDepthInMeters(), 0.001);
    }

    @Test
    void shouldNotGoBeyondMaxDepth() {
        for(int i = 0; i<50; i++){
            submarine.dive();
        }
        System.out.println(submarine.getDepthInMeters());
        assertEquals(99.0, submarine.getDepthInMeters(), 0.001);

        for(int i = 0; i<50; i++){
            submarine2.dive();
        }
        System.out.println(submarine2.getDepthInMeters());
        assertEquals(48.0, submarine2.getDepthInMeters(), 0.001);
    }

    @Test
    void shouldHaveCorrectDepthAfter4Dives2Surfaces() {
        submarine.dive();
        submarine.dive();
        submarine.dive();
        submarine.dive();
        submarine.surface();
        submarine.surface();
        assertEquals(2.0, submarine.getDepthInMeters(), 0.001);
    }

    @Test
    void shouldNotGoBeyondSurface() {
        for(int i = 0; i<50; i++){
            submarine.dive();
        }
        for(int i = 0; i<50; i++){
            submarine.surface();
        }
        System.out.println(submarine.getDepthInMeters());
        assertEquals(4.0, submarine.getDepthInMeters(), 0.001);
    }

    @Test
    void shouldHaveCorrectPressureAfter3Dives() {
        submarine.dive();
        submarine.dive();
        submarine.dive();
        // 1.0 at sea level plus 1.0 * 0.9
        assertEquals(1.9, submarine.getPressureInAtmospheres(), 0.001);

        submarine.dive();
        submarine.dive();
        submarine.dive();
        submarine.dive();
        submarine.dive();
        submarine.dive();
        submarine.dive();
        assertEquals(4, submarine.getPressureInAtmospheres(), 0.001);

    }

    // 1. Create one or more tests to confirm `dive` is working properly.
    // 2. Create a test to assert the submarine can't go deeper than the max depth.
    // (Be sure to use more than one max depth.)
    // 3. Create one or more tests to confirm `surface` is working properly.
    // 4. Create a test to assert the submarine can't go above sea level.
    // (Depth can never be negative.)
    // 5. Create one or more tests to confirm `getPressureInAtmospheres` is working properly.
}