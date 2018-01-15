package com.btsinfo.menu;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;

/**
 * Created by Zexenero on 29/11/2017.
 */

// Ptn ça marche
// oui c'est fou ketchup/20
=======
// Ptn ça marche - PASTORE LA POTATOE

>>>>>>> 02da8ea0f3949d9fb9e0f3aacdeb69b762b1bb8a
public class Alarm extends BroadcastReceiver {
    MediaPlayer mp;
    @Override
    public void onReceive(Context context, Intent intent) {
        mp = MediaPlayer.create(context, R.raw.alarm);
        mp.start();

    }
}
