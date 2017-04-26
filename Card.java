package Blackjack;

import java.awt.image.BufferedImage;

/** 
 * An implementation of a playing card
 * 
 * @author Harry Whittaker
 * @since 23/12/2016
 */

public class Card {
	
	//The suit of the card
	private Suit suit;
	
	//The value of this card where Ace = 1, Jack-King = 11-13	
	private int value;
	
	//Image of face of card
	private BufferedImage cardImage;
	
	/**
	 * Card class constructor
	 * @param suit			suit name
	 * @param value			value of this card
	 */
	public Card(Suit suit, int value){
		this.suit = suit;
		this.value = value;
	}	
	
	public Card(Suit suit, int value, BufferedImage image){
		this.suit = suit;
		this.value = value;
		cardImage = image;
	}
		
	/**
	 * This returns the name of the card as a String
	 * @return formated name of card as String
	 */
	public String toString(){
		String[] valueName = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", 
                "Eight", "Nine", "Ten", "Jack", "Queen", "King"};		
		return valueName[value] + " of " + suit;
	}
	
	/**
	 * This returns the value of the as an int
	 * @return value	value of this card where Ace = 0, Jack-King = 10-12
	 */
	public int getValue(){
		return value;
	}
	
	/**
	 * Accesor for cardImage
	 * @return buffered image of the card
	 */
	public BufferedImage getImage(){
		return cardImage;
	}
}//End of Card


