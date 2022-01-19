package com.torrydo.focusview;

import com.google.gson.Gson;

// singleton
class Single {

    private static Gson gson;

    public static Gson getGson() {
        if (gson == null) gson = new Gson();
        return gson;
    }


}
