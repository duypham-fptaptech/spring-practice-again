package com.example.springpracticeagain.enums;

public enum StreetStatus {
    USING(1), REPAIR(-1), CONSTRUCTION(0);

    public final Integer value;

    StreetStatus(Integer value) {
        this.value = value;
    }
}
