package cs102;

public class ConsoleHangmanView implements IHangmanView{

    @Override
    public void updateView(Hangman hangman){
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
