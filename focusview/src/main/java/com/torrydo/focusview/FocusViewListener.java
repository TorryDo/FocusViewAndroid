package com.torrydo.focusview;

import android.util.Log;

public interface FocusViewListener {

    void onCreate();

    void onDestroy();

}

class DefaultFocusViewListener implements FocusViewListener{

    @Override
    public void onCreate() {
        Log.d("FocusViewListener", "onShow");
    }

    @Override
    public void onDestroy() {
        Log.d("FocusViewListener", "onExit");
    }
}
