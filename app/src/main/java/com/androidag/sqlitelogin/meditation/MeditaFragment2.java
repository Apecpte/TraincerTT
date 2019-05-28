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
public class MeditaFragment2 extends Fragment {

    private ImageButton audioTorax;
    private ImageButton audioEspalda;
    private ImageButton audioEstomago;
    private ImageButton audioCintura;
    private Button goOut;
    private Button goBack;
    private Button goNext;

    public MeditaFragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_medita_fragment2, container, false);

        final MediaPlayer mediaPlayer = new MediaPlayer();

        audioTorax = (ImageButton) view.findViewById(R.id.imBtnMedita2AudioTorax);
        audioEspalda = (ImageButton) view.findViewById(R.id.imBtnMedita2AudioEspalda);
        audioEstomago = (ImageButton) view.findViewById(R.id.imBtnMedita2AudioEsto);
        audioCintura = (ImageButton) view.findViewById(R.id.imBtnMedita2AudioCintura);

        goOut = (Button) view.findViewById(R.id.buttonGoOutMedita2);
        goBack = (Button) view.findViewById(R.id.buttonBackMedita2);
        goNext = (Button) view.findViewById(R.id.buttonNextMedita2);

        audioTorax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopAndPlay(R.raw.medi_torax, mediaPlayer);
            }
        });

        audioEspalda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopAndPlay(R.raw.medi_espalda, mediaPlayer);
            }
        });

        audioEstomago.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopAndPlay(R.raw.medi_estomago, mediaPlayer);
            }
        });

        audioCintura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopAndPlay(R.raw.medi_cintura, mediaPlayer);
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
                MeditaFragment5 m5f = new MeditaFragment5();
                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.content_frame, m5f)
                        .addToBackStack(null)
                        .commit();
            }
        });

        goNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.stop();
                MeditaFragment3 m3f = new MeditaFragment3();
                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.content_frame, m3f)
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
