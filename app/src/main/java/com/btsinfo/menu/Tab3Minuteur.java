package com.btsinfo.menu;

/**
 * Created by Zexenero on 29/11/2017.
 */

import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class Tab3Minuteur extends Fragment {
    CountDownTimer countDownTimer;
    EditText time;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab3minuteur, container, false);
        Button btTimer = (Button) rootView.findViewById(R.id.btTimer);
        Button btReset = (Button) rootView.findViewById(R.id.btReset);
        time = (EditText) rootView.findViewById(R.id.time);
        btTimer.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                int nombre = Integer.valueOf(time.getText().toString()) * 1000;
                comptearebours(nombre);
            } }) ;

        btReset.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if (countDownTimer!= null){
                    countDownTimer.cancel();
                    countDownTimer = null;
                    time.setText("");
                }
            } }) ;

        return rootView;
    }
    private void comptearebours(int nb){
        countDownTimer = new CountDownTimer(nb,1000) {
            @Override
            public void onTick(long l) {
                //On va placer la valeur en seconde (/1000) dans la zone time en le
                //convertissant en chaine de caractères (puisque c’est un TextEdit
                time.setText(String.valueOf(l/1000)) ;
            }
            @Override
            public void onFinish() {
                //A la fin du décompte on change le nombre par « Fini »
                time.setText("Fini");
            }
        }.start(); //On lance le compte-à-rebours
    }

}
