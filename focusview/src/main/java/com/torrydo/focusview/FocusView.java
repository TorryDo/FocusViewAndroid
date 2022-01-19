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

import com.google.gson.Gson;

import java.io.Serializable;


public class FocusView {

    public static final int SMALL = 1;
    public static final int MEDIUM = 2;
    public static final int LARGE = 3;
    public static final int XLARGE = 4;


    static final String KEY_ACTIVITY_CONNECTOR = "anhyeuem";

    static FocusViewListener focusViewListener = new DefaultFocusViewListener();

    private final Builder builder;

    FocusView(Builder builder) {
        this.builder = builder;
    }

    public FocusView show() {

        try {
            Intent intent = new Intent(builder.context, FocusViewActivity.class);

            String json = new FocusViewProps().copyBuilder(builder).toGson();

            intent.putExtra(KEY_ACTIVITY_CONNECTOR, json);
            focusViewListener = builder.focusViewListener;

            builder.context.startActivity(intent);
        }catch (Exception e){

        }

        return this;
    }



    // Builder -------------------------------------------------------------------------------------

    public static class Builder extends FocusViewProps {

        Context context;
        View view;

        FocusViewListener focusViewListener = new DefaultFocusViewListener();

        public Builder(Context context) {
            this.context = context;
        }

        public Builder setTargetView(View view) {
            this.view = view;
            return this;
        }

        public Builder setBackgroundAlpha(float backgroundAlpha) {
            this.backgroundAlpha = backgroundAlpha;
            return this;
        }

        public Builder setBackgroundColor(int backgroundColor) {
            this.backgroundColor = backgroundColor;
            return this;
        }

        public Builder setTextColor(int textColor) {
            this.textColor = textColor;
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setContentText(String contentText) {
            this.contentText = contentText;
            return this;
        }

        public Builder addFocusViewListener(FocusViewListener focusViewListener) {
            this.focusViewListener = focusViewListener;
            return this;
        }


        public FocusView build() {
            return new FocusView(this);
        }
    }
}

