package KelasDanObjek.card;

    import java.util.*;

    public class Deck{

    public static int numSuits = 4;
    public static int numRanks = 13;
    public static int numCards = numSuits * numRanks;

    private CardModel[][] cards;

    public Deck() {
        cards = new CardModel[numSuits][numRanks];
        for (int suit = CardModel.DIAMONDS; suit <= CardModel.SPADES; suit++) {
            for (int rank = CardModel.ACE; rank <= CardModel.KING; rank++) {
                cards[suit-1][rank-1] = new CardModel(rank, suit);
            }
        }
    }

    public CardModel getCard(int suit, int rank) {
        return cards[suit-1][rank-1];
    }
}