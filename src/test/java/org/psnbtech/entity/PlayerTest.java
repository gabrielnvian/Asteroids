package org.psnbtech.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.psnbtech.WorldPanel;
import org.psnbtech.util.Vector2;

public class PlayerTest {

    // Test 1: Player can be created without throwing
    @Test
    void testPlayerCreation() {
        Player player = new Player();
        assertNotNull(player);
    }

    // Test 2: Player starts at the center of the world
    @Test
    void testPlayerStartsAtWorldCenter() {
        Player player = new Player();
        Vector2 position = player.getPosition();

        double expected = WorldPanel.WORLD_SIZE / 2.0;

        assertEquals(expected, position.x);
        assertEquals(expected, position.y);
    }

    // Test 3: setThrusting can be called without throwing
    @Test
    void testSetThrustingDoesNotThrow() {
        Player player = new Player();

        assertDoesNotThrow(() -> {
            player.setThrusting(true);
            player.setThrusting(false);
        });
    }

    // Test 4: setRotateLeft and setRotateRight can be called without throwing
    @Test
    void testRotationSettersDoNotThrow() {
        Player player = new Player();

        assertDoesNotThrow(() -> {
            player.setRotateLeft(true);
            player.setRotateRight(true);
            player.setRotateLeft(false);
            player.setRotateRight(false);
        });
    }

    // Test 5: reset restores position and velocity to defaults
    @Test
    void testResetRestoresDefaults() {
        Player player = new Player();

        // Force position and velocity away from defaults using inherited access
        player.getPosition().set(10.0, 10.0);
        player.getVelocity().set(5.0, 5.0);

        player.reset();

        double expected = WorldPanel.WORLD_SIZE / 2.0;

        assertEquals(expected, player.getPosition().x);
        assertEquals(expected, player.getPosition().y);
        assertEquals(0.0, player.getVelocity().x);
        assertEquals(0.0, player.getVelocity().y);
    }
}
