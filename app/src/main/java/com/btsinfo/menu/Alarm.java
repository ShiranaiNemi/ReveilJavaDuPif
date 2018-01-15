package com.btsinfo.menu;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;

/**
 * Created by Zexenero on 29/11/2017.
 */

// Ptn ça marche - PASTORE LA POTAOE AU MILEU DES FRITES
// Ptn ça marche
// oui c'est fou ketchup/20
// Ptn ça marche - PASTORE LA POTATOE

public class Alarm extends BroadcastReceiver {
    MediaPlayer mp;
    @Override
    public void onReceive(Context context, Intent intent) {
        mp = MediaPlayer.create(context, R.raw.alarm);
        mp.start();

    }
}
