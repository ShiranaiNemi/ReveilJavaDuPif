package com.btsinfo.menu;

/**
 * Created by Zexenero on 29/11/2017.
 */

import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;

public class Tab2Chrono extends Fragment{
    com.btsinfo.menu.Chronometer chrono;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab2chrono, container, false);
        Button btStart = (Button) rootView.findViewById(R.id.btStart);
        Button btStop = (Button) rootView.findViewById(R.id.btStop);
        Button btInit = (Button) rootView.findViewById(R.id.btInit);
        btStart.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                chrono.start();
            } }) ;
        btStop.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                chrono.stop();
            } }) ;
        btInit.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                chrono.setBase(SystemClock.elapsedRealtime());
            } }) ;
        chrono = (com.btsinfo.menu.Chronometer) rootView.findViewById(R.id.chrn1);
        return rootView;

    }
}
