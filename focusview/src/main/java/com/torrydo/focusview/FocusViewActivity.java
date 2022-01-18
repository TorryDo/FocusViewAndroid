package com.torrydo.focusview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;

public class FocusViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_focus_view);

        View view = findViewById(R.id.focusView);

        Gson propsJson = new Gson();
        String jsonStr = getIntent().getStringExtra(FocusView.KEY_ACTIVITY_CONNECTOR);
//
        FocusViewProps props = propsJson.fromJson(jsonStr, FocusViewProps.class);

        if(props.getTargetBitmap() != null) Toast.makeText(this, "bitmap != null", Toast.LENGTH_SHORT).show();

        FocusView.focusViewListener.onShow();

        view.setAlpha(props.getBackgroundAlpha());

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        FocusView.focusViewListener.onExit();
    }
}