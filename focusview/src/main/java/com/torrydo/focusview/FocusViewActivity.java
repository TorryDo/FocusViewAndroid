package com.torrydo.focusview;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

class FocusViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_focus_view);

        View focusView = findViewById(R.id.focusView);

//        FocusView.Builder builder = (FocusView.Builder) getIntent().getSerializableExtra(FocusView.KEY_ACTIVITY_CONNECTOR);
//
//        focusView.setAlpha(builder.backgroundAlpha);

    }
}