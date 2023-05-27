package exercise1;

import java.util.Random;
import java.util.Scanner;

/**
 * A class that fills a hand of 7 cards with random Card Objects and then asks the user to pick a card.
 * It then searches the array of cards for the match to the user's card. 
 * To be used as starting code in Exercise
 *
 * @author dancye
 * @author Paul Bonenfant Jan 25, 2022 
 */
public class CardTrick {
    
    public static void main(String[] args) {
        
        Card[] hand = new Card[7];
        Random random = new Random();
        Scanner input = new Scanner(System.in);        
        String allCards="";//make a record for all cards information

        for (int i = 0; i < hand.length; i++) {
            //Card card = new Card();
            //card.setValue(insert call to random number generator here)
            //card.setSuit(Card.SUITS[insert call to random number between 0-3 here])
            // Hint: You can use Random -> random.nextInt(n) to get a random number between 0 and n-1 (inclusive)
            //       Don't worry about duplicates at this point
           
            // get the random value range from 1 to 13
            int randomValue = random.nextInt(12)+1;
            // get the random suit number to acquire the suit
            int randomSuitNumber = random.nextInt(3);
            
            //using constructor to generate the random cards
            hand[i] = new Card(randomSuitNumber, randomValue);

            allCards +="Card "+(i+1)+": "+Card.SUITS[randomSuitNumber]+" "+cardName(randomValue)+"\n";

            
        }

        // insert code to ask the user for Card value and suit, create their card
        // and search the hand here. 
        // Hint: You can ask for values 1 to 10, and then
        //       11 for jack, 12 for queen, etc. (remember arrays are 0-based though)
        //       1 for Hearts, 2 for Diamonds, etc. (remember arrays are 0-based though)
        // 
        // Then loop through the cards in the array to see if there's a match.
        
        // If the guess is successful, invoke the printInfo() method below.
        System.out.println("Please pick a card value(1-13)");
        System.out.println("Jack(11), Queen(12), King(13),Ace(1)");
        System.out.print("Your guessed value:");
        int guessValue = input.nextInt();
        System.out.println("Please pick a suit number");
        System.out.println("Clubs(1),Spades(2),Diamonds(3),Hearts(4)");
        System.out.print("Your guessed suit:");
        int guessSuit = input.nextInt();
        
        //a flag to check the result
        boolean isCorrect = false;
        
        for(int i =0; i<hand.length; i++){
            //if card value and suit are both correct then displaying the information
            if(guessValue == hand[i].getValue() && Card.SUITS[guessSuit].equals(hand[i].getSuit())){
                printInfo();
                // change the status of flag             
                isCorrect = true;
                break;                
            }
        }
        //if it is not correct, display sorry
        if(!isCorrect){
            System.out.println("Sorry! You card is not on the hand!");
        }
        
        //display all cards on the hand
        System.out.println(allCards);
        
    }
    
    private static String cardName(int value){
        if(value<=10&&value >1){
            return ""+value;
        }else if(value == 11){
            return "Jack";
        }else if (value == 12){
            return "Queen";
        }else if (value ==13){
            return "King";
        }else{
            return "Ace";
        }
    }
    

    /**
     * A simple method to print out personal information. Follow the instructions to 
     * replace this information with your own.
     * @author Fuyin Che, May 26, 2023
     */
    private static void printInfo() {
    
        System.out.println("Congratulations, you guessed right!");
        System.out.println();
        
        System.out.println("My name is Fuyin Che, but you can call me Alvin");
        System.out.println();
        
        System.out.println("My career ambitions:");
        System.out.println("-- A Problem Solver.");        
        System.out.println();	

        System.out.println("My hobbies:");
        System.out.println("-- Simulator Games");
        System.out.println("-- Cooking");
        System.out.println("-- Reading");   
        System.out.println();
        
    
    }

}
