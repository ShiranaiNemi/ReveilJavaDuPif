package com.btsinfo.menu;

import android.content.Context;
import android.widget.ArrayAdapter;

/**
 * Created by Zexenero on 10/01/2018.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Switch;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Zexenero on 15/11/2017.
 */

public class ListeAdapter extends ArrayAdapter<AlarmeProg> {
    Context context;
    ListeAdapter(Context context, List<AlarmeProg> LesAlarmeProg) {
        super(context, -1, LesAlarmeProg);
        this.context = context;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        // Déclaration d'une variable qui va contenir les données d'une personne
        AlarmeProg uneAlarme;
        view = null;
        if (convertView==null){
            LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.liste_ligne_sommaire,parent, false);
        } else{
            view = convertView;
        }
        // Permet de mettre dans la variable
        // Un élément de la liste
        uneAlarme = getItem(position);
        // Faire le lien entre la variable Java et le composant « TextView » de l'interface
        TextView texteListe = (TextView) view.findViewById(R.id.textListeHoraire);
        // idem mais switch
        Switch btActif = (Switch) view.findViewById(R.id.btActif);
        // Mettre le titre récupéré dans le composant « TextView »
        texteListe.setText(uneAlarme.getHoraire());
        btActif.setChecked(uneAlarme.isActif());
        return view;}
    @Override
    public long getItemId(int position) {
        return getItem(position).id;
    }

}
