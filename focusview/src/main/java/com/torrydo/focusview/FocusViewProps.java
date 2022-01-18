package com.torrydo.focusview;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Size;
import android.view.View;

import java.io.Serializable;

class FocusViewProps implements Parcelable {

    // get from view
    Bitmap targetBitmap = null;
    Size targetSize = new Size(0, 0);
    Point targetPoint = new Point(0, 0);

    float backgroundAlpha = 0.8f;
    int backgroundColor = -1;
    int textColor = -1;
    String title = "";
    String contentText = "";

    FocusViewProps(){}

    // ------------------------------------------------------------------------

    protected FocusViewProps(Parcel in) {
        targetBitmap = in.readParcelable(Bitmap.class.getClassLoader());
        targetSize = in.readSize();
        targetPoint = in.readParcelable(Point.class.getClassLoader());
        backgroundAlpha = in.readFloat();
        backgroundColor = in.readInt();
        textColor = in.readInt();
        title = in.readString();
        contentText = in.readString();
    }

    public static final Creator<FocusViewProps> CREATOR = new Creator<FocusViewProps>() {
        @Override
        public FocusViewProps createFromParcel(Parcel in) {
            return new FocusViewProps(in);
        }

        @Override
        public FocusViewProps[] newArray(int size) {
            return new FocusViewProps[size];
        }
    };

    final FocusViewProps copyBuilder(FocusView.Builder builder){
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(targetBitmap, flags);
        dest.writeSize(targetSize);
        dest.writeParcelable(targetPoint, flags);
        dest.writeFloat(backgroundAlpha);
        dest.writeInt(backgroundColor);
        dest.writeInt(textColor);
        dest.writeString(title);
        dest.writeString(contentText);
    }
}
