package com.renangmarques.inhistory.model;

import lombok.NonNull;

public class Movie extends Referencer {

    @Override
    public @NonNull String getType() {
        return "movie";
    }

}
