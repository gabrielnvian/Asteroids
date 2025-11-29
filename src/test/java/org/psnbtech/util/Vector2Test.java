package org.psnbtech.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class Vector2Test {

    // Test 1: Vector2 can be created with x and y values
    @Test
    void testVectorCreationWithXY() {
        Vector2 vec = new Vector2(3.0, 4.0);

        assertEquals(3.0, vec.x);
        assertEquals(4.0, vec.y);
    }

    // Test 2: Copy constructor correctly copies values
    @Test
    void testCopyConstructorCopiesValues() {
        Vector2 original = new Vector2(5.0, 6.0);
        Vector2 copy = new Vector2(original);

        assertEquals(original.x, copy.x);
        assertEquals(original.y, copy.y);
    }

    // Test 3: set updates x and y values
    @Test
    void testSetUpdatesValues() {
        Vector2 vec = new Vector2(1.0, 1.0);

        vec.set(7.0, 8.0);

        assertEquals(7.0, vec.x);
        assertEquals(8.0, vec.y);
    }

    // Test 4: add correctly adds vector values
    @Test
    void testAddUpdatesValues() {
        Vector2 v1 = new Vector2(2.0, 3.0);
        Vector2 v2 = new Vector2(4.0, 5.0);

        v1.add(v2);

        assertEquals(6.0, v1.x);
        assertEquals(8.0, v1.y);
    }

    // Test 5: getLengthSquared returns correct value
    @Test
    void testGetLengthSquaredReturnsCorrectValue() {
        Vector2 vec = new Vector2(3.0, 4.0);

        double lengthSquared = vec.getLengthSquared();

        assertEquals(25.0, lengthSquared);
    }

    // Test 6: scale multiplies both x and y by the given factor
    @Test
    void testScaleMultipliesValues() {
        Vector2 vec = new Vector2(2.0, 3.0);

        vec.scale(2.0);

        assertEquals(4.0, vec.x);
        assertEquals(6.0, vec.y);
    }

    // Test 7: normalize converts a non-zero vector to unit length
    @Test
    void testNormalizeProducesUnitVector() {
        Vector2 vec = new Vector2(3.0, 4.0);

        vec.normalize();

        double lengthSquared = vec.getLengthSquared();

        assertEquals(1.0, lengthSquared, 0.0000001);
    }
}
