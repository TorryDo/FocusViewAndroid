package com.torrydo.focusview;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class FocusViewActivity extends AppCompatActivity {

    ImageView focusView;
    ImageView targetView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_focus_view);

        focusView = findViewById(R.id.focusView);
        targetView = findViewById(R.id.targetView);

        String focusViewPropsJson = getIntent().getStringExtra(FocusView.KEY_ACTIVITY_CONNECTOR);

        if (focusViewPropsJson != null){

            FocusViewProps props = Single.getGson().fromJson(focusViewPropsJson, FocusViewProps.class);

            if (props != null) {
                configFocusView(props);
                configTargetView(props);
            }
        }

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        FocusView.focusViewListener.onDestroy();
        focusView = null;
    }

    // ---------------------------------------------------------------------------------------------

    private void configFocusView(FocusViewProps props) {

        FocusView.focusViewListener.onCreate();

        focusView.setAlpha(props.getBackgroundAlpha());

        focusView.getBackground().setColorFilter(
                new PorterDuffColorFilter(props.getBackgroundColor(), PorterDuff.Mode.SRC_IN)
        );
    }

    private void configTargetView(FocusViewProps props){

        targetView.setImageBitmap(props.getTargetBitmap());
        targetView.setX(props.getViewPoint().x);
        targetView.setY(props.getViewPoint().y);



        targetView.post(new Runnable() {
            @Override
            public void run() {

                float widthDp = Utils.convertPixelsToDp(targetView.getWidth(), FocusViewActivity.this);
                float heightDp = Utils.convertPixelsToDp(targetView.getHeight(), FocusViewActivity.this);

                Log.d("<> wh in dp ", widthDp +" " +heightDp);
            }
        });


    }
}