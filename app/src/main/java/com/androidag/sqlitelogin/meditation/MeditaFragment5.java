package com.androidag.sqlitelogin.meditation;


import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.androidag.sqlitelogin.R;
import com.androidag.sqlitelogin.fragments.HomeFragment;

import java.io.IOException;

/**
 * A simple {@link Fragment} subclass.
 */
public class MeditaFragment5 extends Fragment {

    private ImageButton audioBrazos;
    private ImageButton audioCuello;
    private ImageButton audioHombros;
    private ImageButton audioPiernas;
    private Button goOut;
    private Button goBack;
    private Button goNext;

    public MeditaFragment5() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_medita_fragment5, container, false);

        final MediaPlayer mediaPlayer = new MediaPlayer();

        audioBrazos = (ImageButton) view.findViewById(R.id.imBtnMedita5AudioBrazos);
        audioCuello = (ImageButton) view.findViewById(R.id.imBtnMedita5AudioCuello);
        audioHombros = (ImageButton) view.findViewById(R.id.imBtnMedita5AudioHombros);
        audioPiernas = (ImageButton) view.findViewById(R.id.imBtnMedita5AudioPiernas);

        goOut = (Button) view.findViewById(R.id.buttonGoOutMedita5);
        goBack = (Button) view.findViewById(R.id.buttonBackMedita5);
        goNext = (Button) view.findViewById(R.id.buttonNextMedita5);

        audioBrazos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopAndPlay(R.raw.medi_brazosmanos, mediaPlayer);
            }
        });

        audioCuello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopAndPlay(R.raw.medi_cuellonuca, mediaPlayer);
            }
        });

        audioHombros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopAndPlay(R.raw.medi_hombroscuello, mediaPlayer);
            }
        });

        audioPiernas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopAndPlay(R.raw.medi_piernas, mediaPlayer);
            }
        });

        goOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.stop();
                HomeFragment hf = new HomeFragment();
                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.content_frame, hf)
                        .addToBackStack(null)
                        .commit();
            }
        });

        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.stop();
                MeditaFragment1 m1f = new MeditaFragment1();
                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.content_frame, m1f)
                        .addToBackStack(null)
                        .commit();
            }
        });

        goNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.stop();
                MeditaFragment2 m2f = new MeditaFragment2();
                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.content_frame, m2f)
                        .addToBackStack(null)
                        .commit();
            }
        });
        // Inflate the layout for this fragment
        return view;
    }

    // This resets the mediaPlayer and starts the given audio
    private void stopAndPlay(int rawId, MediaPlayer mediaPlayer) {
        mediaPlayer.reset();
        AssetFileDescriptor afd = this.getResources().openRawResourceFd(rawId);
        try {
            mediaPlayer.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
            mediaPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
        mediaPlayer.start();
    }

}
