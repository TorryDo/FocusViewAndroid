package com.torrydo.focusview;

import android.graphics.Point;
import android.view.View;

class ScreenUtils {

    public static Point getViewLocation(View view) {
        int[] xy = new int[2];
        view.getLocationOnScreen(xy);
        return new Point(xy[0], xy[1]);
    }
}
