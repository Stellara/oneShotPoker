package oneShotPoker;

public class Player {
    private boolean isWinner;

    //TODO: there is a much more elegant way to implement this, refactor
    public void setWinner(boolean wonLastGame) {
        this.isWinner = wonLastGame;
    }

    public boolean isWinner() {
        return isWinner;
    }

    //public handOfCards getHandOfCards(){
//        return handOfCards;
//        }
//
//public handOfCards setHand(handOfCards newHand){
//        this.handOfCards = newHand;
//        }
}


//    private Card[] handOfCards = new Card[5];
//    for (int i = 0; i < 5; i++) {
//        SomeClass someObject = new SomeClass();
//        // set properties
//        array[i] = someObject;
//        }
//
//public handOfCards getHandOfCards(){
//        return handOfCards;
//        }
//
//public handOfCards setHand(handOfCards newHand){
//        this.handOfCards = newHand;
//        }


//oneShotPoker.GameRunner will set the player's hand, just need to declare here that they have one
