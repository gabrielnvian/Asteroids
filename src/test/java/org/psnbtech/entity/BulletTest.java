package org.psnbtech.entity;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Graphics2D;

import org.junit.jupiter.api.Test;
import org.psnbtech.Game;
import org.psnbtech.util.Vector2;

public class BulletTest {

    // Minimal concrete Entity for testing
    private static class TestEntity extends Entity {
        public TestEntity(Vector2 position, Vector2 velocity, double radius, int killValue) {
            super(position, velocity, radius, killValue);
        }

        @Override
        public void handleCollision(Game game, Entity other) {}

        @Override
        public void draw(Graphics2D g, Game game) {}
    }

    // Test 1: Bullet can be created from an owner entity
    @Test
    void testBulletCreationFromOwner() {
        Entity owner = new TestEntity(new Vector2(0, 0), new Vector2(0, 0), 5.0, 0);
        Bullet bullet = new Bullet(owner, 0.0);

        assertNotNull(bullet);
    }

    // Test 2: Two bullets created from the same owner are different objects
    @Test
    void testTwoBulletsAreDifferentObjects() {
        Entity owner = new TestEntity(new Vector2(0, 0), new Vector2(0, 0), 5.0, 0);

        Bullet bullet1 = new Bullet(owner, 0.0);
        Bullet bullet2 = new Bullet(owner, 0.0);

        assertNotSame(bullet1, bullet2);
    }

    // Test 3: Bullet update can be called without throwing
    @Test
    void testBulletUpdateDoesNotThrow() {
        Entity owner = new TestEntity(new Vector2(0, 0), new Vector2(0, 0), 5.0, 0);
        Bullet bullet = new Bullet(owner, 0.0);

        assertDoesNotThrow(() -> {
            bullet.update(null);
        });
    }

    // Test 4: Bullet handleCollision can be called without throwing
    @Test
    void testBulletHandleCollisionDoesNotThrow() {
        Entity owner = new TestEntity(new Vector2(0, 0), new Vector2(0, 0), 5.0, 0);
        Bullet bullet = new Bullet(owner, 0.0);

        Entity other = new TestEntity(new Vector2(1, 1), new Vector2(0, 0), 5.0, 0);

        assertDoesNotThrow(() -> {
            bullet.handleCollision(null, other);
        });
    }

    // Test 5: Multiple bullet updates can be called safely
    @Test
    void testMultipleBulletUpdatesDoNotThrow() {
        Entity owner = new TestEntity(new Vector2(0, 0), new Vector2(0, 0), 5.0, 0);
        Bullet bullet = new Bullet(owner, 0.0);

        assertDoesNotThrow(() -> {
            for (int i = 0; i < 10; i++) {
                bullet.update(null);
            }
        });
    }
}
