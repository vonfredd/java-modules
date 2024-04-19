package org.example.service;

import java.lang.annotation.*;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Hemisphere {
    Direction[] value();
}
