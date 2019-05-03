
package com.androidag.sqlitelogin.test;


import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidag.sqlitelogin.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class gifTestFragment2 extends Fragment {


    public gifTestFragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gif_test_fragment2, container, false);

        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                //Second fragment after 15 seconds appears
                TestFragment1 tF = new TestFragment1();
                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.content_frame, tF)
                        .addToBackStack(null)
                        .commit();

            }
        };

        handler.postDelayed(runnable, 5000);
        // Inflate the layout for this fragment
        return view;
    }

}
