package org.psnbtech.entity;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Graphics2D;

import org.junit.jupiter.api.Test;
import org.psnbtech.Game;
import org.psnbtech.util.Vector2;

public class EntityTest {

    // Minimal concrete Entity for testing
    private static class TestEntity extends Entity {

        public TestEntity(Vector2 position, Vector2 velocity, double radius, int killScore) {
            super(position, velocity, radius, killScore);
        }

        @Override
        public void handleCollision(Game game, Entity other) {}

        @Override
        public void draw(Graphics2D g, Game game) {}
    }

    // Test 1: Entity stores and returns its position correctly
    @Test
    void testGetPositionReturnsCorrectValue() {
        Vector2 pos = new Vector2(10, 20);
        TestEntity entity = new TestEntity(pos, new Vector2(0, 0), 5.0, 0);

        assertEquals(pos, entity.getPosition());
    }

    // Test 2: Entity stores and returns its velocity correctly
    @Test
    void testGetVelocityReturnsCorrectValue() {
        Vector2 vel = new Vector2(3, 4);
        TestEntity entity = new TestEntity(new Vector2(0, 0), vel, 5.0, 0);

        assertEquals(vel, entity.getVelocity());
    }

    // Test 3: rotate changes the rotation value
    @Test
    void testRotateChangesRotation() {
        TestEntity entity = new TestEntity(new Vector2(0, 0), new Vector2(0, 0), 5.0, 0);

        double before = entity.getRotation();
        entity.rotate(Math.PI / 2);
        double after = entity.getRotation();

        assertNotEquals(before, after);
    }

    // Test 4: flagForRemoval marks entity as needing removal
    @Test
    void testFlagForRemovalSetsNeedsRemoval() {
        TestEntity entity = new TestEntity(new Vector2(0, 0), new Vector2(0, 0), 5.0, 0);

        assertFalse(entity.needsRemoval());

        entity.flagForRemoval();

        assertTrue(entity.needsRemoval());
    }

    // Test 5: checkCollision returns true for overlapping entities
    @Test
    void testCheckCollisionDetectsOverlap() {
        TestEntity entity1 = new TestEntity(new Vector2(0, 0), new Vector2(0, 0), 10.0, 0);
        TestEntity entity2 = new TestEntity(new Vector2(5, 0), new Vector2(0, 0), 10.0, 0);

        assertTrue(entity1.checkCollision(entity2));
    }
}
