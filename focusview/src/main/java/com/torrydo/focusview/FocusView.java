package com.torrydo.focusview;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.util.Size;
import android.view.View;

import java.io.Serializable;


public class FocusView {

    public static final int SMALL = 1;
    public static final int MEDIUM = 2;
    public static final int LARGE = 3;
    public static final int XLARGE = 4;


    public static final String KEY_ACTIVITY_CONNECTOR = "<><>";

    private Builder builder;


    FocusView(Builder builder) {
        this.builder = builder;
    }

    public FocusView show() {

        Intent intent = new Intent(builder.context, FocusViewActivity.class);

        FocusViewProps props = new FocusViewProps().copyBuilder(builder);

        intent.putExtra(KEY_ACTIVITY_CONNECTOR, props);

        builder.context.startActivity(intent);
        return this;
    }

    // --------------------------------------------------


    public static class Builder extends FocusViewProps {

        Context context;
        View view;


        public Builder(Context context) {
            this.context = context;
        }


        public Builder setTargetView(View view) {
            this.view = view;

            return this;
        }


        public FocusView build() {
            return new FocusView(this);
        }
    }
}


//    private Logger logger = new Logger()
//            .setDebugEnabled(Constants.isDebugEnabled)
//            .setTag(this.getClass().getSimpleName());
