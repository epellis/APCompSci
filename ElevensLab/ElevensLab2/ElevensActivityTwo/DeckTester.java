/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

    /**
     * The main method in this class checks the Deck operations for consistency.
     *	@param args is not used.
     */
    public static void main(String[] args) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */
        String[] ranks = new String[] {"Two", "Eight", "Seven", "Queen"};
        String[] suits = new String[] {"Hearts", "Spades", "Diamonds", "Clubs"};
        int[] values = new int[] {5, 3, 11, 2, 10, 1};

        /**
         * Initialize a new deck to test
         */
        Deck testDeck = new Deck(ranks, suits, values);

        /**
         * Test test all deck methods on the object testDeck
         */
        System.out.println(testDeck.isEmpty());
        System.out.println(testDeck.size());
        System.out.println("");
        System.out.println(testDeck.deal());
        System.out.println(testDeck.deal());
        System.out.println("");
        System.out.println(testDeck.size());
        System.out.println("");
        System.out.println(testDeck.toString());
    }
}