import java.util.Scanner;
import cs102.*;

/**
 * ConsoleHangman
 *
 * @author
 * @version 1.00 2013/4/7
 */

public class ConsoleHangman
{
    public static void main( String[] args)
	{

		char letter;
    	Scanner scan = new Scanner( System.in);

    	System.out.println( "Start of ConsoleHangman\n");

		// VARIABLES
		HangmanModel		hangman;

		// PROGRAM CODE

		hangman = new HangmanModel(new BasicSetup());
		hangman.addView(new ConsoleHangmanView());
		hangman.addView(new ConsoleHangmanView());


		do{
			letter = scan.nextLine().charAt(0);
			hangman.tryThis(letter);
		}while( !hangman.isGameOver());

		System.out.println( "\nEnd of ConsoleHangman\n" );
		scan.close();
	}

	

} // end of class ConsoleHangman
