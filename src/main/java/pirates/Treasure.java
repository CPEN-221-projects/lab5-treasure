package pirates;

/*** do not change this class ***/

public class Treasure {
    public final String name;
    public final int value;

    /**
     * Create a treasure instance
     *
     * @param name the name of the treasure object, is not null or empty
     * @param value the value of the treasure object, >= 0
     */
    public Treasure(String name, int value) {
        this.name  = name;
        this.value = value;
    }

    /**
     * Get the value of this treasure
     * @return the value of this treasure
     */
    public int getValue() {
        return value;
    }

    /**
     * Get the name of this treasure
     * @return the name of this treasure
     */
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " (" + value + ")";
    }

    @Override
    public int hashCode() {
        return name.hashCode() + value;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Treasure) {
            Treasure that = (Treasure) other;
            return this.name.equals(that.name) && this.value == that.value;
        }
        else {
            return false;
        }
    }
}
