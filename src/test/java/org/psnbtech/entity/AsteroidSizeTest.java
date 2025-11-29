package org.psnbtech.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class AsteroidSizeTest {

    // Test 1: Small asteroid size has the correct kill value
    @Test
    void testSmallKillValue() {
        assertEquals(100, AsteroidSize.Small.killValue);
    }

    // Test 2: Medium asteroid size has the correct kill value
    @Test
    void testMediumKillValue() {
        assertEquals(50, AsteroidSize.Medium.killValue);
    }

    // Test 3: Large asteroid size has the correct kill value
    @Test
    void testLargeKillValue() {
        assertEquals(20, AsteroidSize.Large.killValue);
    }

    // Test 4: Small asteroid radius is greater than zero
    @Test
    void testSmallRadiusIsPositive() {
        assertTrue(AsteroidSize.Small.radius > 0);
    }

    // Test 5: Each asteroid size has a polygon
    @Test
    void testEachAsteroidSizeHasPolygon() {
        assertNotNull(AsteroidSize.Small.polygon);
        assertNotNull(AsteroidSize.Medium.polygon);
        assertNotNull(AsteroidSize.Large.polygon);
    }
}
