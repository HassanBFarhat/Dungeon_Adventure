package tests;

import models.Adventurer;
import models.RoomItems;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Avinash Bavisetty
 * @author Hassan Bassam Farhat
 * @version Summer 2023
 */

public class AdventurerTest {
    private Adventurer adventurer;

    @BeforeEach
    public void setup() {
        adventurer = new Adventurer("John", 100,
                10, 5, 20, 3, 0.8);
    }

    @Test
    public void testSetMyHealingPotions() {
        adventurer.setMyHealingPotions(5);
        assertEquals(5, adventurer.getMyHealingPotions());

        adventurer.setMyHealingPotions(-3);
        assertEquals(2, adventurer.getMyHealingPotions());

        adventurer.setMyHealingPotions(-5);
        assertEquals(0, adventurer.getMyHealingPotions());
    }

    @Test
    public void testAddPillarToMyPillarsArray() {

        // Initially the list of pillars should be empty
        assertTrue(adventurer.getMyPillars().isEmpty());

        // Add the ENTRANCE to the list
        adventurer.addPillarToMyPillarsArray(RoomItems.ENTRANCE);

        // Check if the list now contains ENTRANCE
        assertTrue(adventurer.getMyPillars().contains(RoomItems.ENTRANCE));
        assertEquals(1, adventurer.getMyPillars().size());

        // Add EXIT and check the size
        adventurer.addPillarToMyPillarsArray(RoomItems.EXIT);

        // Check if the list now contains EXIT
        assertTrue(adventurer.getMyPillars().contains(RoomItems.EXIT));
        assertEquals(2, adventurer.getMyPillars().size());

        // Add HEALING_POTION and check the size
        adventurer.addPillarToMyPillarsArray(RoomItems.HEALING_POTION);

        // Check if the list now contains HEALING_POTION
        assertTrue(adventurer.getMyPillars().contains(RoomItems.HEALING_POTION));
        assertEquals(3, adventurer.getMyPillars().size());

        // Add PIT and check the size
        adventurer.addPillarToMyPillarsArray(RoomItems.PIT);

        // Check if the list now contains PIT
        assertTrue(adventurer.getMyPillars().contains(RoomItems.PIT));
        assertEquals(4, adventurer.getMyPillars().size());

        // Add ABSTRACTION_PILLAR and check the size
        adventurer.addPillarToMyPillarsArray(RoomItems.ABSTRACTION_PILLAR);

        // Check if the list now contains ABSTRACTION_PILLAR
        assertTrue(adventurer.getMyPillars().contains(RoomItems.ABSTRACTION_PILLAR));
        assertEquals(5, adventurer.getMyPillars().size());

        // Add ENCAPSULATION_PILLAR and check the size
        adventurer.addPillarToMyPillarsArray(RoomItems.ENCAPSULATION_PILLAR);

        // Check if the list now contains ENCAPSULATION_PILLAR
        assertTrue(adventurer.getMyPillars().contains(RoomItems.ENCAPSULATION_PILLAR));
        assertEquals(6, adventurer.getMyPillars().size());

        // Add INHERITANCE_PILLAR and check the size
        adventurer.addPillarToMyPillarsArray(RoomItems.INHERITANCE_PILLAR);

        // Check if the list now contains INHERITANCE_PILLAR
        assertTrue(adventurer.getMyPillars().contains(RoomItems.INHERITANCE_PILLAR));
        assertEquals(7, adventurer.getMyPillars().size());

        // Add POLYMORPHISM_PILLAR and check the size
        adventurer.addPillarToMyPillarsArray(RoomItems.POLYMORPHISM_PILLAR);

        // Check if the list now contains POLYMORPHISM_PILLAR
        assertTrue(adventurer.getMyPillars().contains(RoomItems.POLYMORPHISM_PILLAR));
        assertEquals(8, adventurer.getMyPillars().size());
    }

    @Test
    public void testSaveAndLoadToFile() throws IOException {
        String fileName = "tempAdventurer.ser";

        try {
            adventurer.saveToFile(fileName, adventurer);

            File file = new File(fileName);
            assertTrue(file.exists());

            Adventurer loadedAdventurer = Adventurer.loadFile(fileName);
            assertNotNull(loadedAdventurer);
            assertEquals(adventurer.getMyHealingPotions(), loadedAdventurer.getMyHealingPotions());

        } finally {
            // Clean up the temp file
            new File(fileName).delete();
        }
    }
}
