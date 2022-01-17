package com.torrydo.focusview;

import android.content.Context;
import android.graphics.Point;
import android.view.View;

public class FocusView {


    private Point viewPoint = new Point(0, 0);

    public FocusView show(){
        return this;
    }


    public static class Builder{
        private Context _context;
        private View _view;
        private String _message;

        public Builder(Context context){
            _context = context;
        }


        public Builder setView(View view){
            _view = view;
            return this;
        }

        public Builder setMessage(String message){
            _message = message;
            return this;
        }

        public FocusView build(){
            return new FocusView();
        }
    }
}
