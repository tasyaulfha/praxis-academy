package KelasDanObjek.card;

    public class DisplayDeck{
        public static void main(String[] args) {
            Deck deck = new Deck();
            for (int suit = CardModel.DIAMONDS; suit <= CardModel.SPADES; suit++) {
                for (int rank = CardModel.ACE; rank <= CardModel.KING; rank++) {
                    CardModel card = deck.getCard(suit, rank);
                    System.out.format("%s of %s%n",
                        card.rankToString(card.getRank()),
                        card.suitToString(card.getSuit()));
                }
            }
        }
    }