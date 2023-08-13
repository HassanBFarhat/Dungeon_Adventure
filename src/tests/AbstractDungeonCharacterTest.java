package tests;

import models.AbstractDungeonCharacter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AbstractDungeonCharacterTest {
    private TestDungeonCharacter character;

    @BeforeEach
    void setUp() {
        character = new TestDungeonCharacter("Test Character", 100, 10, 5, 20, 3, 0.8);
        character.setChanceToHit(1.0); // 100% chance to hit
        character.setMinimumDamageRange(5); // Assuming this method exists
        character.setMaximumDamageRange(20); // Assuming this method exists
    }

    @Test
    void testAttack() {
        // Test the attack() method based on the character's configuration
        int attackValue = character.attack();
        assertTrue(attackValue >= 5 && attackValue <= 20);
    }

    @Test
    void testSetAndGetCharacterName() {
        character.setCharacterName("New Name");
        assertEquals("New Name", character.getCharacterName());
    }

    // Similar tests for other getters and setters...
    @Test
    void testSetAndGetCharacterHealthPoints() {
        character.setCharacterHealthPoints(50);
        assertEquals(50, character.getCharacterHealthPoints());

        // Testing for negative value
        character.setCharacterHealthPoints(-10);
        assertEquals(0, character.getCharacterHealthPoints());
    }

    @Test
    void testSetAndGetCharacterHitPoints() {
        character.setCharacterHitPoints(15);
        assertEquals(15, character.getCharacterHitPoints());
    }

    @Test
    void testSetAndGetMinimumDamageRange() {
        character.setMinimumDamageRange(7);
        assertEquals(7, character.getMinimumDamageRange());
    }

    @Test
    void testSetAndGetMaximumDamageRange() {
        character.setMaximumDamageRange(25);
        assertEquals(25, character.getMaximumDamageRange());
    }

    @Test
    void testSetAndGetAttackSpeed() {
        character.setAttackSpeed(4);
        assertEquals(4, character.getAttackSpeed());
    }

    @Test
    void testSetAndGetChanceToHit() {
        character.setChanceToHit(0.75);
        assertEquals(0.75, character.getChanceToHit(), 0.01);
    }

    private static class TestDungeonCharacter extends AbstractDungeonCharacter {
        public TestDungeonCharacter(String theCharacterName, int theCharacterHealthPoints, int theCharacterHitPoints, int theMinimumDamageRange, int theMaximumDamageRange, int theAttackSpeed, double theChanceToHit) {
//            super(theCharacterName, theCharacterHealthPoints, theCharacterHitPoints, theMinimumDamageRange, theMaximumDamageRange, theAttackSpeed, theChanceToHit);
        }
    }
}

