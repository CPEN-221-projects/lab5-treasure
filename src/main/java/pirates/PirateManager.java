package pirates;

import java.util.*;

public abstract class PirateManager {

    /**
     * Generate a list of pirates by assigning treasures to the pirate
     * using the name of the pirate in the pirate-to-treasure mapping
     * @param treasures the sequence of treasures, is not empty
     * @param pirateToTreasureMap pirateToTreasureMap[i] is the name of the pirate
     *                            that is given treasures[i], and is not empty
     * @return a list of pirates with each pirate being assigned the appropriate treasures
     * @throws IllegalArgumentException if treasures.length != pirateToTreasureMap.length
     */
    public static List<Pirate> buildPiratesWithTreasure(Treasure[] treasures, String[] pirateToTreasureMap) {

        if (treasures.length != pirateToTreasureMap.length) {
            throw new IllegalArgumentException();
        }

        List<Pirate> pirateList = new ArrayList<>();

        for (int i = 0; i < pirateToTreasureMap.length; i++) {
            Pirate pirate = new Pirate(pirateToTreasureMap[i]);
            int pirateIdx = pirateList.indexOf(pirate);
            if (pirateIdx != -1) {
                pirate = pirateList.get(pirateIdx);
            }
            else {
                pirateList.add(pirate);
            }
            pirate.addTreasure(treasures[i]);
        }

        return pirateList;
    }

    /**
     * Is the allocation of treasure to pirates balanced?
     *
     * @param treasures the original list of treasures, is not null
     * @param pirates the list of pirates after the treasures have been allocated
     * @param deviationPercentage the allowed variation from the mean
     *                            for the per-pirate treasure value,
     *                            is between 0 and 200
     * @return true if the allocation is balanced and false otherwise
     */
    public static boolean isBalanced(Treasure[] treasures, List<Pirate> pirates, int deviationPercentage) {
        Set<Treasure> pirateTreasures = new HashSet<>();

        for (Pirate pirate: pirates) {
            for (Treasure treasure: pirate.getTreasures()) {
                pirateTreasures.add(treasure);
            }
        }

        int totalTreasureValue = 0;
        for (Treasure treasure: treasures) {
            if (!setContainsTreasure(pirateTreasures, treasure)) {
                return false;
            }
            totalTreasureValue += treasure.value;
        }

        double valueMin = (float) totalTreasureValue / pirates.size() * (100 - deviationPercentage) / 100;
        double valueMax = (float) totalTreasureValue / pirates.size() * (100 + deviationPercentage) / 100;

        for (Pirate pirate: pirates) {
            if (pirate.getTreasureValue() < valueMin || pirate.getTreasureValue() > valueMax) {
                return false;
            }
        }
        return true;
    }

    private static boolean setContainsTreasure(Set<Treasure> pirateTreasures, Treasure treasure) {
        for (Treasure currentTreasure: pirateTreasures) {
            if (currentTreasure.name.equals(treasure.name) && currentTreasure.value == treasure.value) {
                return true;
            }
        }
        return false;
    }

}
