package com.androidag.sqlitelogin.meditation;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.androidag.sqlitelogin.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PasitaFragment extends Fragment implements View.OnClickListener{

    private Button playPasita;
    private Button pausePasita;
    private Button stopPasita;
    private MediaPlayer audioPasita;

    public PasitaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pasita, container, false);

        playPasita = (Button) view.findViewById(R.id.buttonPlayPasita);
        pausePasita = (Button) view.findViewById(R.id.buttonPausePasita);
        stopPasita = (Button) view.findViewById(R.id.buttonStopPasita);

        playPasita.setOnClickListener(this);
        pausePasita.setOnClickListener(this);
        stopPasita.setOnClickListener(this);

        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.buttonPlayPasita:
                playP();
                break;
            case R.id.buttonPausePasita:
                pauseP();
                break;
            case R.id.buttonStopPasita:
                stopP();
                break;
        }
    }

    public void playP () {
        if (audioPasita == null){
            audioPasita = MediaPlayer.create(getContext(), R.raw.medi_pasita);
            audioPasita.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    stopMP();
                }
            });
        }

        audioPasita.start();
    }

    public void pauseP () {
        if (audioPasita != null){
            audioPasita.pause();
        }
    }

    public void stopP (){
        stopMP();
    }

    private void stopMP (){
        if (audioPasita != null){
            audioPasita.release();
            audioPasita = null;

        }
    }

    @Override
    public void onStop() {
        super.onStop();
        stopMP();
    }

}
