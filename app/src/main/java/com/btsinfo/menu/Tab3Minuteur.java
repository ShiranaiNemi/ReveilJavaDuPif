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
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Tab3Minuteur extends Fragment {
    CountDownTimer countDownTimer;
    //EditText time;
    TextView minuteur;
    Spinner presetMinuteur;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab3minuteur, container, false);
        Button btTimer = (Button) rootView.findViewById(R.id.btTimer);
        Button btReset = (Button) rootView.findViewById(R.id.btReset);
        presetMinuteur = (Spinner) rootView.findViewById(R.id.spTimer);
        minuteur = (TextView) rootView.findViewById(R.id.tvMinuteur);

        btTimer.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                int nombre = Integer.valueOf(presetMinuteur.getSelectedItem().toString()) * 1000;
                comptearebours(nombre*60);
            } }) ;

        btReset.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if (countDownTimer!= null){
                    countDownTimer.cancel();
                    countDownTimer = null;
                    minuteur.setText("");
                }
            } }) ;

        return rootView;
    }
    private void comptearebours(int nb){
        countDownTimer = new CountDownTimer(nb,1000) {
            @Override
            public void onTick(long l) {
                //On fait un dateFormat
                GregorianCalendar cur_cal = new GregorianCalendar();
                cur_cal.setTimeInMillis(System.currentTimeMillis());
                GregorianCalendar cal = new GregorianCalendar();

                cal.setTimeInMillis(l);
                DateFormat dateFormat = new SimpleDateFormat("mm:ss", Locale.FRANCE);
                java.util.Date dateDate = cal.getTime();
                String retour = dateFormat.format(dateDate);


                //On va placer la valeur en seconde (/1000) dans la zone time en le
                //convertissant en chaine de caractères (puisque c’est un TextEdit
                minuteur.setText(retour) ;
            }
            @Override
            public void onFinish() {
                //A la fin du décompte on change le nombre par « Fini »
                minuteur.setText("Fini");
            }
        }.start(); //On lance le compte-à-rebours
    }

}
