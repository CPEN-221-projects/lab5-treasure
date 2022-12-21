package pirates;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class Task3PublicTests {

    @Test
    public void testBalance2Redone() {
        Treasure[] treasures1 = new Treasure[] {
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

        Treasure[] treasures2 = new Treasure[] {
                new Treasure("Narsil", 3000),
                new Treasure("Narya", 7000),
                new Treasure("The Fake Arkenstone", 5000),
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

        List<Pirate> pirates = PirateManager.buildPiratesWithTreasure(treasures2, pirateNames);

        // not a balanced allocation of the treasure that we are comparing with!
        assertFalse(PirateManager.isBalanced(treasures1, pirates, 30));
    }

    @Test
    public void testGetTreasures() {
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

        List<Pirate> pirates = PirateManager.buildPiratesWithTreasure(treasures, pirateNames);

        int jsIndex = pirates.indexOf(new Pirate("Jack Sparrow"));
        Pirate jackSparrow = pirates.get(jsIndex);
        Set<Treasure> jsTreasure = jackSparrow.getTreasures();
        assertEquals(2, jackSparrow.getTreasures().size());
        assertTrue(jsTreasure.contains(new Treasure("Narsil", 3000)));
        assertTrue(jsTreasure.contains(new Treasure("Arkenstone", 5000)));
    }

    @Test
    public void testImmutability() {
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

        List<Pirate> pirates = PirateManager.buildPiratesWithTreasure(treasures, pirateNames);

        int jsIndex = pirates.indexOf(new Pirate("Jack Sparrow"));
        Pirate jackSparrow = pirates.get(jsIndex);
        Set<Treasure> jsTreasure = jackSparrow.getTreasures();
        jsTreasure.add(new Treasure("Fool's Gold", 1));
        assertFalse(jsTreasure.equals(jackSparrow.getTreasures()));
    }

    @Test
    public void testException() {
        Treasure[] treasures = new Treasure[] {
            new Treasure("Narsil", 3000),
            new Treasure("Vilya", 7000),
            new Treasure("Palantiri of Amon Sul", 2000),
            new Treasure("Angainor", 5000),
            new Treasure("Cauldron of Khath Meigol", 4000)
        };

        String[] pirateNames = new String[] {
            "Jack Sparrow",
            "Redbeard",
            "Hector Barbarossa",
            "Elizabeth Swann",
            "Elizabeth Swann",
            "Redbeard"
        };

        IllegalArgumentException iae = assertThrows(
            IllegalArgumentException.class, () -> {
                PirateManager.buildPiratesWithTreasure(treasures, pirateNames);
            });
    }
}
