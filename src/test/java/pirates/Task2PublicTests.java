package pirates;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Task2PublicTests {

    @Test
    public void testBalance1() {
        Treasure[] treasures = new Treasure[] {
                new Treasure("Narsil", 3000),
                new Treasure("Narya", 7000),
                new Treasure("Arkenstone", 5000),
                new Treasure("Horn of Gondor",  500),
                new Treasure("Lembas", 20),
                new Treasure("Sting", 800),
                new Treasure("Vilya", 7000),
                new Treasure("Palantiri of Amon Sul", 2000),
                new Treasure("Angainor", 5000),
                new Treasure("Cauldron of Khath Meigol", 4000)
        };

        String[] pirateNames = new String[] {
                "Jack Sparrow",
                "Davy Jones",
                "Hector Barbarossa",
                "Davy Jones",
                "Jack Sparrow",
                "Redbeard",
                "Elizabeth Swann",
                "Elizabeth Swann",
                "Hector Barbarossa",
                "Elizabeth Swann"
        };

        List<Pirate> pirates = PirateManager.buildPiratesWithTreasure(treasures, pirateNames);

        assertFalse(PirateManager.isBalanced(treasures, pirates, 30));
    }

    @Test
    public void testBalance2() {
        Treasure[] treasures = new Treasure[] {
                new Treasure("Narsil", 3000),
                new Treasure("Narya", 7000),
                new Treasure("Arkenstone", 5000),
                new Treasure("Horn of Gondor",  500),
                new Treasure("Lembas", 20),
                new Treasure("Sting", 800),
                new Treasure("Vilya", 7000),
                new Treasure("Palantiri of Amon Sul", 2000),
                new Treasure("Angainor", 5000),
                new Treasure("Cauldron of Khath Meigol", 4000)
        };

        String[] pirateNames = new String[] {
                "Jack Sparrow",
                "Davy Jones",
                "Jack Sparrow",
                "Redbeard",
                "Redbeard",
                "Redbeard",
                "Hector Barbarossa",
                "Elizabeth Swann",
                "Elizabeth Swann",
                "Redbeard"
        };

        /*
            The expected mapping of pirates to treasure is:
            Jack Sparrow: Narsil, Arkenstone (total value: 8000)
            Davy Jones: Narya, Horn of Gondor (total value: 7500)
            Hector Barbarossa: Vilya (total value: 7000)
            Redbeard: Horn of Gondor, Lembas, Sting, Cauldron of Khath Meigol (total value: 5320)
            Elizabeth Swann: Palantiri of Amon Sul, Angainor (total value: 7000)
         */

        List<Pirate> pirates = PirateManager.buildPiratesWithTreasure(treasures, pirateNames);

        assertTrue(PirateManager.isBalanced(treasures, pirates, 30));
    }

}
