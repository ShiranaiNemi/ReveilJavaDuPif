package com.btsinfo.menu;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Locale;


public class SetAlarmeActivity extends AppCompatActivity {

    TimePicker timer;
    Button btAlarme;
    Button btCancel;
    AlarmManager am;
    PendingIntent pi;
    Intent intent;
    String message;
    String ligne = "";
    TextView testView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_alarme);
        timer = (TimePicker) findViewById(R.id.timeMinuteur);
        timer.setIs24HourView(true);
        btAlarme = (Button) findViewById(R.id.btValider);
        btCancel = (Button) findViewById(R.id.btCancel);
        testView = (TextView) findViewById(R.id.tvTest);
        timer.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                timer.setHour(hourOfDay);
                timer.setMinute(minute);
            }
        });
        btAlarme.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                GregorianCalendar cur_cal = new GregorianCalendar();
                cur_cal.setTimeInMillis(System.currentTimeMillis());
                GregorianCalendar cal = new GregorianCalendar();
                cal.set(cur_cal.get(GregorianCalendar.YEAR),
                        cur_cal.get(GregorianCalendar.MONTH),
                        cur_cal.get(GregorianCalendar.DAY_OF_MONTH),
                        timer.getHour(),
                        timer.getMinute(), 0);
                        //setAlarm(cal.getTimeInMillis());
                DateFormat dateFormat = new SimpleDateFormat("HH:mm", Locale.FRANCE);
                java.util.Date dateDate = cal.getTime();
                String retour = dateFormat.format(dateDate);
                testView.setText(retour);
                /*

                //message = ;
                StringBuffer chaine = new StringBuffer();
                try {
                    chaine.append(message+"\n");
                    FileOutputStream fichier = openFileOutput("fichiersource",MODE_PRIVATE);
                    fichier.write(chaine.toString().getBytes());
                    fichier.close() ;
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }*/
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

                Toast.makeText(getContext(),"Alarme ounesette",Toast.LENGTH_SHORT).show();*/
                finish();
            } }) ;
    }
        public void setAlarm(long l){
        am = (AlarmManager) this.getSystemService(this.ALARM_SERVICE);
        intent = new Intent(this, Alarm.class);
        pi = PendingIntent.getBroadcast(this,0,intent,0);
        am.setRepeating(AlarmManager.RTC_WAKEUP,l,AlarmManager.INTERVAL_DAY, pi);


        Toast.makeText(this,"Alarme set", Toast.LENGTH_SHORT).show();

    }



}

