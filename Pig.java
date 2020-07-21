/*

Programmer: Tiger Ye
Course Code: ICS3U1-03
Date Submitted: 13/06/2018
Program: Pig
Description: This program runs the game pig for 2 diffrent players. It generates 
random numbers between 1 - 6 which is to simulate a dice roll. The program keeps 
track of each players point values and finishes when one player has gotten or
exceeded the amount needed to win. 

*/
import hsa.Console;
import java.util.Random;
// The "Pig" class.
public class Pig
{
    static Console c;
    public static void main (String[] args)
    {
	c = new Console();
	Random rand = new Random();
	//player turns
	boolean p1_turn = true;
	boolean p2_turn = true;
	boolean game = true;
	//names of players 
	String p1;
	String p2;
	// player turn points
	int p1turnp;
	int p2turnp;
	// player points 
	int p1_points = 0;
	int p2_points = 0;
	//role again
	String role;
	// win amount
	int win = 100;
	//Bulk of the program starts here 
	c.println("Welcome to");
	c.println(" ____ ___ ____ ");
	c.println("|  _ |_ _/ ___|");
	c.println("| |_) | | |  _ ");
	c.println("|  __/| | |_| |");
	c.println("|_|  |___\\____|");
	c.println();
	//Asks for player1 name 
	c.print("Player 1, please input your name: ");
	p1 = c.readString();
	//Asks for player2 name 
	c.print("Player 2, please input your name: ");
	p2 = c.readString();
	//Ask the player for when to determine a winner for flexibility 
	c.print("What do you want the game point to be? ");
	win = c.readInt();
	//The main game loop where it continues until game == false
	while (game == true){
	    //always resets the player turn point total to 0 every loop
	    p1turnp = 0;
	    p2turnp = 0;
	    //p1 turn 
	    while(p1_turn == true){
		//int roll1 is always generated at the start of the turn 
		int  roll1 = rand.nextInt(6) + 1;
		//The roll is then printed out to the user 
		c.println(p1 + " rolled a " + roll1 + " !");
		//The roll number is added to the point total of the player's turn
		p1turnp += roll1;
		//checks to see if the roll was a 1 
		if (roll1 == 1){
		    //if it was a 1 displays the player earned 0 points and moves on to p2 turn 
		    c.println(p1 +" you earned 0 points and need " + (win-p1_points) + " to win the game !");
		    c.println();
		    //player2 loop runs 
		    p2_turn = true;
		    p1_turn = false;
		    
		}
		//anything other than a 1 should prompt as follows 
		else {
		    //the amount of points the player has won this turn and how many he has in total
		    c.println("You have " + p1turnp + " points, " + (p1_points + p1turnp) + " in total! ");
		    c.println();
		    //checks to see if the amount of points in the turn plus the total amount equals or is greater than the required amount to win
		    if ((p1turnp + p1_points) >= win){
			p1_points += p1turnp;
			//Everything is put to false and the current loop is broken 
			p1_turn = false;
			p2_turn = false;
			game = false;
			break;
		    }
		    //asks the user if they would like to role again 
		    c.print("Would you like to role again? (y/n)");
		    role = c.readString();
		    c.println();
		    //as long as the answer is not "n" the loop just runs again 
		    if (role.equals("n")){
			//points that turn are added to the point total 
			p1_points += p1turnp;
			//user is told how many points they earned that turn and how many more they need to win 
			c.println(p1 +" you earned "+ p1turnp+ " points and need " + (win-p1_points) + " to win the game !");
			c.println();
			//player2 loop runs 
			p2_turn = true;
			p1_turn = false;
			
		    }
		}
		    
		    
	    }
	    //p2 turn 
	    while( p2_turn == true){
		//int roll2 is always generated at the start of the turn 
		int  roll2 = rand.nextInt(6) + 1;
		//The roll is then printed out to the user 
		c.println(p2 + " rolled a " + roll2 + " !");
		//The roll number is added to the point total of the player's turn
		p2turnp += roll2;
		//checks to see if the roll was a 1 
		if (roll2 == 1){
		    //if it was a 1 displays the player earned 0 points and moves on to p1 turn 
		    c.println(p2 +" you earned 0 points and need " + (win-p2_points) + " to win the game !");
		    c.println();
		    //player2 loop runs 
		    p1_turn = true;
		    p2_turn = false;
		}
		//anything other than a 1 should prompt as follows 
		else {
		    //the amount of points the player has won this turn and how many he has in total
		    c.println("You have " + p2turnp + " points, " + (p2_points+p2turnp) + " in total! ");
		    c.println();
		    //checks to see if the amount of points in the turn plus the total amount equals or is greater than the required amount to win
		    if ((p2turnp + p2_points) >= win){
			p2_points += p2turnp;
			//Everything is put to false and the current loop is broken 
			p1_turn = false;
			p2_turn = false;
			game = false;
			break;
		    }
		    //asks the user if they would like to role again 
		    c.print("Would you like to role again? (y/n)");
		    role = c.readString();
		    c.println();
		    //as long as the answer is not "n" the loop just runs again 
		    if (role.equals("n")){
			//points that turn are added to the point total 
			p2_points += p2turnp;
			//user is told how many points they earned that turn and how many more they need to win 
			c.println(p2 +" you earned "+ p2turnp+ " points and need " + (win-p2_points) + " to win the game !");
			c.println();
			//player2 loop runs 
			p1_turn = true;
			p2_turn = false;
		    }
		}
		    
		    
	    }
	 
	}
	//when out of the loop if player1 was the one with the winning amount of points
	if (p1_points >= win){
	    c.print("GAME OVER! " + p1 + " wins the game!");
	}
	//else if player 2 was the one with the winning amount of points 
	else if (p2_points >= win){
	    c.print("GAME OVER! " + p2 + " wins the game!");
	}
	// Place your code here
    } // main method
} // Pig class
