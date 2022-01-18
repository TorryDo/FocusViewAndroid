package com.torrydo.focusview;

import android.util.Log;

class Logger {

    public boolean isDebugEnabled = Constants.isDebugEnabled;
    public String TAG = "<> unNamed";

    public Logger setTag(String name){
        TAG = "<> " + name;
        return this;
    }

    public Logger setDebugEnabled(boolean enabled){
        isDebugEnabled = enabled;
        return this;
    }

    public void e(String message){
        if(isDebugEnabled){
            Log.e(TAG, message);
        }
    }

    public void d(String message){
        if(isDebugEnabled){
            Log.d(TAG, message);
        }
    }


}
