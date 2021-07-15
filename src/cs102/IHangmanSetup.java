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

public interface IHangmanSetup
{
    public static final String version = "v1.0";
    
    int getMaxAllowedIncorrectTries();
    
    char getBlankChar();
    
    String getCharsToPreserve();
    
    String getAllLetters();
    
    String chooseSecretWord();
}
