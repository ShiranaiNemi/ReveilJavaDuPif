package com.btsinfo.menu;

/**
 * Created by Zexenero on 29/11/2017.
 */

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Tab1Alarme extends Fragment{
    TimePicker timer;
    Button btAlarme;
    Button btCancel;
    AlarmManager am;
    PendingIntent pi;
    Intent intent;
    Button btSetAlarme;
    ListView lstAlarme;
    ArrayList<AlarmeProg> LesAlarmeProg;
    @Override


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab1alarme, container, false);
        btSetAlarme = rootView.findViewById(R.id.btAlarm);
        lstAlarme = rootView.findViewById(R.id.lstAlarme);
        LesAlarmeProg = new ArrayList<AlarmeProg>();
        AlarmeProg alarmetest = new AlarmeProg();

        lstAlarme.setOnItemClickListener(new AdapterView.OnItemClickListener() { @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            // Nous appelons la méthode startViewActivity en lui donnant
            // la position de l'élément sur lequel nous avons cliqué
            startViewActivity(position);
        }
        });

        /*timer = (TimePicker) rootView.findViewById(R.id.timeMinuteur);
        timer.setIs24HourView(true);
        btAlarme = (Button) rootView.findViewById(R.id.btAlarm);
        btCancel = (Button) rootView.findViewById(R.id.btCancel);
        timer.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener()
        {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                timer.setHour(hourOfDay);
                timer.setMinute(minute);
            }
        });

        btCancel.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                // If the alarm has been set, cancel it.
                /*if (am!= null) {
                    am.cancel(pi);
                    Toast.makeText(getContext(),"Alarme ounesette",Toast.LENGTH_SHORT).show();

                }
                am = (AlarmManager) getActivity().getSystemService(getActivity().ALARM_SERVICE);
                intent = new Intent(getActivity(), Alarm.class);
                pi = PendingIntent.getBroadcast(getActivity(),0,intent,0);

                am.cancel(pi);
                pi.cancel();

                Toast.makeText(getContext(),"Alarme ounesette",Toast.LENGTH_SHORT).show();
            } }) ;
        btAlarme.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                GregorianCalendar cur_cal = new GregorianCalendar();
                cur_cal.setTimeInMillis(System.currentTimeMillis());
                GregorianCalendar cal = new GregorianCalendar();
                cal.set(cur_cal.get(GregorianCalendar.YEAR),
                        cur_cal.get(GregorianCalendar.MONTH),
                        cur_cal.get(GregorianCalendar.DAY_OF_MONTH),
                        timer.getHour(),
                        timer.getMinute(),0);
                setAlarm(cal.getTimeInMillis());

            } }) ;*/

        btSetAlarme.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getContext(), SetAlarmeActivity.class) ;
                startActivity(intent) ;

            } }) ;

        return rootView;
    }
    /*public void setAlarm(long l){
        am = (AlarmManager) getActivity().getSystemService(getActivity().ALARM_SERVICE);
        intent = new Intent(getActivity(), Alarm.class);
        pi = PendingIntent.getBroadcast(getActivity(),0,intent,0);
        am.setRepeating(AlarmManager.RTC_WAKEUP,l,AlarmManager.INTERVAL_DAY, pi);


        Toast.makeText(getContext(),"Alarme set", Toast.LENGTH_SHORT).show();


    }*/


    @Override
    public void onResume() {
        super.onResume();
        ListAdapter listeAdapter = new ListeAdapter(getContext(), LesAlarmeProg) ;

        lstAlarme.setAdapter(listeAdapter) ;
    }

    private void startViewActivity(int position){
        // On récupère l'alarme sur laquelle nous avons cliqué
        // et nous la stockons dans la variable « uneAlarme ».
        AlarmeProg uneAlarme = LesAlarmeProg.get(position);
        // Nous paramétrons les coordonnées sur laquelle nous souhaitons nous rendre
        Intent intent = new Intent(getContext(), SetAlarmeActivity.class) ;
        // Nous passons en paramètre l'horaire
        intent.putExtra("Horaire", uneAlarme.getHoraire());
        // Nous passons en paramètre l'id de l'alarme ?
        //intent.putExtra("", uneCategorie.getId());
        // Nous changeons de page avec les 2 données passées au-dessus.
        startActivity(intent);
    }
}
