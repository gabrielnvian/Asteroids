package org.psnbtech;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Test;
import org.psnbtech.entity.Entity;
import org.psnbtech.entity.Player;

public class GameTest {

    // Test 1: Game class exists and loads correctly
    @Test
    void testGameClassExists() {
        assertDoesNotThrow(() -> {
            Class.forName("org.psnbtech.Game");
        });
    }

    // Test 2: Game has a main method
    @Test
    void testGameHasMainMethod() {
        assertDoesNotThrow(() -> {
            Method main = Game.class.getMethod("main", String[].class);
            assertNotNull(main);
        });
    }

    // Test 3: Game exposes getScore method
    @Test
    void testGameHasGetScoreMethod() {
        assertDoesNotThrow(() -> {
            Method m = Game.class.getMethod("getScore");
            assertEquals(int.class, m.getReturnType());
        });
    }

    // Test 4: Game exposes getEntities method
    @Test
    void testGameHasGetEntitiesMethod() {
        assertDoesNotThrow(() -> {
            Method m = Game.class.getMethod("getEntities");
            assertEquals(List.class, m.getReturnType());
        });
    }

    // Test 5: Game exposes getRandom method
    @Test
    void testGameHasGetRandomMethod() {
        assertDoesNotThrow(() -> {
            Method m = Game.class.getMethod("getRandom");
            assertEquals(Random.class, m.getReturnType());
        });
    }
}
