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
public class MeditaFragment1 extends Fragment {

    private ImageButton audioPosInicial;
    private ImageButton audioFrente;
    private ImageButton audioOjos;
    private ImageButton audioNariz;
    private ImageButton audioBoca;
    private ImageButton audioLengua;
    private ImageButton audioMandi;
    private ImageButton audioLabios;
    private Button goOut;
    private Button goNext;



    public MeditaFragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_medita_fragment1, container, false);

        final MediaPlayer mediaPlayer = new MediaPlayer();

        audioPosInicial = (ImageButton) view.findViewById(R.id.imBtnMeditaAudioPosIni);
        audioFrente = (ImageButton) view.findViewById(R.id.imBtnMedita1AudioFrente);
        audioOjos = (ImageButton) view.findViewById(R.id.imBtnMedita1AudioOjos);
        audioNariz = (ImageButton) view.findViewById(R.id.imBtnMedita1Audionariz);
        audioBoca = (ImageButton) view.findViewById(R.id.imBtnMedita1AudioBoca);
        audioLengua = (ImageButton) view.findViewById(R.id.imBtnMedita1AudioLengua);
        audioMandi = (ImageButton) view.findViewById(R.id.imBtnMedita1AudioMandi);
        audioLabios = (ImageButton) view.findViewById(R.id.imBtnMedita1AudioLabios);

        goOut = (Button) view.findViewById(R.id.buttonGoOutMedita1);
        goNext = (Button) view.findViewById(R.id.buttonNextMedita1);

        audioPosInicial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopAndPlay(R.raw.medi_posinicial, mediaPlayer);
            }
        });

        audioFrente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopAndPlay(R.raw.medi_frente, mediaPlayer);
            }
        });

        audioOjos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopAndPlay(R.raw.medi_ojos, mediaPlayer);
            }
        });

        audioNariz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopAndPlay(R.raw.medi_nariz, mediaPlayer);
            }
        });

        audioBoca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopAndPlay(R.raw.medi_boca, mediaPlayer);
            }
        });

        audioLengua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopAndPlay(R.raw.medi_lengua, mediaPlayer);
            }
        });

        audioMandi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopAndPlay(R.raw.medi_mandi, mediaPlayer);
            }
        });

        audioLabios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopAndPlay(R.raw.medi_labios, mediaPlayer);
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

        goNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.stop();
                MeditaFragment5 m5f = new MeditaFragment5();
                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.content_frame, m5f)
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
