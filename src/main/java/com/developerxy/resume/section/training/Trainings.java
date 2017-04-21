package com.developerxy.resume.section.training;

import java.lang.annotation.*;

/**
 * Created by Mohammed Aouf ZOUAG on 18/04/2017.
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Trainings {
    String label() default "Training";
    Training[] value();
}
