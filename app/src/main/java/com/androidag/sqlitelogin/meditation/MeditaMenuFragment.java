package com.androidag.sqlitelogin.meditation;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.androidag.sqlitelogin.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MeditaMenuFragment extends Fragment implements  View.OnClickListener{

    private ImageButton btntjacobson;
    private ImageButton btnPasita;

    public MeditaMenuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_medita_menu, container, false);

        btntjacobson = (ImageButton) view.findViewById(R.id.buttonJacobson);
        btnPasita = (ImageButton) view.findViewById(R.id.buttonPasitaMenu);

        btntjacobson.setOnClickListener(this);
        btnPasita.setOnClickListener(this);
        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onClick(View view) {
        boolean fragmentTransaction = false;
        Fragment fragment = null;

        switch (view.getId()) {

            case R.id.buttonJacobson:
                fragment = new MeditaFragment1();
                fragmentTransaction = true;
                break;
            case R.id.buttonPasitaMenu:
                fragment = new PasitaFragment();
                fragmentTransaction = true;
                break;
        }
        if (fragmentTransaction) {
            changeFragment(fragment);
    }
    }

    private void changeFragment (Fragment fragment){
        getActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_frame, fragment)
                .addToBackStack(null)
                .commit();
    }
}
