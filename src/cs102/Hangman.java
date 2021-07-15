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


public class Hangman
{
    char blankChar;
    String charsToPreserve;
    StringBuffer secretWord;
    StringBuffer allLetters;
    StringBuffer usedLetters;
    int numberOfIncorrectTries;
    int maxAllowedIncorrectTries;
    StringBuffer knownSoFar;
    IHangmanSetup setup;
    
    public Hangman(final IHangmanSetup setup) {
        this.setup = setup;
        this.initNewGame();
    }
    
    public void initNewGame() {
        this.maxAllowedIncorrectTries = this.setup.getMaxAllowedIncorrectTries();
        this.blankChar = this.setup.getBlankChar();
        this.charsToPreserve = this.setup.getCharsToPreserve();
        this.allLetters = new StringBuffer(this.setup.getAllLetters());
        this.secretWord = new StringBuffer(this.setup.chooseSecretWord());
        this.knownSoFar = new StringBuffer();
        for (int i = 0; i < this.secretWord.length(); ++i) {
            if (this.charsToPreserve.indexOf(this.secretWord.charAt(i)) >= 0) {
                this.knownSoFar.append(this.secretWord.charAt(i));
            }
            else {
                this.knownSoFar.append(this.blankChar);
            }
        }
        this.usedLetters = new StringBuffer();
        this.numberOfIncorrectTries = 0;
    }
    
    public String getAllLetters() {
        return this.allLetters.toString();
    }
    
    public String getUsedLetters() {
        return this.usedLetters.toString();
    }
    
    public int getNumOfIncorrectTries() {
        return this.numberOfIncorrectTries;
    }
    
    public int getMaxAllowedIncorrectTries() {
        return this.maxAllowedIncorrectTries;
    }
    
    public String getKnownSoFar() {
        return this.knownSoFar.toString();
    }
    
    public int tryThis(final char letter) {
        if (this.isGameOver()) {
            return -1;
        }
        if (this.existsIn(this.usedLetters, letter)) {
            return -2;
        }
        if (this.charsToPreserve.indexOf(letter) >= 0) {
            return -4;
        }
        if (!this.existsIn(this.allLetters, letter)) {
            return -3;
        }
        int timesFound = 0;
        for (int i = 0; i < this.secretWord.length(); ++i) {
            if (Character.toUpperCase(this.secretWord.charAt(i)) == Character.toUpperCase(letter)) {
                this.knownSoFar.setCharAt(i, this.secretWord.charAt(i));
                ++timesFound;
            }
        }
        this.usedLetters.append(letter);
        if (timesFound == 0) {
            ++this.numberOfIncorrectTries;
        }
        if (this.hasLost()) {
            this.knownSoFar = this.secretWord;
        }
        return timesFound;
    }
    
    public boolean hasLost() {
        return this.numberOfIncorrectTries >= this.maxAllowedIncorrectTries;
    }
    
    public boolean isGameOver() {
        return this.hasLost() || this.isComplete();
    }
    
    private boolean isComplete() {
        return !this.existsIn(this.knownSoFar, this.blankChar);
    }
    
    private boolean existsIn(final StringBuffer s, final char c) {
        for (int i = 0; i < s.length(); ++i) {
            if (Character.toUpperCase(s.charAt(i)) == Character.toUpperCase(c)) {
                return true;
            }
        }
        return false;
    }
}
