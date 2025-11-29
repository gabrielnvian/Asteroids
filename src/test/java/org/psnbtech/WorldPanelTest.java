package org.psnbtech;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;
import java.awt.Dimension;

import org.junit.jupiter.api.Test;

public class WorldPanelTest {

    // Test 1: WorldPanel can be created without throwing
    @Test
    void testWorldPanelCreationDoesNotThrow() {
        assertDoesNotThrow(() -> {
            new WorldPanel(null);
        });
    }

    // Test 2: Preferred size is set to WORLD_SIZE by WORLD_SIZE
    @Test
    void testPreferredSizeIsWorldSize() {
        WorldPanel panel = new WorldPanel(null);
        Dimension size = panel.getPreferredSize();

        assertEquals(WorldPanel.WORLD_SIZE, size.width);
        assertEquals(WorldPanel.WORLD_SIZE, size.height);
    }

    // Test 3: Background color is black
    @Test
    void testBackgroundColorIsBlack() {
        WorldPanel panel = new WorldPanel(null);

        assertEquals(Color.BLACK, panel.getBackground());
    }

    // Test 4: WORLD_SIZE is a positive value
    @Test
    void testWorldSizeIsPositive() {
        assertTrue(WorldPanel.WORLD_SIZE > 0);
    }

    // Test 5: Two WorldPanel instances are different objects
    @Test
    void testTwoWorldPanelsAreDifferentObjects() {
        WorldPanel panel1 = new WorldPanel(null);
        WorldPanel panel2 = new WorldPanel(null);

        assertNotSame(panel1, panel2);
    }
}
