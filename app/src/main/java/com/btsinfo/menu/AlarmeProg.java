package com.btsinfo.menu;

/**
 * Created by Zexenero on 10/01/2018.
 */

public class AlarmeProg {

    public int getActif() {
        return actif;
    }

    public void setActif(int actif) {
        this.actif = actif;
    }

    public String getHoraire() {
        return horaire;
    }

    public void setHoraire(String horaire) {
        this.horaire = horaire;
    }

    String horaire;
    int actif;
    long id;
}
