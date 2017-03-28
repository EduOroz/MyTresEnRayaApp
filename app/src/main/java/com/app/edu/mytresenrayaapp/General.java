package com.app.edu.mytresenrayaapp;

import android.app.Activity;
import android.content.Intent;

/**
 * Created by Eduardo on 27/03/2017.
 */

public class General {

    public static boolean menu (Activity c, int id) {
        if (id == R.id.action_settings) {
            setActivity(c, SettingsActivity.class);
            return true;
        } else if (id == R.id.action_play) {
            setActivity(c, GameActivity.class);
            return true;
        } else if (id == R.id.action_view_games) {
            setActivity(c, ViewGamesActivity.class);
            return true;
        } else if (id == R.id.action_quit) {
            setActivity(c, LoginActivity.class);
            return true;
        }

        return false;
    }

    public static void setActivity(Activity c, Class c1) {
        Intent intent = new Intent(c, c1);
        c.startActivity(intent);

    }
}