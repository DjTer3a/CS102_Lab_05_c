/**
 * Lab_05_c Instructions found on moodle
 * 
 * Style guidlines URL:-
 * http://www.cs.bilkent.edu.tr/~adayanik/cs101/practicalwork/styleguidelines.htm
 * 
 * 
 * @author Mostafa Higazy
 * @version 16/07/2021
 */


package cs102;


public class ConsoleHangmanView implements IHangmanView{


    /**
     * @Overrides the updateView method
     */
    @Override
    public void updateView(Hangman hangman){


        //conditionals to play the game
        if(!hangman.isGameOver()){
            System.out.println("Letters known so far :- "+ hangman.getKnownSoFar());
			System.out.println();
        	System.out.println("You have " + (hangman.getMaxAllowedIncorrectTries()-hangman.getNumOfIncorrectTries()) + " tries left.");
        	System.out.println();
        }
        else{
            if(hangman.hasLost()){
                System.out.println();
                System.out.println("You have lost. Better luck next time :)");
                System.out.println();
                System.out.println("The word was:- " + hangman.getKnownSoFar());
                System.out.println();
            }
            else{
                System.out.println();
                System.out.println("You have won. Well played.");
                System.out.println();
            }
        }   
    }
}
