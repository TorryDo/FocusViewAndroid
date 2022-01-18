package com.torrydo.focusview;

import android.util.Log;

public interface FocusViewListener {

    void onShow();

    void onExit();

}

class DefaultFocusViewListener implements FocusViewListener{

    @Override
    public void onShow() {
        Log.d("FocusViewListener", "onShow");
    }

    @Override
    public void onExit() {
        Log.d("FocusViewListener", "onExit");
    }
}
