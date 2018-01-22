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
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
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
    String message;
    String ligne = "";
    ArrayList<String> tblAlarme = new ArrayList<String>();
    int horaireId;
    int alarmeHeure;
    int alarmeActif;
    int alarmeId;
    int cpt;
    String[] tempoUneAlarme = new String[3];
    AlarmeProg uneAlarme = new AlarmeProg();
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


        btSetAlarme.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                Intent intent = new Intent(getContext(), SetAlarmeActivity.class) ;
                startActivity(intent) ;

            } }) ;

        StringBuffer chaine = new StringBuffer();
        // On lit les données enregistrée
        try {
            ligne = "";
            FileInputStream fichier = getActivity().openFileInput("fichiersource");
            InputStreamReader lire = new InputStreamReader(fichier);
            BufferedReader tampon = new BufferedReader(lire);
            cpt = 0;
            while ((ligne = tampon.readLine()) != null){
                // On transfert les données enregistrés
                chaine.append(ligne+"\n");
                tblAlarme.add(ligne);
                cpt++;
            }
            for(String tempoUneAlarme : tblAlarme) // On traite les données enregistrés
            {

                //testtempoUneAlarme = tempoUneAlarme.split("!");

                uneAlarme.setHoraire(tempoUneAlarme.split("!")[2]);

                uneAlarme.setId(Long.parseLong(tempoUneAlarme.split("!")[0]));

                if (tempoUneAlarme.split("!")[1].equals("1"))
                {
                    uneAlarme.setActif(true);
                }
                else
                {
                    uneAlarme.setActif(false);
                }




                LesAlarmeProg.add(uneAlarme);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        ListAdapter listeAdapter = new ListeAdapter(getContext(), LesAlarmeProg) ;
        lstAlarme.setAdapter(listeAdapter) ;

        return rootView;
    }


    /*@Override
    public void onResume() {
        super.onResume();

        StringBuffer chaine = new StringBuffer();
        // On lit les données enregistrée
        try {
            FileInputStream fichier = getContext().openFileInput("fichiersource");
            InputStreamReader lire = new InputStreamReader(fichier);
            BufferedReader tampon = new BufferedReader(lire);
            cpt = 0;
            while ((ligne = tampon.readLine()) != null){
                // On transfert les données enregistrés
                chaine.append(ligne+"\n");
                tblAlarme.add(ligne);
                cpt++;
            }
            for(String tempoUneAlarme: tblAlarme) // On traite les données enregistrés
            {

                //testtempoUneAlarme = tempoUneAlarme.split("!");
                AlarmeProg uneAlarme = new AlarmeProg();
                uneAlarme.setHoraire(tempoUneAlarme.split("!")[0]);
                uneAlarme.setActif(Boolean.parseBoolean(tempoUneAlarme.split("!")[1]));
                uneAlarme.setId(Long.parseLong(tempoUneAlarme.split("!")[2]));
                LesAlarmeProg.add(uneAlarme);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



        ListAdapter listeAdapter = new ListeAdapter(getContext(), LesAlarmeProg) ;
        lstAlarme.setAdapter(listeAdapter) ;
    }*/

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
