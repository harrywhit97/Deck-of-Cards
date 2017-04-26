package Blackjack;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.imageio.ImageIO;

/**
 * 
 * @author Harry Whittaker
 * @since  23/12/2016
 *
 * This class represents the deck of cards which can hold more than one deck.
 */
public class DeckOfCards {
	
	//Stack of cards representing the deck
	private Stack<Card> deck;
	
	/**
	 * default constructor for DeckOfCards makes 1 shuffled deck
	 * @throws IOException 
	 */
	public DeckOfCards() throws IOException {
		this(1, true);
	}
	
	
	//information used to get sub images
	//full image: 950 x 392
	
	 final int width = 73;
	 final int height = 98;	 
	 final int collumns = 13;
	 final int rows = 4;
	 
	
	/**
	 * DeckOfCards constructor where number of decks and whether the 
	 * deck is shuffled can be specified
	 * @param numOfDecks	number of decks
	 * @param shuffle		true = deck will be shuffled; false = unshuffled
	 * @throws IOException 
	 */
	public DeckOfCards(int numOfDecks, boolean shuffle) throws IOException{		
		
		// initialise stack of cards
		deck = new Stack<Card>();
				
		//set up image
		BufferedImage image = ImageIO.read(new File("bigImage.jpg"));		
			
		//for each deck
		for(int deckNo = 0; deckNo < numOfDecks; deckNo++){
			
			//for each suit
			for(Suit suit : Suit.values()){
				//for each value
				for(int value = 0; value < 12; value++){	
					
					BufferedImage tempImage;
					
					//get the cards image
					tempImage = image.getSubimage(
							width * value,						//x axis
							height * suit.ordinal(),			//y axis
							width, height);
					
					
					//create new card
					Card tempCard = new Card(suit, value, tempImage);	
					
					//add new card to deck
					deck.push(tempCard);
				}			
			}
		}
		
		//shuffle the deck if 
		if(shuffle){
			Collections.shuffle(deck);
		}
	}//end of constructor
		
	/**
	 * This returns the card that is next on the deck and increment currentCard
	 * @return card on top of deck
	 */
	public Card dealCard(){		
		if(!deck.isEmpty()){
			return deck.pop();
		}else{
			return null;
		}
	}//end of drawCard
		
	/**
	 * This displays the deck of cards in serial monitor
	 */
	public void displayDeck(){
		for(Card c : deck){
			if(c != null){
				System.out.println(c.toString());
			}else{
				System.out.println("ERROR NULL");
			}			
		}
		System.out.println("\n");
	}//end of display deck
	
	/**
	 * this checks if the deck is empty
	 * @return true if deck is empty
	 */
	public boolean isEmpty(){
		return deck.isEmpty();
	}
	
	/**
	 * This gets the amount of cards remaining in the deck
	 * @return number of remaining cards
	 */
	public int getDeckSize(){
		return deck.size();
	}
}//End of DeckOfCards


	

