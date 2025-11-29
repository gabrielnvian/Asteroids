package org.psnbtech.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ClockTest {

    // Test 1: Clock can be created without throwing
    @Test
    void testClockCreation() {
        Clock clock = new Clock(60.0f);
        assertNotNull(clock);
    }

    // Test 2: New clock starts unpaused
    @Test
    void testClockStartsUnpaused() {
        Clock clock = new Clock(60.0f);
        assertFalse(clock.isPaused());
    }

    // Test 3: setPaused(true) correctly pauses the clock
    @Test
    void testSetPausedTrue() {
        Clock clock = new Clock(60.0f);
        clock.setPaused(true);

        assertTrue(clock.isPaused());
    }

    // Test 4: Newly reset clock has no elapsed cycles
    @Test
    void testResetClearsElapsedCycles() {
        Clock clock = new Clock(60.0f);

        // Immediately after reset, no cycles should be elapsed
        assertFalse(clock.peekElapsedCycle());
        assertFalse(clock.hasElapsedCycle());
    }

    // Test 5: setCyclesPerSecond can be called without throwing
    @Test
    void testSetCyclesPerSecondDoesNotThrow() {
        Clock clock = new Clock(60.0f);

        assertDoesNotThrow(() -> {
            clock.setCyclesPerSecond(30.0f);
            clock.setCyclesPerSecond(120.0f);
        });
    }
}
