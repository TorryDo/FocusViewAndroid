package com.torrydo.focusview;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.util.Size;
import android.view.View;

class FocusViewProps {

    // get from view
    Bitmap targetBitmap = null;
    Size targetSize = new Size(0, 0);
    Point targetPoint = new Point(0, 0);

    float backgroundAlpha = 0.5f;
    int backgroundColor = -1;
    int textColor = -1;
    String title = "";
    String contentText = "";


    final FocusViewProps copyBuilder(FocusView.Builder builder) {

        View tempView = builder.view;

        targetBitmap = Utils.getBitmapFromView(tempView);
        targetSize = new Size(tempView.getWidth(), tempView.getHeight());
        targetPoint = new Point((int) tempView.getX(), (int) tempView.getY());

        backgroundAlpha = builder.backgroundAlpha;
        backgroundColor = builder.backgroundColor;
        textColor = builder.textColor;
        title = builder.title;
        contentText = builder.contentText;

        tempView = null;

        return this;
    }

    final String toGson(){
        return Utils.getGson().toJson(this);
    }


    // -----------------------------------------------------------

    public Bitmap getTargetBitmap() {
        return targetBitmap;
    }

    public Size getTargetSize() {
        return targetSize;
    }

    public Point getTargetPoint() {
        return targetPoint;
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
