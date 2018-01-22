package com.btsinfo.menu;

import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    String message;
    String ligne = "";
    ArrayList<String> tblAlarme;

    int cpt;
    ListView lstAlarme;
    String[] tempoUneAlarme = new String[3];
    ArrayList<AlarmeProg> LesAlarmeProg;

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            switch(position){
                case 0 :
                    Tab1Alarme tab1 = new Tab1Alarme();
                    return tab1;
                case 1 :
                    Tab2Chrono tab2 = new Tab2Chrono();
                    return tab2;
                case 2 :
                    Tab3Minuteur tab3 = new Tab3Minuteur();
                    return tab3;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Alarme";
                case 1:
                    return "Chronomètre";
                case 2:
                    return "Minuteur";
            }
            return null;
        }

    }
    /*@Override
    public void onResume() {
        super.onResume();

        StringBuffer chaine = new StringBuffer();
        // On lit les données enregistrée
        LesAlarmeProg = new ArrayList<AlarmeProg>();
        try {
            FileInputStream fichier = openFileInput("fichiersource");
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

            lstAlarme = (ListView) findViewById(R.id.lstAlarme);
            ListAdapter listeAdapter = new ListeAdapter(this, LesAlarmeProg);
            lstAlarme.setAdapter(listeAdapter);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }*/

}
