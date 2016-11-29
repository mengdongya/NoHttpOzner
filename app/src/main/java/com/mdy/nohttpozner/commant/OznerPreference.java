package com.mdy.nohttpozner.commant;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by cecha on 2016/11/29.
 */

public class OznerPreference {
    public static final String Ozner = "Ozner";
    public final static String ServerAddress = "serveraddress";

    private static SharedPreferences Init(Context context) {
        if (context != null)
            return context.getSharedPreferences(Ozner, Context.MODE_PRIVATE);
        else
            return null;
    }

    private static SharedPreferences.Editor InitEditor(Context context) {
        if (context != null)
            return context.getSharedPreferences(Ozner, Context.MODE_PRIVATE).edit();
        else
            return null;
    }


    public static String serverAddr(Context context) {
        SharedPreferences sh = OznerPreference.Init(context);
        if (sh != null) {
            if (sh.getString(ServerAddress, null) == null) {
                SharedPreferences.Editor editor = InitEditor(context);
                editor.putString(ServerAddress, "http://app.ozner.net:888/");
                return "http://app.ozner.net:888/";
            } else {
                return sh.getString(ServerAddress, null);
            }
        }
        return "http://app.ozner.net:888/";
    }
}
