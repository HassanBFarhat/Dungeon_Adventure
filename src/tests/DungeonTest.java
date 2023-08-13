package tests;
import models.AbstractDungeonCharacter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Hassan Bassam Farhat
 * @author Avinash Bavisetty
 * @version Summer 2023
 */
public class DungeonTest {
    private static class DummyCharacter extends AbstractDungeonCharacter {}

    private DummyCharacter character;

    @BeforeEach
    public void setUp() {
        character = new DummyCharacter();
    }

    @Test
    public void testSetAndGetCharacterName() {
        character.setCharacterName("testname");
        assertEquals("testname", character.getCharacterName());
    }

    @Test
    public void testSetAndGetCharacterHealthPoints() {
        character.setCharacterHealthPoints(100);
        assertEquals(100, character.getCharacterHealthPoints());

        // Ensure health doesn't go negative
        character.setCharacterHealthPoints(-10);
        assertEquals(0, character.getCharacterHealthPoints());
    }

    @Test
    public void testSetAndGetCharacterHitPoints() {
        character.setCharacterHitPoints(50);
        assertEquals(50, character.getCharacterHitPoints());
    }

    @Test
    public void testSetAndGetMinimumDamageRange() {
        character.setMinimumDamageRange(5);
        assertEquals(5, character.getMinimumDamageRange());
    }

    @Test
    public void testSetAndGetMaximumDamageRange() {
        character.setMaximumDamageRange(10);
        assertEquals(10, character.getMaximumDamageRange());
    }

    @Test
    public void testSetAndGetAttackSpeed() {
        character.setAttackSpeed(3);
        assertEquals(3, character.getAttackSpeed());
    }

    @Test
    public void testSetAndGetChanceToHit() {
        character.setChanceToHit(0.8);
        assertEquals(0.8, character.getChanceToHit(), 0.00001);
    }


    @Test
    public void testAttack() {
        character.setMinimumDamageRange(5);
        character.setMaximumDamageRange(10);
        character.setChanceToHit(0.5);

        for (int i = 0; i < 1000; i++) {  // Running multiple times for randomness
            int damage = character.attack();
            assertTrue(damage >= 0 && damage <= 10);  // Ensuring damage is in the expected range
        }
    }

    @Test
    public void testToString() {
        character.setCharacterName("testname");
        character.setCharacterHealthPoints(100);
        character.setCharacterHitPoints(50);
        character.setMinimumDamageRange(5);
        character.setMaximumDamageRange(10);
        character.setAttackSpeed(3);
        character.setChanceToHit(0.8);

        String expected = "This DungeonCharacter's name is testname.\n"
                + "These are testname's stats:\n"
                + "***********************************************\n"
                + "Health: 100\n"
                + "Hit Points: 50\n"
                + "Minimum Damage Range: 5\n"
                + "Maximum Damage Range: 10\n"
                + "Attack Speed: 3\n"
                + "Chance to Hit: 0.8\n";

        assertEquals(expected, character.toString());
    }
}

