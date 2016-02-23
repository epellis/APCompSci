/**
 * This is a class that tests the Card class.
 */
public class CardTester {

    /**
     * The main method in this class checks the Card operations for consistency.
     *	@param args is not used.
     */
    public static void main(String[] args) {
		/* *** IMPLEMENTED IN ACTIVITY 1 *** */
        Card cardOne = new Card("Nine", "Spades", 9);
        Card cardTwo = new Card("Seven", "Hearts", 7);
        Card cardThree = new Card("King", "Clubs", 10);

        System.out.println(cardOne.matches(cardTwo));
        System.out.println(cardOne.matches(cardThree));
        System.out.println(cardOne.rank());
        System.out.println(cardThree.pointValue());
        System.out.println(cardTwo.suit());
        System.out.println(cardOne.toString());
    }
}