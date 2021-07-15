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


import java.util.ArrayList;


public class HangmanModel extends Hangman{

    ArrayList<IHangmanView> views =  new ArrayList<IHangmanView>(); 


    /**
     * constructor for hangman
     */
    public HangmanModel(IHangmanSetup setup) {
        super(setup);
    }


    /**
     * @return void method to add a view
     */
    public void addView(IHangmanView view){
        views.add(view);
        view.updateView(this);
    }


    /**
     * @return void method to update the view
     */
    public void update(){
        for(int i =0; i < views.size(); i++){
            views.get(i).updateView(this);
        }
    }


    /**
     * @Overrides the tryThis method
     */
    @Override
    public int tryThis(char letter){
        int tryThis = super.tryThis(letter);
        update();
        return tryThis;
    }


    /**
     * @Overrides the initNewGame method
     */
    @Override
    public void initNewGame(){
        super.initNewGame();
    }
}