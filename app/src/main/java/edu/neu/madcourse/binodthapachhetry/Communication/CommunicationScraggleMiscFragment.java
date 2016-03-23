package edu.neu.madcourse.binodthapachhetry.Communication;

import android.app.Activity;
import android.app.Fragment;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import edu.neu.madcourse.binodthapachhetry.R;


public class CommunicationScraggleMiscFragment extends Fragment{
    public String wordsFromBoard;
    TextView wordLis;
    TextView scaggleScoreNum;
    onTimeEndListener timeListener;

    private MediaPlayer mMediaPlayer;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView =
                inflater.inflate(R.layout.fragment_scraggle_misc, container, false);

        scaggleScoreNum = (TextView) rootView.findViewById(R.id.scragglescorenum);
        View buttonMute = rootView.findViewById(R.id.scraggle_button_mute);
        wordLis = (TextView) rootView.findViewById(R.id.scraggleTextViewBox);

        buttonMute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMediaPlayer = ((CommunicationScraggleGameActivity) getActivity()).mMediaPlayer;
                mMediaPlayer.stop();
            }
        });

        return rootView;
    }

    public void showWords(String s){
        wordLis.append(s + "\n");
    }

    public void showScores(int score){

        String scoreDisplay = String.valueOf(score);
        scaggleScoreNum.setText(scoreDisplay);

    }

    public interface onRestartButtonClickListener
    {
        public void clearScores();
        public void clearWordList();
    }

    public void clearScores(){

        scaggleScoreNum.setText("0");
    }

    public void clearWordList(){
        wordLis.setText("");
    }

    //Interface class to pass values between two strings
    public interface onTimeEndListener
    {
        public void changeToNextLevel();

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            timeListener = (onTimeEndListener) activity;
        } catch (Exception e){

        }

    }

}
