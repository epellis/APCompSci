/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

    /**
     * The main method in this class checks the Deck operations for consistency.
     *	@param args is not used.
     */
    public static void main(String[] args) {
//        String[] ranks = {"jack", "queen", "king"};
//        String[] suits = {"blue", "red"};
//        int[] pointValues = {11, 12, 13};
//        Deck d = new Deck(ranks, suits, pointValues);

//        System.out.println("**** Original Deck Methods ****");
//        System.out.println("  toString:\n" + d.toString());
//        System.out.println("  isEmpty: " + d.isEmpty());
//        System.out.println("  size: " + d.size());
//        System.out.println();
//        System.out.println();
//
//        System.out.println("**** Deal a Card ****");
//        System.out.println("  deal: " + d.deal());
//        System.out.println();
//        System.out.println();
//
//        System.out.println("**** Deck Methods After 1 Card Dealt ****");
//        System.out.println("  toString:\n" + d.toString());
//        System.out.println("  isEmpty: " + d.isEmpty());
//        System.out.println("  size: " + d.size());
//        System.out.println();
//        System.out.println();
//
//        System.out.println("**** Deal Remaining 5 Cards ****");
//        for (int i = 0; i < 5; i++) {
//            System.out.println("  deal: " + d.deal());
//        }
//        System.out.println();
//        System.out.println();
//
//        System.out.println("**** Deck Methods After All Cards Dealt ****");
//        System.out.println("  toString:\n" + d.toString());
//        System.out.println("  isEmpty: " + d.isEmpty());
//        System.out.println("  size: " + d.size());
//        System.out.println();
//        System.out.println();
//
//        System.out.println("**** Deal a Card From Empty Deck ****");
//        System.out.println("  deal: " + d.deal());
//        System.out.println();
//        System.out.println();

        /**
         * Generate 3 52 space arrays for all card entries
         */
		String[] newRanks = new String[52];
        String[] newSuits = new String[52];
        int[] newPoints = new int[52];

        /**
         * Iterate through each index to generate a full deck
         */
        for (int i = 0; i < 52; i++)
        {
            /**
             * Initialize rank and suit strings
             */
            String rank = "";
            String suit = "";

            /**
             * Use divisibility rules to determine which cards should be named at that time
             * e.g. the 0th index is the same rank as the 14th index and so on...
             * This is for ranks that do not have an int value
             * For ranks that do, simply convert the remainder of the index divided by the amount of cards in a suit to get the rank
             */

            if ( (i+1) % 13 == 0 ) {
                rank = "King";
            }

            else if ( (i + 1) % 13 == 12) {
                rank = "Queen";
            }

            else if ( (i + 1) % 13 == 1) {
                rank = "Ace";
            }

            else if ( (i + 1) % 13 == 11) {
                rank = "Jack";
            }

            else {
                rank = Integer.toString((i + 1) % 13);
            }

            if (i > 13) {
                suit = "Clubs";
            }

            else if (i > 26) {
                suit = "Hearts";
            }

            else if (i > 39) {
                suit = "Diamonds";
            }

            else {
                suit = "Spades";
            }

            newRanks[i] = rank;
            newSuits[i] = suit;
            newPoints[i] = ((i + 1) % 13);
        }

        /**
         * Create a new deck with the values determined above
         * Send that deck to a string
         */
        Deck testerDeck = new Deck(newRanks, newSuits, newPoints);
        System.out.println(testerDeck.toString());
    }
}