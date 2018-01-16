package com.btsinfo.menu;

/**
 * Created by Zexenero on 10/01/2018.
 */

public class AlarmeProg {



    public String getHoraire() {
        return horaire;
    }

    public void setHoraire(String horaire) {
        this.horaire = horaire;
    }

    String horaire;

    public boolean isActif() {
        return actif;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
    }

    boolean actif;
    long id;
}
