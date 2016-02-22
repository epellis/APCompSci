/**
 * This class provides a convenient way to test shuffling methods.
 */
public class Shuffler {

    /**
     * The number of consecutive shuffle steps to be performed in each call
     * to each sorting procedure.
     */
    private static final int SHUFFLE_COUNT = 8;

    /**
     * The number of values to shuffle.
     */
    private static final int VALUE_COUNT = 52;

    /**
     * Tests shuffling methods.
     * @param args is not used.
     */
    public static void main(String[] args) {
        System.out.println("Results of " + SHUFFLE_COUNT +
                " consecutive perfect shuffles:");
        int[] values1 = new int[VALUE_COUNT];
        for (int i = 0; i < values1.length; i++) {
            values1[i] = i;
        }
        for (int j = 1; j <= SHUFFLE_COUNT; j++) {
            perfectShuffle(values1);
            System.out.print("  " + j + ":");
            for (int k = 0; k < values1.length; k++) {
                System.out.print(" " + values1[k]);
            }
            System.out.println();
        }
        System.out.println();

        System.out.println("Results of " + SHUFFLE_COUNT +
                " consecutive efficient selection shuffles:");
        int[] values2 = new int[VALUE_COUNT];
        for (int i = 0; i < values2.length; i++) {
            values2[i] = i;
        }
        for (int j = 1; j <= SHUFFLE_COUNT; j++) {
            selectionShuffle(values2);
            System.out.print("  " + j + ":");
            for (int k = 0; k < values2.length; k++) {
                System.out.print(" " + values2[k]);
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Apply a "perfect shuffle" to the argument.
     * The perfect shuffle algorithm splits the deck in half, then interleaves
     * the cards in one half with the cards in the other.
     * @param values is an array of integers simulating cards to be shuffled.
     */
    public static void perfectShuffle(int[] values) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 3 *** */

        /**
         * Split values into two halves
         * If values.lenth is odd, increase the size of half1 by 1
         * If index is even, copy from half1
         * If index is odd, copy from half2
         * If values.length is odd, add the last term to the first array
         */
        int halfway = values.length / 2;
        int [] half1 = new int[(halfway) + (values.length % 2)];
        int [] half2 = new int[halfway];

        for (int i = 0; i < halfway; i++) {
            half1[i] = values[i];
            half2[i] = values[i + halfway];
        }

        if (values.length % 2 == 1){
            half1[half1.length - 1] = values[values.length - 1];
        }

        for (int i = 0; i < values.length; i++) {
            if (i % 2 == 0){
                values[i] = half1[i / 2];
            }
            if (i % 2 != 0){
                values[i] = half2[i / 2];
            }
        }

    }

    /**
     * Apply an "efficient selection shuffle" to the argument.
     * The selection shuffle algorithm conceptually maintains two sequences
     * of cards: the selected cards (initially empty) and the not-yet-selected
     * cards (initially the entire deck). It repeatedly does the following until
     * all cards have been selected: randomly remove a card from those not yet
     * selected and add it to the selected cards.
     * An efficient version of this algorithm makes use of arrays to avoid
     * searching for an as-yet-unselected card.
     * @param values is an array of integers simulating cards to be shuffled.
     */

    public static void selectionShuffle(int[] values) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 3 *** */

        int[] shuffledArray = new int[values.length];

        /**
         * Randomly generate a number from 0 to 51
         * Check to see if that number was already copied over by checking to see if it is not equal to -1
         * If it wasn't, copy it to shuffledArray, then set that entry to -1
         * If it was, generate a new number and repeat
         */
        for (int i = 0; i < values.length; i++) {
            int rand = (int)(Math.random()*values.length);

            while (values[rand] == -1){
                rand = (int)(Math.random()*values.length);
            }

            shuffledArray[i] = values[rand];
            values[rand] = (-1);
        }

        for (int i = 0; i < values.length; i++){
            values[i] = shuffledArray[i];
        }

    }
}