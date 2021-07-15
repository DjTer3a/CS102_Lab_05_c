package cs102;

import java.util.ArrayList;

public class HangmanModel extends Hangman{

    ArrayList<IHangmanView> views =  new ArrayList<IHangmanView>(); 


    public HangmanModel(IHangmanSetup setup) {
        super(setup);
    }

    public void addView(IHangmanView view){
        views.add(view);
        view.updateView(this);
    }

    public void update(){
        for(int i =0; i < views.size(); i++){
            views.get(i).updateView(this);
        }
    }

    @Override
    public int tryThis(char letter){
        int tryThis = super.tryThis(letter);
        update();
        return tryThis;
    }

    @Override
    public void initNewGame(){
        super.initNewGame();
    }
}