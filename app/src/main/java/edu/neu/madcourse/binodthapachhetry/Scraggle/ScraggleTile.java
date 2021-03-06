package edu.neu.madcourse.binodthapachhetry.Scraggle;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageButton;

import edu.neu.madcourse.binodthapachhetry.R;


public class ScraggleTile {

    public enum Owner {
        X, O, NEITHER, BOTH
    }

    public enum TileStatus{
        SELECTED, UNSELECTED, WORDFOUND
    }

    private static final int LEVEL_BLANK = 2;
    private static final int LEVEL_AVAILABLE = 3;
    private static final int LEVEL_UNSELECTED = 4;
    private static final int LEVEL_SELECTED = 5;
    private static final int LEVEL_WORDFOUND = 6;

    private TileStatus mTileStatus = TileStatus.UNSELECTED;

    private final ScraggleGameActivityFragment mGame;
    private Owner mOwner = Owner.NEITHER;
    private View mView;
    private ScraggleTile mSubTiles[];

    public ScraggleTile(ScraggleGameActivityFragment game) {
        this.mGame = game;
    }

    public View getView() {
        return mView;
    }

    public void setView(View view) {
        this.mView = view;
    }

    public ScraggleTile[] getSubTiles() {
        return mSubTiles;
    }

    public void setSubTiles(ScraggleTile[] subTiles) {
        this.mSubTiles = subTiles;
    }

    public Owner getOwner(){
        return mOwner;
    }

    public void setOwner(Owner owner){
        this.mOwner = owner;
    }

    public int getTileStatus(){
        int level = LEVEL_UNSELECTED;
        switch (mTileStatus) {
            case UNSELECTED:
                level = LEVEL_UNSELECTED;
                break;
            case SELECTED:
                level = LEVEL_SELECTED;
                break;
            case WORDFOUND:
                level = LEVEL_WORDFOUND;
        }
        return level;
    }

    public void setTileStatus(TileStatus status){
        this.mTileStatus = status;
    }

    public void animate() {
        Animator anim = AnimatorInflater.loadAnimator(mGame.getActivity(),
                R.animator.tictactoe);
        if (getView() != null) {
            anim.setTarget(getView());
            anim.start();
        }
    }
}
