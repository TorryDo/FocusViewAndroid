package com.torrydo.focusview;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.PointF;
import android.util.SizeF;
import android.view.View;

class FocusViewProps {

    Bitmap targetBitmap = null;
    PointF viewPoint = new PointF(0, 0);

    float backgroundAlpha = 1f;
    int backgroundColor = 0xff000000;
    int textColor = -1;
    String title = "";
    String contentText = "";


    final FocusViewProps copyBuilder(FocusView.Builder builder) {

        backgroundAlpha = builder.backgroundAlpha;
        backgroundColor = builder.backgroundColor;
        textColor = builder.textColor;
        title = builder.title;
        contentText = builder.contentText;

        // ------------------

        View tempView = builder.view;
        targetBitmap = ViewHelper.getBitmapFromView(tempView);

        Point tempPoint = ViewHelper.getViewLocation(tempView);
        SizeF tempSizeF = new SizeF(tempView.getWidth(), tempView.getHeight());

        viewPoint = new PointF(tempPoint.x, tempPoint.y);


        return this;
    }

    final String toGson(){
        return Single.getGson().toJson(this);
    }


    // -----------------------------------------------------------

    public Bitmap getTargetBitmap() {
        return targetBitmap;
    }

    public PointF getViewPoint() {
        return viewPoint;
    }

    public float getBackgroundAlpha() {
        return backgroundAlpha;
    }

    public int getBackgroundColor() {
        return backgroundColor;
    }

    public int getTextColor() {
        return textColor;
    }

    public String getTitle() {
        return title;
    }

    public String getContentText() {
        return contentText;
    }

    // ------------------------------------------------------------------------

}
