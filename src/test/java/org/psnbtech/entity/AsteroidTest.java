package org.psnbtech.entity;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.Test;

public class AsteroidTest {

    // Test 1: Asteroid can be created with a Random object
    @Test
    void testAsteroidCreationWithRandom() {
        Random random = new Random(1);
        Asteroid asteroid = new Asteroid(random);

        assertNotNull(asteroid);
    }

    // Test 2: Two asteroids created with the same Random are different objects
    @Test
    void testTwoAsteroidsAreDifferentObjects() {
        Random random = new Random(2);

        Asteroid asteroid1 = new Asteroid(random);
        Asteroid asteroid2 = new Asteroid(random);

        assertNotSame(asteroid1, asteroid2);
    }

    // Test 3: Child asteroid can be created from a parent
    @Test
    void testChildAsteroidCreation() {
        Random random = new Random(3);

        Asteroid parent = new Asteroid(random);
        Asteroid child = new Asteroid(parent, AsteroidSize.Small, random);

        assertNotNull(child);
    }

    // Test 4: Creating a medium child asteroid does not throw an exception
    @Test
    void testMediumChildAsteroidDoesNotThrow() {
        Random random = new Random(4);
        Asteroid parent = new Asteroid(random);

        assertDoesNotThrow(() -> {
            new Asteroid(parent, AsteroidSize.Medium, random);
        });
    }

    // Test 5: Multiple child asteroids can be created from the same parent
    @Test
    void testMultipleChildrenFromSameParent() {
        Random random = new Random(5);

        Asteroid parent = new Asteroid(random);
        Asteroid child1 = new Asteroid(parent, AsteroidSize.Small, random);
        Asteroid child2 = new Asteroid(parent, AsteroidSize.Small, random);

        assertNotSame(child1, child2);
    }

    // Test 6: Large child asteroid can be created from a large parent without throwing
    @Test
    void testLargeChildAsteroidDoesNotThrow() {
        Random random = new Random(6);
        Asteroid parent = new Asteroid(random);

        assertDoesNotThrow(() -> {
            new Asteroid(parent, AsteroidSize.Large, random);
        });
    }
}
