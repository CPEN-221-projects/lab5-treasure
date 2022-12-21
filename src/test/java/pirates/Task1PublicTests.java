package pirates;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Task1PublicTests {

    private static List<Pirate> pirates;

    @BeforeAll
    private static void setupTests() {
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

        /*
            The expected mapping of pirates to treasure is:
            Jack Sparrow: Narsil, Lembas (total value: 3020)
            Davy Jones: Narya, Horn of Gondor (total value: 7500)
            Hector Barbarossa: Arkenstone, Angainor (total value: 10000)
            Redbeard: Sting (total value: 800)
            Elizabeth Swann: Vilya, Palantiri of Amon Sul, Cauldron of Khath Meigol (total value: 13000)
         */

        pirates = PirateManager.buildPiratesWithTreasure(treasures, pirateNames);
    }

    @Test
    @Order(1)
    public void testValue() {
        Pirate jackSparrow = new Pirate("Jack Sparrow");
        int jsIndex = pirates.indexOf(jackSparrow);
        jackSparrow = pirates.get(jsIndex);
        assertEquals(3020, jackSparrow.getTreasureValue());
    }

    @Test
    @Order(2)
    public void testHighestValueTreasure() {
        Pirate elizabethSwann = new Pirate("Elizabeth Swann");
        int esIndex = pirates.indexOf(elizabethSwann);
        elizabethSwann = pirates.get(esIndex);
        assertEquals(new Treasure("Vilya", 7000), elizabethSwann.getHighestValueTreasure());
    }
}