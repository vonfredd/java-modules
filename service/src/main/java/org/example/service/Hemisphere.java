package org.example.service;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Hemisphere {
    enum Direction {
        NORTHERN,
        SOUTHERN,
        EASTERN,
        WESTERN
    }
}
