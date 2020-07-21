/* 

Programmer: Tiger Ye
Course Code: ICS3U1-03
Date Submitted: 13/06/2018
Program: World_Cup
Description: This program asks the user for the amount and diffrent tickets they
want to order. Then it asks them for personal imfromation needed to complete the 
purchase and processes the order.

*/
import hsa.Console;
import java.text.DecimalFormat;

// The "World_Cup" class.
public class World_Cup
{
    static Console c;
    public static void main (String[] args)
    {
	c = new Console(75,50);
	// Sets the 2 diffrent output formats that I will be using 
	// The standard for money 
	DecimalFormat f = new DecimalFormat("##.00");
	//Whole numbers used to fuind the amount of spaces I need to properly format output 
	DecimalFormat d = new DecimalFormat("##");
	//String variables 
	String name;
	String digit_number;
	String expiry;
	//Spaces used to format 
	String space = "";
	String space2 = "";
	String space3 = "";
	String space4 = "";
	
	//Double variables of the card costs   
	double plat = 150.00;
	double gold = 120.00;
	double red = 80.75;
	double green = 50.25;
	
	//Int variables for the amount of cards ordered (you cant order parts of a card)
	int platnum;
	int goldnum;
	int rednum;
	int greennum;
	//Payment method 
	int payment;
	
	// The start of the actual program 
	c.println("             2014 FIFA WORLD CUP  ");
	//Stating the prices of the cards 
	c.println("  SECTION                            PRICE ");
	c.println("  Platinum                          150.00  ");
	c.println("  Gold                              120.00  ");
	c.println("  Red                                80.75  ");
	c.println("  Green                              50.25  ");
	c.println("  ----------------------------------------  ");
	//Ask for the user input and takes it to be used later to calculate costs
	c.print("  Enter number of platinum tickets:    ");
	platnum = c.readInt();
	c.print("  Enter number of gold tickets:        ");
	goldnum = c.readInt();
	c.print("  Enter number of red tickets:         ");
	rednum = c.readInt();
	c.print("  Enter number of green tickets:       ");
	greennum = c.readInt();
	c.println("  ----------------------------------------- ");
	double subtotal = (plat * platnum + gold * goldnum + red * rednum + green * greennum);
	//Takes the length of the int value and prints more or less spaces accordingly so that the formating is neat 
	int subtotallength = String.valueOf(d.format(subtotal)).length(); 
	//Adds spaces until the it is equal to the proper amount of spaces - the length of the output  
	for(int i = 1; i < (28 - subtotallength); i ++){
	    space = space + " ";
	}   
	c.println("  SUBTOTAL:" + space + "$" + f.format(subtotal));
	int hst = String.valueOf(d.format(subtotal*0.13)).length();
	for(int k = 1; k < (33 - hst); k ++){
	    space2 = space2 + " ";
	}
	c.println("  HST:" + space2 + "$" + f.format(subtotal * 0.13));
	int service = String.valueOf(d.format((platnum+rednum+greennum+goldnum)*12.5)).length();
	for(int j = 1; j < (24 - service); j ++){
	    space3 = space3 + " ";
	}
	c.println("  SERVICE FEES:" + space3 + "$" + f.format((platnum+rednum+greennum+goldnum)*12.5));
	int totallength = String.valueOf(d.format(subtotal + (subtotal*0.13)+((platnum+rednum+greennum+goldnum)*12.5))).length();
	for(int r = 1; r < (31 - totallength); r ++){
	    space4 = space4 + " ";
	}
	c.println("  TOTAL:"+ space4+"$" + f.format(subtotal + (subtotal*0.13)+((platnum+rednum+greennum+goldnum)*12.5)));
	c.println("  ----------------------------------------- ");
	//Useless personal imfromation that does not need to be used for an output 
	c.println("  How will you be paying?");
	c.println();
	c.println("  1 - VISA");
	c.println("  2 - MasterCard");
	c.println("  3 - American Express");
	c.println();
	c.print("  Enter the payment method:         ");
	payment = c.readInt();
	c.println();
	c.print("  Enter your name:               ");
	name = c.readLine();
	c.print("  Enter the 16-digit number:     ");
	digit_number = c.readString();
	c.print("  Enter the expiry date (mmyyyy):");
	expiry = c.readString();
	c.println();
	//Thanks the customer for his order with the string name we got earlier 
	c.print("  Thank you " + name + "! Your order has been \n  processed!");
	
	// Place your code here
    } // main method
} // World_Cup class
