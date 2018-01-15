package com.btsinfo.menu;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.GregorianCalendar;


public class SetAlarmeActivity extends AppCompatActivity {

    TimePicker timer;
    Button btAlarme;
    Button btCancel;
    AlarmManager am;
    PendingIntent pi;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_alarme);
        timer = (TimePicker) findViewById(R.id.timeMinuteur);
        timer.setIs24HourView(true);
        btAlarme = (Button) findViewById(R.id.btAlarm);
        btCancel = (Button) findViewById(R.id.btCancel);
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
                setAlarm(cal.getTimeInMillis());

            }
        });
    }
        public void setAlarm(long l){
        am = (AlarmManager) this.getSystemService(this.ALARM_SERVICE);
        intent = new Intent(this, Alarm.class);
        pi = PendingIntent.getBroadcast(this,0,intent,0);
        am.setRepeating(AlarmManager.RTC_WAKEUP,l,AlarmManager.INTERVAL_DAY, pi);


        Toast.makeText(this,"Alarme set", Toast.LENGTH_SHORT).show();


    }


}

