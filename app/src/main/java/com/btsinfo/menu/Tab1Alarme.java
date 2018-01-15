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
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.GregorianCalendar;

public class Tab1Alarme extends Fragment{
    TimePicker timer;
    Button btAlarme;
    Button btCancel;
    AlarmManager am;
    PendingIntent pi;
    Intent intent;
    @Override


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab1alarme, container, false);
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

        return rootView;
    }
    /*public void setAlarm(long l){
        am = (AlarmManager) getActivity().getSystemService(getActivity().ALARM_SERVICE);
        intent = new Intent(getActivity(), Alarm.class);
        pi = PendingIntent.getBroadcast(getActivity(),0,intent,0);
        am.setRepeating(AlarmManager.RTC_WAKEUP,l,AlarmManager.INTERVAL_DAY, pi);


        Toast.makeText(getContext(),"Alarme set", Toast.LENGTH_SHORT).show();


    }*/



}
